package MultiThreading;

public class MoreThreads implements Runnable{

    public static void main(String[] args) {
        MoreThreads mts = new MoreThreads();
        Thread alpha = new Thread(mts);
        Thread betta = new Thread(mts);
        alpha.setName("alpha");
        betta.setName("betta");
        alpha.start();
        betta.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 25; i++) {
            String threadName = Thread.currentThread().getName();
            System.out.println("Сейчас работает поток " + threadName);
        }
    }
}
