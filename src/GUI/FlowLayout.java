package GUI;

import javax.swing.*;
import java.awt.*;

public class FlowLayout {
    public static void main(String[] args) {
        FlowLayout fl = new FlowLayout();
        fl.drawFLow();
    }

    public void drawFLow(){
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setBackground(Color.gray);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JButton btn = new JButton("shock me");
        JButton btn2 = new JButton("bliss");
        JButton btn3 = new JButton("huh?");

        panel.add(btn);
        panel.add(btn2);
        panel.add(btn3);
        frame.getContentPane().add(BorderLayout.EAST, panel);

        frame.setSize(250, 200);
        frame.setVisible(true);
    }
}
