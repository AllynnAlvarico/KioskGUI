package org.example;

import javax.swing.*;
import java.awt.*;

public class Kiosk extends JFrame {

    private int HEIGHT = 800;
    private int WIDTH = 500;
    private int Yaxis = 100;
    private int Xaxis = 500;

    public Kiosk(){
        this.initialising();

    }

    private void initialising(){
        this.setTitle("Kiosk Ordering System");

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);

        this.setSize(new Dimension(WIDTH, HEIGHT));
        this.setLocation(Xaxis, Yaxis);
        this.getContentPane().setBackground(Color.RED);

        this.setVisible(true);
    }

    public void paint(Graphics g)
    {
        Image image = new ImageIcon("resource\\background.png").getImage();
        Image icon = new ImageIcon("resource\\icon.png").getImage();
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.drawImage(image, 0, 0, null);
        g2d.drawImage(icon, 170, 330, null);

    }


}
