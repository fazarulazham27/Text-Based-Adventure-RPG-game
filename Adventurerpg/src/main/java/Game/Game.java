package Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Game {

    ChoiceHandler choiceHandler = new ChoiceHandler();
    Player player = new Player();
    UI ui = new UI(player);
    HighScoreManager highScoreManager = new HighScoreManager();
    VisibilityManager vm = new VisibilityManager(ui, highScoreManager);
    Story story = new Story(this, ui, vm, player);

    String nextPosition1, nextPosition2, nextPosition3, nextPosition4;

    public static void main(String[] args) {

        new Game();
    }

    public Game() {
        ui.createUI(choiceHandler);
        story.defaultSetup();
        vm.showTitleScreen();
        playBackgroundMusic("Adventurerpg/res/Dark-Souls-III-OST-4-Firelink-Shrine.wav");
    }

    public Game(Player player2, HighScoreManager highScoreManager2) {
        // TODO Auto-generated constructor stub
    }

    public void playBackgroundMusic(String filePath) {
        try {
            File musicPath = new File(filePath);
            if (musicPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.loop(Clip.LOOP_CONTINUOUSLY); // Loop the music
                clip.start();
            } else {
                System.out.println("Can't find file");
            }
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    // method when the game ends
    public void endGame() {
        try {
            // save player'score using HighScoreManager
            if (player.name != null && !player.name.isEmpty()) {
                highScoreManager.saveScore(player.name, player.score);
            } else {
                System.err.println("Player name is missing, cannot save score!");
            }

            String topScores = highScoreManager.getTopScores();
            ui.displayHighScores(topScores);
            ui.displayMessage("Game Over!\nYour Score: " + player.score + "\n\nTop Scores:\n" + topScores);

            vm.showGameResultsScreen();
        } catch (Exception e) {
            System.err.println("Error in endGame(): " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Handle the choice
    public class ChoiceHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String yourChoice = event.getActionCommand();

            switch (yourChoice) {

                case "start":
                    vm.showNameInputScreen();
                    break;
                case "submitName":
                    String playerName = ui.nameInputField.getText(); // Retrieve the player's name
                    player.name = ui.nameInputField.getText();
                    if (playerName == null || playerName.trim().isEmpty()) {
                        ui.feedbackLabel.setText("Please enter a name.");
                        ui.feedbackLabel.setVisible(true); // Show the feedback message
                    } else {
                        player.name = playerName;
                        ui.feedbackLabel.setVisible(false); // Hide the feedback message
                        vm.showClassSelectionScreen(player.name);
                    }
                    break;
                case "knight":
                    player.setKnight();
                    player.className = "Knight";
                    String knightIntro = "The Knight is a brave warrior with high health and defense.";
                    String knightStats = "HP: " + player.hp + ", ATK: " + player.atk + ", DEF: " + player.def;
                    String knightWeapon = "Weapon: " + player.currentWeapon.name;
                    vm.showClassIntroScreen("Knight", knightIntro, knightStats, knightWeapon);
                    break;
                case "sentinel":
                    player.setSentinel();
                    player.className = "Sentinel";
                    String sentinelIntro = "The Sentinel is a shield specialist with high defense and low attack.";
                    String sentinelStats = "HP: " + player.hp + ", ATK: " + player.atk + ", DEF: " + player.def;
                    String sentinelWeapon = "Weapon: " + player.currentWeapon.name;
                    vm.showClassIntroScreen("Sentinel", sentinelIntro, sentinelStats, sentinelWeapon);
                    break;
                case "berserker":
                    player.setBerserker();
                    player.className = "Berserker";
                    String berserkerIntro = "The Berserker is a reckless fighter with high attack and low defense.";
                    String berserkerStats = "HP: " + player.hp + ", ATK: " + player.atk + ", DEF: " + player.def;
                    String berserkerWeapon = "Weapon: " + player.currentWeapon.name;
                    vm.showClassIntroScreen("Berserker", berserkerIntro, berserkerStats, berserkerWeapon);
                    break;
                case "backToClassSelection":
                    vm.backToClassSelection();
                    break;
                case "confirmClass":
                    vm.showGameScreen(player.className);
                    story.startGame();
                    ui.hpLabelNum.setText("" + player.hp);
                    ui.weaponLabelName.setText(player.currentWeapon.name);
                    break;
                case "endGame": // manual way to trigger end game
                    endGame();
                    break;

                case "c1":
                    story.selectPosition(nextPosition1);
                    break;
                case "c2":
                    story.selectPosition(nextPosition2);
                    break;
                case "c3":
                    story.selectPosition(nextPosition3);
                    break;
                case "c4":
                    story.selectPosition(nextPosition4);
                    break;

                case "useItem":
                    story.useHealingItem();
                    break;

                case "showInventory":
                    story.showInventory();
                    break;
                case "closeInventory":
                    ui.hideInventory();
                    break;
                case "toggleInventory":
                    StringBuilder inventoryText = new StringBuilder();
                    inventoryText.append("Healing Potions: ").append(player.healingItems).append("\n\n");
                    inventoryText.append("Items:\n");
                    for (String item : player.inventory) {
                        inventoryText.append("- ").append(item).append("\n");
                    }
                    ui.toggleInventory(inventoryText.toString());
                    break;
            }
        }
    }
}
