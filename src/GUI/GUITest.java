package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUITest implements ActionListener {
    JFrame frame;

    public static void main(String[] args){
        GUITest gui = new GUITest();
        gui.go();
    }

    public void go(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton button = new JButton("Change colors");
        MyDrawPanel myDrawPanel = new MyDrawPanel();

        button.addActionListener(this);

        frame.getContentPane().add(BorderLayout.SOUTH, button);
        frame.getContentPane().add(myDrawPanel);
        frame.setSize(480, 360);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.repaint();
    }
}
