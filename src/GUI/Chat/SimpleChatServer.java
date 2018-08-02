package GUI.Chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

public class SimpleChatServer {

    ArrayList<PrintWriter> clientOutputStreams;

    public class ClientHandler implements Runnable {
        BufferedReader reader;
        Socket socket;

        public ClientHandler(Socket sock) {
            try {
                socket = sock;
                InputStreamReader is = new InputStreamReader(socket.getInputStream());
                reader = new BufferedReader(is);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void run() {
            String msg;
            try {
                while ((msg = reader.readLine()) != null) {
                    System.out.println("read " + msg);
                    tellEveryone(msg);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        new SimpleChatServer().go();
    }

    private void go() {
        clientOutputStreams = new ArrayList<PrintWriter>();
        try {
            ServerSocket serverSocket = new ServerSocket(5002);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                PrintWriter pw = new PrintWriter(clientSocket.getOutputStream());
                clientOutputStreams.add(pw);

                Thread t = new Thread(new ClientHandler(clientSocket));
                t.start();
                System.out.println("got a connection");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void tellEveryone(String msg) {
        Iterator<PrintWriter> iterator = clientOutputStreams.iterator();
        while (iterator.hasNext()) {
            try {
                PrintWriter pw = (PrintWriter) iterator.next();
                pw.println(msg);
                pw.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
