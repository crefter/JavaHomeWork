package MultiThreading;

public class TestThread {
    public static void main(String[] args) {
        Runnable r = new MyRunnable();
        Thread t = new Thread(r);

        t.start();
        System.out.println("В методе main");
    }
}
