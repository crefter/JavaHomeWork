package GUI.BeatBox;

import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class BeatBox {

    private ArrayList<JCheckBox> checkBoxList;
    private Sequencer sequencer;
    private Sequence sequence;
    private Track track;

    private String[] instrumentNames = {"Bass Drum", "Closed Hi-Hat", "Open Hi-Hat",
            "Acoustic Snare", "Crash Cymbal", "Hand Clap", "High Tom", "Hi Bongo",
            "Maracas", "Whistle", "Low Conga", "Cowbell", "Vibraslap", "Low-mid Tom",
            "High Agogo", "Open Hi Conga"};
    private int[] instruments = {35, 42, 46, 38, 49, 39, 50, 60, 70, 72, 64, 56, 58, 47, 67, 63};

    public static void main(String[] args) {
        new BeatBox().buildGUI();
    }

    private void buildGUI(){
        JFrame frame = new JFrame("BeatBox machine");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BorderLayout layout = new BorderLayout();
        JPanel background = new JPanel(layout);
        background.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        checkBoxList = new ArrayList<JCheckBox>();
        Box buttonBox = new Box(BoxLayout.Y_AXIS);

        JButton start = new JButton("Start");
        start.addActionListener(new MyStartListener());
        buttonBox.add(start);

        JButton stop = new JButton("Stop");
        stop.addActionListener(new MyStopListener());
        buttonBox.add(stop);

        JButton upTempo = new JButton("Tempo up");
        upTempo.addActionListener(new MyUpTempoListener());
        buttonBox.add(upTempo);

        JButton downTempo = new JButton("Tempo down");
        downTempo.addActionListener(new MyDownTempoListener());
        buttonBox.add(downTempo);

        JButton serialize = new JButton("Save");
        serialize.addActionListener(new MySendListener());
        buttonBox.add(serialize);

        JButton read = new JButton("Read");
        read.addActionListener(new MyReadListener());
        buttonBox.add(read);

        Box nameBox = new Box(BoxLayout.Y_AXIS);
        for (int i = 0; i < 16; i++){
            nameBox.add(new Label(instrumentNames[i]));
        }

        background.add(BorderLayout.EAST, buttonBox);
        background.add(BorderLayout.WEST, nameBox);

        frame.getContentPane().add(background);

        GridLayout gridLayout = new GridLayout(16, 16);
        gridLayout.setVgap(1);
        gridLayout.setHgap(2);

        JPanel mainPanel = new JPanel(gridLayout);
        background.add(BorderLayout.CENTER, mainPanel);

        for (int i = 0; i < 256; i++){
            JCheckBox c = new JCheckBox();
            c.setSelected(false);
            checkBoxList.add(c);
            mainPanel.add(c);
        }

        setUpMidi();

        frame.setBounds(50,50,480,360   );
        frame.pack();
        frame.setVisible(true);
    }

    private void setUpMidi(){
        try {
            sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequence = new Sequence(Sequence.PPQ, 4);
            track = sequence.createTrack();
            sequencer.setTempoInBPM(120);
        } catch (Exception e) {e.printStackTrace();}
    }

    private void buildTrackAndStart(){
        int[] trackList;

        sequence.deleteTrack(track);
        track = sequence.createTrack();

        for (int i = 0; i < 16; i++){
            trackList = new int[16];

            int key = instruments[i];

            for (int j = 0; j < 16; j++){
                JCheckBox jc = checkBoxList.get(j + (16*i));
                if (jc.isSelected()){
                    trackList[j] = key;
                } else {
                    trackList[j] = 0;
                }
            }

            makeTracks(trackList);
            track.add(makeEvent(176, 1, 127, 0, 16));
        }

        track.add(makeEvent(192, 9, 1, 0, 15));

        try {
            sequencer.setSequence(sequence);
            sequencer.setLoopCount(sequencer.LOOP_CONTINUOUSLY);
            sequencer.start();
            sequencer.setTempoInBPM(120);
        } catch (Exception e) { e.printStackTrace(); }
    }

    public class MyStartListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            buildTrackAndStart();
        }
    }

    public class MyStopListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            sequencer.stop();
        }
    }

    public class MyUpTempoListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            float tempoFactor = sequencer.getTempoFactor();
            sequencer.setTempoFactor((float) (tempoFactor * 1.03));
        }
    }

    public class MyDownTempoListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            float tempoFactor = sequencer.getTempoFactor();
            sequencer.setTempoFactor((float) (tempoFactor * .97));
        }
    }

    public class MySendListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            boolean[] checkBoxState = new boolean[256];

            for (int i = 0; i < 256; i++) {
                JCheckBox jc = (JCheckBox) checkBoxList.get(i);
                if (jc.isSelected()) {
                    checkBoxState[i] = true;
                }
            }

            try {
                FileOutputStream fs = new FileOutputStream(new File("Checkbox.ser"));
                ObjectOutputStream os = new ObjectOutputStream(fs);
                os.writeObject(checkBoxState);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public class MyReadListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            boolean[] checkBoxState = null;
            try{
                FileInputStream fi = new FileInputStream(new File("Checkbox.ser"));
                ObjectInputStream oi = new ObjectInputStream(fi);
                checkBoxState = (boolean[]) oi.readObject();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            for (int i = 0; i < 256; i++) {
                JCheckBox checkBox = (JCheckBox) checkBoxList.get(i);
                if (checkBoxState[i]) {
                    checkBox.setSelected(true);
                } else {
                    checkBox.setSelected(false);
                }
            }

            sequencer.stop();
            buildTrackAndStart();
        }
    }

    private void makeTracks(int[] list) {

        for (int i = 0; i < 16; i++){
            int key = list[i];

            if (key != 0) {
                track.add(makeEvent(144, 9, key, 100, i));
                track.add(makeEvent(128, 9, key, 100, i+1));
            }
        }
    }

    private MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
        MidiEvent event = null;

        try {
            ShortMessage a = new ShortMessage();
            a.setMessage(comd, chan, one, two);
            event = new MidiEvent(a, tick);
        } catch (Exception e) { e.printStackTrace(); }

        return event;
    }
}