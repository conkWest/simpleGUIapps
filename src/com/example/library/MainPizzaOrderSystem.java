package com.example.library;
import javax.swing.*;

public class MainPizzaOrderSystem {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PizzaOrderSystem order = new PizzaOrderSystem();
        });
    }
}
