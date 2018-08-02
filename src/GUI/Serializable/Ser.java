package GUI.Serializable;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Ser implements Serializable {

    transient private Duck duck = new Duck();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;



    public static void main(String[] args) {
        Ser ser = new Ser();
        try {
            FileOutputStream fs = new FileOutputStream("Ser.ser");
            ObjectOutputStream os = new ObjectOutputStream(fs);

            os.writeObject(ser);
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
