/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Game;

import java.util.ArrayList;
import java.util.Comparator;

public class HighScoreManager {
    private ArrayList<HighScoreEntry> highScores;

    public HighScoreManager() {
        // Initialize the highScores list
        highScores = new ArrayList<>();
    }

    // Add a new score to the list
    public void addScore(String playerName, int score) {
        highScores.add(new HighScoreEntry(playerName, score));
        highScores.sort((a, b) -> Integer.compare(b.score, a.score));

        // Keep only the top 10 scores
        if (highScores.size() > 10) {
            highScores.remove(highScores.size() - 1);
        }
    }

    public void saveScore(String playerName, int score) {
        // implementation for saving score
        System.out.println("Saving score for:" + playerName + " - " + score);
    }

    // Get the top 10 scores as a formatted string
    public String getTopScores() {
        StringBuilder result = new StringBuilder("High Scores:\n");
        int rank = 1;
        for (int i = 0; i < highScores.size(); i++) {
            HighScoreEntry entry = highScores.get(i);
            result.append((i + 1)).append(". ")
                    .append(entry.getPlayerName())
                    .append(" - Score: ")
                    .append(entry.getScore())
                    .append("\n");
        }
        return result.toString();
    }

    // Helper class to store individual high-score entries
    private static class HighScoreEntry {
        private final String playerName;
        private final int score;

        public HighScoreEntry(String playerName, int score) {
            this.playerName = playerName;
            this.score = score;
        }

        public String getPlayerName() {
            return playerName;
        }

        public int getScore() {
            return score;
        }
    }
}