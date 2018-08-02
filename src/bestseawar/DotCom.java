package bestseawar;

import java.util.ArrayList;

public class DotCom {

    private ArrayList<String> locationsCell;
    private String name;

    public void setName(String s) {
        name = s;
    }

    public void setLocationsCells(ArrayList<String> newLocation) {
        locationsCell = newLocation;
    }

    public String checkYourself(String guess) {
        String result = "Мимо";
        int index = locationsCell.indexOf(guess);
        if (index >= 0){
            locationsCell.remove(index);
            if (locationsCell.isEmpty()){
                result = "Потопил";
                System.out.println("Вы потопили " + name );
            } else {
                result = "Попал";
            }
        }

        return result;
    }
}
