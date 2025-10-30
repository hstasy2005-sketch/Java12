package practica8;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FootballMatch {
    private int milanScore = 0;
    private int madridScore = 0;
    private JLabel resultLabel;
    private JLabel lastScorerLabel;
    private JLabel winnerLabel;

    public FootballMatch() {
        JFrame frame = new JFrame("Football Match: AC Milan vs Real Madrid");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new GridLayout(4, 1));

        JButton milanButton = new JButton("AC Milan");
        JButton madridButton = new JButton("Real Madrid");

        resultLabel = new JLabel("Result: 0 X 0", JLabel.CENTER);
        lastScorerLabel = new JLabel("Last Scorer: N/A", JLabel.CENTER);
        winnerLabel = new JLabel("Winner: DRAW", JLabel.CENTER);

        milanButton.addActionListener(e -> {
            milanScore++;
            updateScore("AC Milan");
        });

        madridButton.addActionListener(e -> {
            madridScore++;
            updateScore("Real Madrid");
        });

        frame.add(resultLabel);
        frame.add(lastScorerLabel);
        frame.add(winnerLabel);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(milanButton);
        buttonPanel.add(madridButton);
        frame.add(buttonPanel);

        frame.setVisible(true);
    }

    private void updateScore(String lastScorer) {
        resultLabel.setText("Result: " + milanScore + " X " + madridScore);
        lastScorerLabel.setText("Last Scorer: " + lastScorer);
        if (milanScore > madridScore)
            winnerLabel.setText("Winner: AC Milan");
        else if (madridScore > milanScore)
            winnerLabel.setText("Winner: Real Madrid");
        else
            winnerLabel.setText("Winner: DRAW");
    }

    public static void main(String[] args) {
        new FootballMatch();
    }
}
