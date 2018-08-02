package GUI.Chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SimpleChatClient {

    private BufferedReader reader;
    private JTextArea incoming;
    private JTextField outgoing;
    private PrintWriter printWriter;
    private Socket socket;

    public void go() {
        JFrame frame = new JFrame("Chat client");
        JPanel panel = new JPanel();
        incoming = new JTextArea(15, 50);
        incoming.setLineWrap(true);
        incoming.setWrapStyleWord(true);
        incoming.setEditable(false);
        JScrollPane qScroller = new JScrollPane(incoming);
        qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        outgoing = new JTextField(20);
        JButton send = new JButton("Send");
        send.addActionListener(new SendButtonListener());
        panel.add(qScroller);
        panel.add(outgoing);
        panel.add(send);

        setUpNetworking();

        Thread readerThread = new Thread(new IncomingReader());
        readerThread.start();

        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setSize(500, 600);
        frame.setVisible(true);
    }

    private void setUpNetworking() {
        try {
            socket = new Socket("127.0.0.1", 5002);
            InputStreamReader streamReader = new InputStreamReader(socket.getInputStream());
            reader = new BufferedReader(streamReader);
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

    public class IncomingReader implements Runnable {

        public void run() {
            String msg;
            try {
                while ((msg = reader.readLine()) != null) {
                    System.out.println("read " + msg);
                    incoming.append(msg + "\n");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
