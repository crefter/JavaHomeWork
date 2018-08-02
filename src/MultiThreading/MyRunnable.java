package MultiThreading;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        go();
    }

    private void go() {

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        doMore();
    }

    private void doMore() {
        System.out.println("На вершине стека");
    }
}

