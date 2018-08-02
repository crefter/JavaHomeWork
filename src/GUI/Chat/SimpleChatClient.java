package GUI.Chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.net.Socket;

public class SimpleChatClient {

    private JTextField outgoing;
    private PrintWriter printWriter;
    private Socket socket;

    public void go() {
        JFrame frame = new JFrame("Chat client");
        JPanel panel = new JPanel();
        outgoing = new JTextField(20);
        JButton send = new JButton("Send");
        send.addActionListener(new SendButtonListener());
        panel.add(outgoing);
        panel.add(send);
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        setUpNetworking();
        frame.setSize(400, 500);
        frame.setVisible(true);
    }

    private void setUpNetworking() {
        try {
            socket = new Socket("127.0.0.1", 5000);
            printWriter = new PrintWriter(socket.getOutputStream());
            System.out.println("networking established");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public class SendButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                printWriter.println(outgoing.getText());
                printWriter.flush();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            outgoing.setText("");
            outgoing.requestFocus();
        }
    }

    public static void main(String[] args) {
        new SimpleChatClient().go();
    }
}
