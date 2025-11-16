package com.example.library;

import javax.swing.*;
import java.awt.*;

public class GeographyQuiz {
    private JFrame frame;
    private CardLayout cardLayout;
    private JPanel cards;
    private int score = 0;

    private JTextField question1TextField;
    private JTextField question2TextField;
    private JTextField question3TextField;
    private JLabel scoreLabel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GeographyQuiz().createAndShowGui());
    }

    private void createAndShowGui() {
        frame = new JFrame("Geography Quiz");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        cards = new JPanel(cardLayout);

        scoreLabel = new JLabel("Your Score: 0/3");
        scoreLabel.setName("scoreLabel");

        cards.add(makeQuestionPanel("panel1", "What is the capital of France?", 1), "panel1");
        cards.add(makeQuestionPanel("panel2", "What is the capital of Japan?", 2), "panel2");
        cards.add(makeQuestionPanel("panel3", "What is the capital of Germany?", 3), "panel3");
        cards.add(makeFinalPanel(), "panel4");

        frame.getContentPane().setLayout(new BorderLayout(8,8));
        frame.getContentPane().add(scoreLabel, BorderLayout.NORTH);
        frame.getContentPane().add(cards, BorderLayout.CENTER);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private JPanel makeQuestionPanel(String panelName, String question, int index) {
        JPanel p = new JPanel(new BorderLayout(10,10));
        JLabel q = new JLabel(question);
        JTextField tf = new JTextField(20);
        tf.setName("question" + index + "TextField");

        if (index == 1) question1TextField = tf;
        if (index == 2) question2TextField = tf;
        if (index == 3) question3TextField = tf;

        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton back = new JButton("Back");
        back.setName("backButton");
        back.addActionListener(e -> {
            if (!"panel1".equals(panelName)) {
                cardLayout.previous(cards);
                updateScoreLabel();
            }
        });

        JButton next = new JButton("Next");
        next.setName("nextButton");
        next.addActionListener(e -> {
            evaluateAllAnswers();
            if ("panel3".equals(panelName)) {
                cardLayout.show(cards, "panel4");
            } else {
                cardLayout.next(cards);
            }
            updateScoreLabel();
        });

        // On first panel hide back
        if ("panel1".equals(panelName)) back.setVisible(false);

        buttons.add(back);
        buttons.add(next);

        p.add(q, BorderLayout.NORTH);
        p.add(tf, BorderLayout.CENTER);
        p.add(buttons, BorderLayout.SOUTH);
        return p;
    }

    private JPanel makeFinalPanel() {
        JPanel p = new JPanel(new BorderLayout(10,10));
        JLabel done = new JLabel("Congratulations! You have finished the quiz.");
        JLabel finalScore = new JLabel();
        finalScore.setName("finalScoreLabel");
        finalScore.setHorizontalAlignment(SwingConstants.CENTER);

        // Update final score when this panel is shown
        cards.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent e) {}
        });

        p.add(done, BorderLayout.NORTH);
        p.add(finalScore, BorderLayout.CENTER);

        // When navigated to panel4, refresh score
        SwingUtilities.invokeLater(() -> {
            // nothing needed here; updateScoreLabel will be called on navigation
        });

        return p;
    }

    private void evaluateAllAnswers() {
        score = 0;
        if ("Paris".equalsIgnoreCase(question1TextField.getText().trim())) score++;
        if ("Tokyo".equalsIgnoreCase(question2TextField.getText().trim())) score++;
        if ("Berlin".equalsIgnoreCase(question3TextField.getText().trim())) score++;
    }

    private void updateScoreLabel() {
        scoreLabel.setText("Your Score: " + score + "/3");
    }
}

