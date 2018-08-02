package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextArea implements ActionListener {

    JTextArea ta;

    public static void main(String[] args) {
        new TextArea().go();
    }

    void go(){
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JButton btn = new JButton("click me");
        btn.addActionListener(this);
        ta = new JTextArea(10, 20);

        JScrollPane scrollPane = new JScrollPane(ta);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        panel.add(scrollPane);

        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.getContentPane().add(BorderLayout.SOUTH, btn);
        frame.setSize(480, 360);
        frame.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ta.append("btn clicked \n");
    }
}
