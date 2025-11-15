package com.example.library;
import javax.swing.*;

public class MainNumberCounter {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            NumberCounter counter = new NumberCounter();
        });
    }
}
