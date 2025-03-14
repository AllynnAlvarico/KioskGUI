package org.example;

import javax.swing.*;
import java.awt.*;

public class Kiosk extends JFrame {

    private int HEIGHT = 100;
    private int WIDTH = 100;

    public Kiosk(){
        this.initialising();


    }

    private void initialising(){
        this.setTitle("Kiosk Ordering System");

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);

        this.setPreferredSize(new Dimension(100, 100));
    }

}
