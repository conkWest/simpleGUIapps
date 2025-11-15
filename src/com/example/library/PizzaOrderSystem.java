package com.example.library;

import javax.swing.*;

public class PizzaOrderSystem extends JFrame{
    private JPanel mainPanel;
    private JComboBox SizeChoice;
    private JComboBox ToppingsChoice;
    private JComboBox ExtCheeseChoice;
    private JButton calcTotal;
    private JLabel Total;

    public PizzaOrderSystem(){
        setTitle("Pizza Order System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        calcTotal.setName("calcTotal");
        Total.setName("Total");
        SizeChoice.setName("SizeChoice");
        ToppingsChoice.setName("ToppingsChoice");
        ExtCheeseChoice.setName("ExtCheeseChoice");
        calcTotal.addActionListener(e->calculateTotal());
    }


    private void calculateTotal() {
        int currentTotal = 0;

        int sizeChoice = SizeChoice.getSelectedIndex();
        if(sizeChoice == 0){
            currentTotal += 10;
        } else if(sizeChoice == 1){
            currentTotal += 15;
        } else if(sizeChoice == 2){
            currentTotal += 20;
        }

        final int TOPPING_COST = 2;
        int toppingsChoice = ToppingsChoice.getSelectedIndex();
        if(toppingsChoice == 1){
            currentTotal += TOPPING_COST;
        }
        if(toppingsChoice == 2){
            currentTotal += TOPPING_COST;
        }
        if(toppingsChoice == 3){
            currentTotal += TOPPING_COST;
        }

        int cheeseChoice = ExtCheeseChoice.getSelectedIndex();
        if(cheeseChoice == 1){
            currentTotal += 3;
        }

        Total.setText(currentTotal + "");
    }
}
