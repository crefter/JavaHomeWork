package GuessGame;

public class GuessGame {
    private Player p1;
    private Player p2;
    private Player p3;

        public void startGame(){
            p1 = new Player();
            p2 = new Player();
            p3 = new Player();

            int guess1 = 0;
            int guess2 = 0;
            int guess3 = 0;

            boolean right1 = false;
            boolean right2 = false;
            boolean right3 = false;

            int targetNumber = (int) (Math.random() * 10);
            System.out.println("Я загадал число " + targetNumber);

            while (true){
                p1.guess();
                p2.guess();
                p3.guess();

                guess1 = p1.number;
                System.out.println("Первый игрок загадал " + guess1);
                guess2 = p2.number;
                System.out.println("Второй игрок загадал " + guess2);
                guess3 = p3.number;
                System.out.println("Третий игрок загадал " + guess3);

                if (guess1 == targetNumber)
                    right1 = true;
                if (guess2 == targetNumber)
                    right2 = true;
                if (guess3 == targetNumber)
                    right3 = true;

                if (right1 || right2 || right3){
                    System.out.println("У нас есть победитель!");
                    System.out.println("Первый игрок угадал? " + right1);
                    System.out.println("Второй игрок угадал? " + right2);
                    System.out.println("Третий игрок угадал? " + right3);
                    System.out.println("The end");
                    break;
                }else{
                    System.out.println("Повторите попытку");
                }
            }
        }
}
