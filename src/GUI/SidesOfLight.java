package GUI;

import javax.swing.*;
import java.awt.*;

public class SidesOfLight {
    public static void main(String[] args) {
        SidesOfLight sol = new SidesOfLight();
        sol.draw();
    }

    public void draw(){
        JFrame frame = new JFrame("Sides of light");
        JButton btnWest = new JButton("West");
        JButton btnEast = new JButton("East");
        JButton btnNorth = new JButton("North");
        JButton btnSouth = new JButton("South");
        JButton btnCenter = new JButton("Center");

        frame.getContentPane().add(BorderLayout.WEST, btnWest);
        frame.getContentPane().add(BorderLayout.EAST, btnEast);
        frame.getContentPane().add(BorderLayout.NORTH, btnNorth);
        frame.getContentPane().add(BorderLayout.SOUTH, btnSouth);
        frame.getContentPane().add(BorderLayout.CENTER, btnCenter);

        frame.setSize(480, 360);
        frame.setVisible(true);

    }
}
