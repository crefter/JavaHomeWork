package GUI.FileWriter;

import java.io.FileReader;
import java.io.FileWriter;

public class WriteAFile {

    public static void main(String[] args) {

        try {
            FileWriter writer = new FileWriter("Foo.txt");
            writer.write("Hello, Foo!");
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
