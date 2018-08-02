package seawar;

import java.util.ArrayList;

public class SeaWar {
    public static void main(String[] args) {
        int numOfGuess = 0;
        GameHelper gh = new GameHelper();

        SimpleDotCom sdc = new SimpleDotCom();
        int randomNum = (int) (Math.random() * 5);
        int rnd2 = randomNum+1;
        int rnd3 = randomNum+2;
        String sRnd1 = String.valueOf(randomNum);
        String sRnd2 = String.valueOf(randomNum+1);
        String sRnd3 = String.valueOf(randomNum+2);

        ArrayList<String> locations = new ArrayList<String>();
        locations.add(sRnd1);
        locations.add(sRnd2);
        locations.add(sRnd3);

        sdc.setLocationCells(locations);

        boolean isAlive = true;

        while (isAlive){
            String guess = gh.getUserInput("Введите число");

            String result = sdc.checkYourself(guess);
            numOfGuess++;

            if (result.equals("Потопил")){
                isAlive = false;
                System.out.println("Вам потребовалось " + numOfGuess + " попыток(и)");
            }
        }
    }
}
