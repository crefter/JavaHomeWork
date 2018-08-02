package GUI.Deserializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class GameSaverTest {

    public static void main(String[] args) {
        GameCharacter one = new GameCharacter(50, "Elf",
                                        new String[] {"arrow", "sword"});
        GameCharacter two = new GameCharacter(100, "Troll",
                                        new String[] {"dubinka", "axe"});
        GameCharacter three = new GameCharacter(70, "Mage",
                                        new String[] {"invisible", "spells"});

        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("Game.ser"));
            os.writeObject(one);
            os.writeObject(two);
            os.writeObject(three);
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        one = null;
        two = null;
        three = null;

        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("Game.ser"));
            GameCharacter oneR = (GameCharacter) is.readObject();
            GameCharacter twoR = (GameCharacter) is.readObject();
            GameCharacter threeR = (GameCharacter) is.readObject();

            System.out.println("Type of first " + oneR.getType() + " weapons " + oneR.getWeapons());
            System.out.println("Type of second " + twoR.getType() + " weapons " + twoR.getWeapons());
            System.out.println("Type of third " + threeR.getType() + " weapons " + threeR.getWeapons());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
