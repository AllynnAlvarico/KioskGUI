package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Kiosk extends JFrame implements ActionListener {

    private int HEIGHT = 700;
    private int WIDTH = 500;
    private int Yaxis = 100;
    private int Xaxis = 500;
    private JButton start, confirmButton, cancelButton;

    public Kiosk(){
        this.initialising();

    }

    private void initialising(){
        this.setTitle("Kiosk Ordering System");

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);

        this.setSize(new Dimension(WIDTH, HEIGHT));
        this.setLocation(Xaxis, Yaxis);
        this.setResizable(false);

        start();
        BackgroundPanel bgPanel = new BackgroundPanel();
        bgPanel.setBounds(0, 0, WIDTH, HEIGHT);
        this.add(bgPanel);

        this.setVisible(true);
    }

    private JPanel start() {
        JPanel panel = new JPanel();
        panel.setBounds(50, 450, 400, 200);
        panel.setLayout(null);
        panel.setOpaque(true);
        panel.setBackground(new Color(0,0,0,0));



        start = new JButton("Start");
        start.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        start.setFont(new Font("Times New Roman", Font.BOLD, 14));
        start.setForeground(Color.BLACK);
        start.setBackground(Color.WHITE);
        start.setFocusable(false);
        start.setBounds(100, 50, 200, 40);


        start.addActionListener(this);

        panel.add(start);


        this.add(panel);

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
        cancelButton = new JButton("Cancel");
        cancelButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        cancelButton.setFont(new Font("New Time Roman",~Font.BOLD,14));
        cancelButton.setForeground(Color.BLACK);
        cancelButton.setBackground(Color.WHITE);
        cancelButton.setPreferredSize(new Dimension(220,40));

        confirmButton = new JButton("Confirm");
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

        cancelButton.addActionListener(this);
        confirmButton.addActionListener(this);

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
    public void switchPanel(JPanel panel) {
        this.getContentPane().removeAll();
        this.getContentPane().add(panel);
        this.revalidate();
        this.repaint();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == start){
            switchPanel(FoodMenu());
            System.out.println("Switched to Food Menu!");
        } else if (e.getSource() == cancelButton) {
            switchPanel(start());
            BackgroundPanel bgPanel = new BackgroundPanel();
            bgPanel.setBounds(0, 0, WIDTH, HEIGHT);
            this.add(bgPanel);
        }
    }
}

class BackgroundPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image image = new ImageIcon("resource\\background.png").getImage();
        Image icon = new ImageIcon("resource\\icon.png").getImage();
        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
        g.drawImage(icon, 160, 330, this);

    }
}
