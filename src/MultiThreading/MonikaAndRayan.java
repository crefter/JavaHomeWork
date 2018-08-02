package MultiThreading;

class BankAccount {
    private int balance = 100;

    public int getBalance() {
        return balance;
    }

    public void withdraw(int ammount) {
        balance -= ammount;
    }
}

public class MonikaAndRayan implements Runnable {

    private BankAccount account = new BankAccount();


    public static void main(String[] args) {
        MonikaAndRayan mar = new MonikaAndRayan();
        Thread one = new Thread(mar);
        Thread two = new Thread(mar);
        one.setName("Райан");
        two.setName("Моника");
        one.start();
        two.start();
    }


    @Override
    public void run() {
        for (int x = 0; x < 10; x++) {
            makeWithdrawal(10);
            if (account.getBalance() < 0) {
                System.out.println("Превышение лимита");
            }
        }
    }

    private void makeWithdrawal(int i) {
        if (account.getBalance() >= i) {
            System.out.println(Thread.currentThread().getName() + " собирается снять деньги");
            try {
                System.out.println(Thread.currentThread().getName() + " идёт подремать");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + " просыпается");
            account.withdraw(i);
            System.out.println(Thread.currentThread().getName() + " снял(а) деньги");
        } else {
            System.out.println("Изините, для клиента " +
                    Thread.currentThread().getName() + " недостаточно денег");
        }

    }
}
