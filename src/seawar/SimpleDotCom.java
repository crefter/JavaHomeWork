package seawar;

import java.util.ArrayList;

public class SimpleDotCom {

    private ArrayList<String> locationSells;


    public String checkYourself(String stringGuess){

        String result = "Мимо";

        int index = locationSells.indexOf(stringGuess);
        if (index >= 0){
            locationSells.remove(index);

            if (locationSells.isEmpty()){
                result = "Потопил";
            }else{
                result = "Попал";
            }
        }


        System.out.println(result);

        return result;
    }

    public void setLocationCells(ArrayList<String> locations) {
        locationSells = locations;
    }
}
