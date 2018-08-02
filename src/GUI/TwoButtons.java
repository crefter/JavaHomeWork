package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TwoButtons {
    JFrame frame;
    JLabel label;


    public static void main(String[] args) {
        TwoButtons tb = new TwoButtons();
        tb.go();
    }

    public void go(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton labelBtn = new JButton("Change Label");
        labelBtn.addActionListener(new LabelListener());

        JButton colorBtn = new JButton("Change color");
        colorBtn.addActionListener(new ColorListener());

        label = new JLabel("I`m a label");
        MyDrawPanel mdp = new MyDrawPanel();

        frame.getContentPane().add(BorderLayout.SOUTH, colorBtn);
        frame.getContentPane().add(BorderLayout.CENTER, mdp);
        frame.getContentPane().add(BorderLayout.EAST, labelBtn);
        frame.getContentPane().add(BorderLayout.WEST, label);

        frame.setSize(480, 360);
        frame.setVisible(true);
    }

    class LabelListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            label.setText("Heheh!");
        }
    }

    class ColorListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            frame.repaint();
        }

    }
}
