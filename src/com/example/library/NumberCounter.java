package com.example.library;

import javax.swing.*;

public class NumberCounter extends JFrame{
    private JPanel mainPanel;
    private JButton DecreaseButton;
    private JButton IncreaseButton;
    private JLabel CountLabel;

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

        DecreaseButton.addActionListener(e -> CountLabel.setText(String.valueOf(Integer.parseInt(CountLabel.getText()) - 1)));
        IncreaseButton.addActionListener(e -> CountLabel.setText(String.valueOf(Integer.parseInt(CountLabel.getText()) + 1)));

    }

}
