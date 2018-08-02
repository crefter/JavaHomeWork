package MIDIApp;

import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;

public class MiniMusicPlayer1 {
    static JFrame f = new JFrame("Мой первый музыкальный клип");
    static MusicDrawPanel mdp;

    public static void main(String[] args) {
        MiniMusicPlayer1 mmp1 = new MiniMusicPlayer1();
        mmp1.playMusic();
    }

    public void setUpGui(){
        mdp = new MusicDrawPanel();
        f.setContentPane(mdp);
        f.setBounds(30,30, 480, 360);
        f.setVisible(true);
    }

    public void playMusic(){

        setUpGui();

        try {

            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();

            int[] eventsWant = {127};
            sequencer.addControllerEventListener(mdp, eventsWant);

            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();

            int r = 0;

            for (int i = 5; i < 61; i+=4){

                r = (int) ((Math.random() * 50) + 1);
                track.add(makeEvent(144, 1, r, 100, i));
                track.add(makeEvent(176, 1, 127, 0, i));
                track.add(makeEvent(128, 1, r, 100, i + 2));
            }

            sequencer.setSequence(seq);
            sequencer.setTempoInBPM(120);
            sequencer.start();

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    static MidiEvent makeEvent(int comd, int chan, int one, int two, int tick){
        MidiEvent midiEvent = null;

        try {

            ShortMessage a = new ShortMessage();
            a.setMessage(comd, chan, one, two);
            midiEvent = new MidiEvent(a, tick);

        }catch (Exception e){
            e.printStackTrace();
        }

        return midiEvent;
    }

    class MusicDrawPanel extends JPanel implements ControllerEventListener {

        boolean msg = false;

        @Override
        public void controlChange(ShortMessage event) {
            msg = true;
            repaint();
        }

        public void paintComponent(Graphics g){
            if (msg) {
                Graphics2D g2d = (Graphics2D) g;

                int r = (int) (Math.random() * 250);
                int gr = (int) (Math.random() * 250);
                int b = (int) (Math.random() * 250);
                g.setColor(new Color(r, gr, b));

                int ht = (int) ((Math.random() * 120) + 10);
                int wight = (int) ((Math.random() * 120) + 10);
                int x = (int) ((Math.random() * 40) + 10);
                int y = (int) ((Math.random() * 40) + 10);
                g.fillRect(x,y,wight,ht);
                msg = false;
            }
        }
    }
}
