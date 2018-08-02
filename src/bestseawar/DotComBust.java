package bestseawar;


import java.util.ArrayList;

public class DotComBust {

    private GameHelperBest helper = new GameHelperBest();
    private ArrayList<DotCom> dotComsList = new ArrayList<DotCom>();
    private int numOfGuess = 0;

    private void setUpGame(){
        DotCom one = new DotCom();
        one.setName("Pets.com");
        DotCom two = new DotCom();
        two.setName("eToys.com");
        DotCom three = new DotCom();
        three.setName("Go2.com");
        dotComsList.add(one);
        dotComsList.add(two);
        dotComsList.add(three);

        System.out.println("Попытайтесь потопить корабли");

        for (DotCom dotCom : dotComsList){
            ArrayList<String> newLocation = helper.placeDotCom(3);

            dotCom.setLocationsCells(newLocation);
        }
    }

    private void startPlaying(){
        while (!dotComsList.isEmpty()){
            String guess = helper.getUserInput("Сделайте ход");
            checkUserGuess(guess);
        }
        finishGame();
    }

    private void finishGame() {

        System.out.println("Все сайты на дне!");
        if (numOfGuess <= 18){
            System.out.println("Вы успели добраться до того, как ваши вложения утонули " + numOfGuess);
        }else{
            System.out.println("Вы потеряли деньги " + numOfGuess);
        }


    }

    private void checkUserGuess(String guess) {
        numOfGuess++;

        String result = "Мимо";
        for (DotCom dotCom : dotComsList){
            result = dotCom.checkYourself(guess);

            if (result.equals("Попал")){
                break;
            }
            if (result.equals("Потопил")){
                dotComsList.remove(dotCom);
                break;
            }
        }

        System.out.println(result);
    }


    public static void main(String[] args) {
        DotComBust dcb = new DotComBust();
        dcb.setUpGame();
        dcb.startPlaying();
    }

}
