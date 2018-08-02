package GUI.DailyAdvice;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    String[] adviceList = {"Ешь меньше", "Купайся в реке", "Занимайся спортом", "Сделай другую причёску"};

    public void go() {

        try {
            ServerSocket serverSocket = new ServerSocket(4242);

            while(true) {
                Socket socket = serverSocket.accept();

                PrintWriter pw = new PrintWriter(socket.getOutputStream());
                String advice = getAdvice();
                pw.println(advice);
                pw.close();
                System.out.println(advice);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getAdvice() {
        int random = (int) (Math.random() * adviceList.length);
        return adviceList[random];
    }

    public static void main(String[] args) {
        new Server().go();
    }

}
