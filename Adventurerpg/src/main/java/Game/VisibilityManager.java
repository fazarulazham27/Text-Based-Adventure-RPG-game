//THIS CLASS HANDLES TRANSITION

package Game;

import java.awt.Image;
import javax.swing.JPanel;

import javax.swing.ImageIcon;

public class VisibilityManager {
    UI ui;
    HighScoreManager highScoreManager;  //reference to HighScoreManager
    public JPanel gameScreen;
    public JPanel resultsScreen;
            
    public VisibilityManager(UI userInterface, HighScoreManager highScoreManager){
        ui = userInterface;
        highScoreManager = highScoreManager;
        
        gameScreen = ui.gamePanel;
        resultsScreen = ui.resultsPanel; //make sure this exists in UI
    }
    
    public void showTitleScreen(){
        
        //Show the title screen
        ui.titleNamePanel.setVisible(true);
        ui.startButtonPanel.setVisible(true);
        
        ui.nameInputPanel.setVisible(false);

        ui.inventoryButton.setVisible(false); // Hide inventory button during combat

        //Hide the game screen
        ui.mainTextPanel.setVisible(false);
        ui.choiceButtonPanel.setVisible(false);
        ui.playerPanel.setVisible(false);
        
    }
    
    // public void titleTown(){
    //     //Hide the title screen
    //     ui.titleNamePanel.setVisible(false);
    //     ui.startButtonPanel.setVisible(false);
        
    //     //Show the game screen
    //     ui.mainTextPanel.setVisible(true);
    //     ui.choiceButtonPanel.setVisible(true);
    //     ui.playerPanel.setVisible(true);
    // }

    public void showNameInputScreen() {
        ui.titleNamePanel.setVisible(false);
        ui.startButtonPanel.setVisible(false);

        ui.inventoryButton.setVisible(false); // Hide inventory button during combat

        ui.nameInputPanel.setVisible(true);
        ui.welcomeTextArea.setVisible(true); // Ensure welcomeTextArea is visible
    }

    public void showGameScreen(String className) {
        ui.nameInputPanel.setVisible(false);

        ui.mainTextPanel.setVisible(true);
        ui.choiceButtonPanel.setVisible(true);
        ui.playerPanel.setVisible(true);
        ui.StoryClassImagePanel.setVisible(true);

        ui.classNamePanel.setVisible(false);
        ui.classBriefPanel.setVisible(false);
        ui.classStatsPanel.setVisible(false);
        ui.classDetailButtonPanel.setVisible(false);
        ui.confirmationTextPanel.setVisible(false);
        ui.weaponStatsPanel.setVisible(false);
        ui.inventoryButton.setVisible(true); // Hide inventory button during combat
        ui.ClassSelectImagePanel.setVisible(false);

        // Change the image based on the selected class
        ImageIcon classImage = null;
        if (className.equals("Knight")) {
            classImage = new ImageIcon("Adventurerpg/res/knight.png");
        } else if (className.equals("Sentinel")) {
            classImage = new ImageIcon("Adventurerpg/res/sentinel.png");
        } else if (className.equals("Berserker")) {
            classImage= new ImageIcon("Adventurerpg/res/berserker.png");
        }


        Image scaledImage = classImage.getImage().getScaledInstance(300, 350, Image.SCALE_SMOOTH);
        classImage = new ImageIcon(scaledImage);
        ui.StoryClassImageLabel.setIcon(classImage);

    }

    //Class selection screen
    public void showClassSelectionScreen(String playerName) {

        ui.inventoryButton.setVisible(false); // Hide inventory button during combat

        ui.nameInputPanel.setVisible(false);
        ui.classSelectionPanel.setVisible(true);
        ui.classButtonPanel.setVisible(true);
        ui.welcomeTextArea.setText("Welcome " + playerName + "! Please select a class.");
    }

    // Class Details screen
    public void showClassIntroScreen(String className, String introText, String statsText, String weaponText) {
        ui.classSelectionPanel.setVisible(false);
        ui.classButtonPanel.setVisible(false);
        ui.classNamePanel.setVisible(true);
        ui.classBriefPanel.setVisible(true);
        ui.classStatsPanel.setVisible(true);
        ui.classDetailButtonPanel.setVisible(true);
        ui.confirmationTextPanel.setVisible(true);
        ui.weaponStatsPanel.setVisible(true);
        ui.ClassSelectImagePanel.setVisible(true);

        ui.classNameLabel.setText(className);
        ui.classBriefTextArea.setText(introText);
        ui.classStatsLabel.setText(statsText);
        ui.weaponStatsLabel.setText(weaponText);
        

        // Change the image based on the selected class
        ImageIcon classImage = null;
        if (className.equals("Knight")) {
            classImage = new ImageIcon("Adventurerpg/res/knight.png");
        } else if (className.equals("Sentinel")) {
            classImage = new ImageIcon("Adventurerpg/res/sentinel.png");
        } else if (className.equals("Berserker")) {
            classImage= new ImageIcon("Adventurerpg/res/berserker.png");
        }


        Image scaledImage = classImage.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        classImage = new ImageIcon(scaledImage);
        ui.ClassSelectImageLabel.setIcon(classImage);

    }

    public void backToClassSelection() {
        ui.classNamePanel.setVisible(false);
        ui.classBriefPanel.setVisible(false);
        ui.classStatsPanel.setVisible(false);
        ui.classDetailButtonPanel.setVisible(false);
        ui.classSelectionPanel.setVisible(true);
        ui.classButtonPanel.setVisible(true);

        ui.ClassSelectImagePanel.setVisible(false);

    }
    
    public void showFirekeeperImage() {
        ImageIcon firekeeperImage = new ImageIcon("Adventurerpg/res/firekeeper.png");
        Image scaledImage = firekeeperImage.getImage().getScaledInstance(300, 350, Image.SCALE_SMOOTH);
        firekeeperImage = new ImageIcon(scaledImage);
        ui.StoryClassImageLabel.setIcon(firekeeperImage);
        ui.StoryClassImagePanel.setVisible(true);
    }

    public void showPlayerClassImage(String className) {
        ImageIcon classImage = null;
        if (className.equals("Knight")) {
            classImage = new ImageIcon("Adventurerpg/res/knight.png");
        } else if (className.equals("Sentinel")) {
            classImage = new ImageIcon("Adventurerpg/res/sentinel.png");
        } else if (className.equals("Berserker")) {
            classImage = new ImageIcon("Adventurerpg/res/berserker.png");
        }

        Image scaledImage = classImage.getImage().getScaledInstance(300, 350, Image.SCALE_SMOOTH);
        classImage = new ImageIcon(scaledImage);
        ui.StoryClassImageLabel.setIcon(classImage);
        ui.StoryClassImagePanel.setVisible(true);
    }
    
    public void showGameResultsScreen() {
    // Implement screen transition logic here
    if (gameScreen !=null && resultsScreen !=null) {
        System.out.println("Switching to results screen");  //debug message
        
        // hide the game screen
        gameScreen.setVisible(false);
        
        //show the results screen
        resultsScreen.setVisible(true);
        
        //fetch & display highscores
        String highScores = highScoreManager.getTopScores(); //retrieve top scores
        ui.highScoresArea.setText(highScores); //ensure exists in UI
    } else {
        System.out.println("Error! gameScreen or resultsScreen is null");
    }
    }
}
    
    
    
    

