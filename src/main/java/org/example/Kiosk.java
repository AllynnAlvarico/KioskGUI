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
        this.getContentPane().setBackground(Color.WHITE);

        this.setVisible(true);
    }




}
