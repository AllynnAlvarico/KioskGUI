package org.example;

import javax.swing.*;
import java.awt.*;

public class Kiosk extends JFrame {

    private int HEIGHT = 700;
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

        this.add(start());

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

    private JPanel start() {
        JPanel panel = new JPanel();
        JButton start = new JButton("Start");

        panel.setLayout(new FlowLayout());



        start.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        start.setFont(new Font("New Time Roman", ~Font.BOLD, 14));
        start.setForeground(Color.RED);
        start.setBackground(Color.WHITE);
        start.setPreferredSize(new Dimension(220, 40));
        start.setLocation(100, 100);

        panel.add(start);
        return panel;
    }



    private JPanel FoodMenu() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setSize(WIDTH, HEIGHT);

        JPanel headerPanel = new JPanel();
        JPanel middlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 15));
        JPanel bottomPanel = new JPanel(new FlowLayout());

        // Settings the header panel
        JLabel headerLabel = new JLabel("FOOD MENU");
//        headerLabel.setPreferredSize(new Dimension(100,0));
        headerLabel.setBorder(BorderFactory.createEmptyBorder(11, 0, 0, 0));
        headerLabel.setFont(new Font("New Time Roman", Font.BOLD, 18));
        headerPanel.setPreferredSize(new Dimension(WIDTH, HEIGHT - 640));
        headerPanel.setBackground(Color.LIGHT_GRAY);
        headerPanel.add(headerLabel);

        //setting the button and customize it with the size and color
        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        cancelButton.setFont(new Font("New Time Roman",~Font.BOLD,14));
        cancelButton.setForeground(Color.BLACK);
        cancelButton.setBackground(Color.WHITE);
        cancelButton.setPreferredSize(new Dimension(220,40));

        JButton confirmButton = new JButton("Confirm");
        confirmButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        confirmButton.setFont(new Font("New Time Roman",~Font.BOLD,14));
        confirmButton.setForeground(Color.BLACK);
        confirmButton.setBackground(Color.WHITE);
        confirmButton.setPreferredSize(new Dimension(220,40));

        for (int i = 0; i < 9; i++) {
            JPanel foodPanel = FoodPanel(null, "Burger", 3.50);
            middlePanel.add(foodPanel);
        }

        JScrollPane scrollPane = new JScrollPane(middlePanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(WIDTH, HEIGHT - 200));

        bottomPanel.setBackground(Color.lightGray);
        bottomPanel.setPreferredSize(new Dimension(WIDTH, HEIGHT - 600));
        bottomPanel.add(cancelButton);
        bottomPanel.add(confirmButton);

        // add all the panel to the main panel then return it
        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
//
//        JScrollPane scrollPane = new JScrollPane(middlePanel);
//        this.getContentPane().add(scrollPane, BorderLayout.CENTER);

        return mainPanel;
    }

    private JPanel FoodPanel(Image image, String name, Double price) {
        JPanel foodPanel = new JPanel(new BorderLayout());
        foodPanel.setBorder(BorderFactory.createEmptyBorder(11, 5, 5, 0));

        JPanel imagePanel = new JPanel(new FlowLayout());;
        if (image != null) {
            imagePanel.setPreferredSize(new Dimension(WIDTH / 4, HEIGHT - 560));
        } else {
            imagePanel.setPreferredSize(new Dimension(WIDTH / 4, HEIGHT - 560));
            imagePanel.setBackground(Color.gray);
        }

        JLabel foodName = new JLabel("Name: " + name);
        foodPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 10));

        JLabel foodPrice = new JLabel("Price: " + String.valueOf(price));
        foodPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 10));

        foodPanel.add(imagePanel,BorderLayout.NORTH);
        foodPanel.add(foodName, BorderLayout.CENTER);
        foodPanel.add(foodPrice, BorderLayout.SOUTH);

        return foodPanel;
    }



    





}
