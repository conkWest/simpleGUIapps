package com.example.library;

import javax.swing.*;

public class NumberCounter extends JFrame{
    private JPanel mainPanel;
    private JButton DecreaseButton;
    private JButton IncreaseButton;
    private JLabel CountLabel;

    private int count = 0;

    public NumberCounter(){
        setTitle("Number Counter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        DecreaseButton.setName("DecreaseButton");
        IncreaseButton.setName("IncreaseButton");
        CountLabel.setName("CountLabel");

        DecreaseButton.addActionListener(e -> {
            count--;
            CountLabel.setText(String.valueOf(count));
        });
        IncreaseButton.addActionListener(e -> {
            count++;
            CountLabel.setText(String.valueOf(count));
        });

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            NumberCounter counter = new NumberCounter();
        });
    }

}
