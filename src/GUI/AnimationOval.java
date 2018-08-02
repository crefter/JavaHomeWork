package GUI;

import javax.swing.*;
import java.awt.*;

public class AnimationOval {
    int x = 25;
    int y = 20;
    int width = 480;
    int height = 360;
    JFrame frame;


    public static void main(String[] args) {
        AnimationOval ao = new AnimationOval();
        ao.graph();
    }

    public void graph(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.setVisible(true);

        DrawPanelOval dpo = new DrawPanelOval();

        frame.getContentPane().add(dpo);

        for (int i = 0; i < 150; i++){
            x++;
            y++;

            dpo.repaint();

            try {
                Thread.sleep(25);
            } catch (Exception e){
                e.printStackTrace();
            }
        }

    }

    class DrawPanelOval extends JPanel {

        public void paintComponent(Graphics g) {
            g.setColor(Color.white);
            g.fillRect(0,0, this.getWidth(), this.getHeight());

            g.setColor(Color.ORANGE);
            g.fillOval(x, y, 50, 50);
        }
    }
}
