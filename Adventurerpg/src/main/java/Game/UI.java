package Game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Image;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import Game.Game.ChoiceHandler;

public class UI {
    JFrame window;
    JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel, nameInputPanel,
            classSelectionPanel, classButtonPanel, classIntroPanel, classNamePanel, classBriefPanel, classStatsPanel,
            classDetailButtonPanel, confirmationTextPanel, weaponStatsPanel;
    JPanel hpPanel, weaponPanel, combatPanel, combatTextPanel, combatButtonPanel, combatPlayerPanel, combatHpPanel,
            combatWeaponPanel, enemyPanel;
    public JPanel gamePanel = new JPanel();
    public JPanel resultsPanel = new JPanel();
    JFrame mainFrame;
    JLabel titleNameLabel, hpLabel, hpLabelNum, weaponLabel, weaponLabelName, nameLabel, feedbackLabel, classIntroLabel,
            classNameLabel, classStatsLabel, weaponStatsLabel, confirmationClassLabel;
    JLabel enemyLabel, enemyHpLabel, enemyHpLabelNum, combatHpLabel, combatHpLabelNum, combatWeaponLabel,
            combatWeaponLabelName;
    JButton startButton, choice1, choice2, choice3, choice4, submitNameButton, knightButton, sentinelButton,
            berserkerButton, backButton, confirmClassButton;
    JButton combatChoice1, combatChoice2, combatChoice3, combatChoice4;
    JTextArea mainTextArea, welcomeTextArea, classIntroTextArea, classBriefTextArea, confirmationClassTextArea;
    JTextArea combatTextArea, highScoresArea;
    JTextField nameInputField;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 35); // Font settings for title
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 28); // Font settings for button
    Font smallFont = new Font("Times New Roman", Font.PLAIN, 23);
    JScrollPane mainTextScrollPane, combatTextScrollPane;
    JPanel CombatEnemyImagePanel;
    JLabel CombatEnemyImageLabel;

    // Inventory UI components
    JPanel inventoryPanel;
    JTextArea inventoryTextArea;
    JButton inventoryButton, closeInventoryButton;
    JScrollPane inventoryScrollPane;

    // Image UI Components
    JPanel ClassSelectImagePanel, StoryClassImagePanel, CombatClassImagePanel;
    JLabel ClassSelectImageLabel, StoryClassImageLabel, CombatClassImageLabel;
    ImageIcon image;

    JLayeredPane layeredPane;

    private JLabel scoreLabel;
    private JTextArea highScoresTextArea;
    private JLabel messageLabel;

    Player player;

    public UI(Player player) {
        this.player = player;
    }

    public void createUI(ChoiceHandler choiceHandler) {
        // WINDOW
        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);

        // Add this at the beginning of the createUI method
        layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 800, 600);
        window.add(layeredPane);

        // TITLE SCREEN
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 100, 600, 150);
        titleNamePanel.setBackground(Color.black);
        titleNameLabel = new JLabel("THE LAST FLAME OF ERYTHAR");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);
        titleNamePanel.add(titleNameLabel);

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 350, 200, 100);
        startButtonPanel.setBackground(Color.black);

        startButton = new JButton("START");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButton.setFont(normalFont);
        startButton.setFocusPainted(false);
        startButtonPanel.add(startButton);

        startButton.addActionListener(choiceHandler);
        startButton.setActionCommand("start");

        window.add(titleNamePanel);
        window.add(startButtonPanel);

        // Name Input Screen
        nameInputPanel = new JPanel();
        nameInputPanel.setBounds(100, 100, 600, 250);
        nameInputPanel.setBackground(Color.black);
        nameInputPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        nameLabel = new JLabel("Enter your name:");
        nameLabel.setForeground(Color.white);
        nameLabel.setFont(normalFont);
        nameInputPanel.add(nameLabel);

        nameInputField = new JTextField(20);
        nameInputField.setFont(normalFont);
        nameInputPanel.add(nameInputField);

        submitNameButton = new JButton("Submit");
        submitNameButton.setBackground(Color.black);
        submitNameButton.setForeground(Color.white);
        submitNameButton.setFont(normalFont);
        submitNameButton.setFocusPainted(false);
        submitNameButton.addActionListener(choiceHandler);
        submitNameButton.setActionCommand("submitName");
        nameInputPanel.add(submitNameButton);

        feedbackLabel = new JLabel("");
        feedbackLabel.setForeground(Color.red);
        feedbackLabel.setFont(normalFont);
        feedbackLabel.setVisible(false);
        nameInputPanel.add(feedbackLabel);

        window.add(nameInputPanel);

        // Class Selection Screen
        classSelectionPanel = new JPanel();
        classSelectionPanel.setBounds(100, 100, 600, 150);
        classSelectionPanel.setBackground(Color.black);
        classSelectionPanel.setVisible(false);
        window.add(classSelectionPanel);

        welcomeTextArea = new JTextArea();
        welcomeTextArea.setBounds(100, 100, 600, 150);
        welcomeTextArea.setBackground(Color.black);
        welcomeTextArea.setForeground(Color.white);
        welcomeTextArea.setFont(normalFont);
        welcomeTextArea.setEditable(false);
        welcomeTextArea.setLineWrap(true);
        classSelectionPanel.add(welcomeTextArea);

        classButtonPanel = new JPanel();
        classButtonPanel.setBounds(100, 250, 600, 250);
        classButtonPanel.setBackground(Color.black);
        classButtonPanel.setVisible(false);
        classButtonPanel.setLayout(new GridLayout(3, 1));
        window.add(classButtonPanel);

        knightButton = new JButton("Knight");
        knightButton.setBackground(Color.black);
        knightButton.setForeground(Color.white);
        knightButton.setFont(normalFont);
        knightButton.setFocusPainted(false);
        knightButton.addActionListener(choiceHandler);
        knightButton.setActionCommand("knight");
        classButtonPanel.add(knightButton);

        sentinelButton = new JButton("Sentinel");
        sentinelButton.setBackground(Color.black);
        sentinelButton.setForeground(Color.white);
        sentinelButton.setFont(normalFont);
        sentinelButton.setFocusPainted(false);
        sentinelButton.addActionListener(choiceHandler);
        sentinelButton.setActionCommand("sentinel");
        classButtonPanel.add(sentinelButton);

        berserkerButton = new JButton("Berserker");
        berserkerButton.setBackground(Color.black);
        berserkerButton.setForeground(Color.white);
        berserkerButton.setFont(normalFont);
        berserkerButton.setFocusPainted(false);
        berserkerButton.addActionListener(choiceHandler);
        berserkerButton.setActionCommand("berserker");
        classButtonPanel.add(berserkerButton);

        // CLASS DETAILS SCREEN
        classNamePanel = new JPanel();
        classNamePanel.setBounds(100, 50, 600, 50);
        classNamePanel.setBackground(Color.black);
        classNamePanel.setVisible(false);
        window.add(classNamePanel);

        classNameLabel = new JLabel("Class Name");
        classNameLabel.setForeground(Color.white);
        classNameLabel.setFont(titleFont);
        classNamePanel.add(classNameLabel);

        classBriefPanel = new JPanel();
        classBriefPanel.setBounds(100, 100, 600, 130);
        classBriefPanel.setBackground(Color.black);
        classBriefPanel.setVisible(false);
        window.add(classBriefPanel);

        classBriefTextArea = new JTextArea();
        classBriefTextArea.setBounds(100, 150, 600, 150);
        classBriefTextArea.setBackground(Color.black);
        classBriefTextArea.setForeground(Color.white);
        classBriefTextArea.setFont(normalFont);
        classBriefTextArea.setLineWrap(true);
        classBriefTextArea.setWrapStyleWord(true);
        classBriefTextArea.setEditable(false);
        classBriefPanel.add(classBriefTextArea);

        classStatsPanel = new JPanel();
        classStatsPanel.setBounds(450, 250, 250, 50);
        classStatsPanel.setBackground(Color.black);
        classStatsPanel.setVisible(false);
        window.add(classStatsPanel);

        classStatsLabel = new JLabel();
        classStatsLabel.setForeground(Color.white);
        classStatsLabel.setFont(smallFont);
        classStatsPanel.add(classStatsLabel);

        weaponStatsPanel = new JPanel();
        weaponStatsPanel.setBounds(450, 300, 250, 50);
        weaponStatsPanel.setBackground(Color.black);
        weaponStatsPanel.setVisible(false);
        window.add(weaponStatsPanel);

        weaponStatsLabel = new JLabel();
        weaponStatsLabel.setForeground(Color.white);
        weaponStatsLabel.setFont(smallFont);
        weaponStatsPanel.add(weaponStatsLabel);

        confirmationTextPanel = new JPanel();
        confirmationTextPanel.setBounds(150, 380, 600, 70);
        confirmationTextPanel.setBackground(Color.black);
        confirmationTextPanel.setVisible(false);
        window.add(confirmationTextPanel);

        confirmationClassTextArea = new JTextArea("\nDo you wish to proceed with this class?");
        confirmationClassTextArea.setBounds(100, 300, 600, 50);
        confirmationClassTextArea.setBackground(Color.black);
        confirmationClassTextArea.setForeground(Color.white);
        confirmationClassTextArea.setFont(smallFont);
        confirmationClassTextArea.setEditable(false);
        confirmationClassTextArea.setLineWrap(true);
        confirmationTextPanel.add(confirmationClassTextArea);

        classDetailButtonPanel = new JPanel();
        classDetailButtonPanel.setBounds(150, 450, 500, 100);
        classDetailButtonPanel.setBackground(Color.red);
        classDetailButtonPanel.setVisible(false);
        classDetailButtonPanel.setLayout(new GridLayout(2, 1));
        window.add(classDetailButtonPanel);

        confirmClassButton = new JButton("Continue with this class");
        confirmClassButton.setBounds(150, 350, 500, 50);
        confirmClassButton.setBackground(Color.black);
        confirmClassButton.setForeground(Color.white);
        confirmClassButton.setFont(normalFont);
        confirmClassButton.setFocusPainted(false);
        confirmClassButton.addActionListener(choiceHandler);
        confirmClassButton.setActionCommand("confirmClass");
        classDetailButtonPanel.add(confirmClassButton);

        backButton = new JButton("Back");
        backButton.setBounds(150, 400, 500, 50);
        backButton.setBackground(Color.black);
        backButton.setForeground(Color.white);
        backButton.setFont(normalFont);
        backButton.setFocusPainted(false);
        backButton.addActionListener(choiceHandler);
        backButton.setActionCommand("backToClassSelection");
        classDetailButtonPanel.add(backButton);

        // GAME SCREEN
        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(330, 20, 450, 350);
        mainTextPanel.setBackground(Color.black);
        mainTextPanel.setLayout(new BorderLayout()); // Use BorderLayout for the panel
        // window.add(mainTextPanel);
        layeredPane.add(mainTextPanel, JLayeredPane.DEFAULT_LAYER);

        mainTextArea = new JTextArea("This is the main text area");
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setEditable(false); // make sure the text area is not editable
        mainTextArea.setLineWrap(true); // make sure the text does not go over the screen
        mainTextArea.setWrapStyleWord(true);

        // Wrap the mainTextArea in a JScrollPane
        mainTextScrollPane = new JScrollPane(mainTextArea);
        mainTextScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        mainTextScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        mainTextScrollPane.setBorder(null); // Remove the border
        mainTextPanel.add(mainTextScrollPane, BorderLayout.CENTER); // Add JScrollPane to the panel

        // Adjust scrollbar for smoother scrolling
        mainTextScrollPane.getVerticalScrollBar().setUnitIncrement(16); // Smooth scrolling
        mainTextScrollPane.getVerticalScrollBar().setBlockIncrement(32); // Larger block jumps

        // Optional: Add MouseWheelListener for further custom control
        mainTextArea.addMouseWheelListener(e -> {
            JScrollBar vertical = mainTextScrollPane.getVerticalScrollBar();
            int currentValue = vertical.getValue();
            int amount = e.getUnitsToScroll() * 10; // Customize scroll factor here
            vertical.setValue(currentValue + amount);
        });

        // choice button
        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(330, 400, 450, 150);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(4, 1)); // make the layout of choice button vertical
        // window.add(choiceButtonPanel);
        layeredPane.add(choiceButtonPanel, JLayeredPane.DEFAULT_LAYER);

        // choice1
        choice1 = new JButton("Choice 1");
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.white);
        choice1.setFont(normalFont);
        choiceButtonPanel.add(choice1);
        choice1.setFocusPainted(false);
        choice1.addActionListener(choiceHandler); // determine where it goes depends on the position
        choice1.setActionCommand("c1");

        // choice2
        choice2 = new JButton("Choice 2");
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.white);
        choice2.setFont(normalFont);
        choiceButtonPanel.add(choice2);
        choice2.setFocusPainted(false);
        choice2.addActionListener(choiceHandler);
        choice2.setActionCommand("c2");

        // choice3
        choice3 = new JButton("Choice 3");
        choice3.setBackground(Color.black);
        choice3.setForeground(Color.white);
        choice3.setFont(normalFont);
        choiceButtonPanel.add(choice3);
        choice3.setFocusPainted(false);
        choice3.addActionListener(choiceHandler);
        choice3.setActionCommand("c3");

        // choice4
        choice4 = new JButton("Choice 4");
        choice4.setBackground(Color.black);
        choice4.setForeground(Color.white);
        choice4.setFont(normalFont);
        choiceButtonPanel.add(choice4);
        choice4.setFocusPainted(false);
        choice4.addActionListener(choiceHandler);
        choice4.setActionCommand("c4");

        // Player Stats Panel
        playerPanel = new JPanel();
        playerPanel.setBounds(10, 400, 300, 150);
        playerPanel.setBackground(Color.black);
        playerPanel.setLayout(new GridBagLayout()); // Use GridBagLayout
        playerPanel.setBorder(BorderFactory.createLineBorder(Color.white)); // Add border
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Add some padding
        gbc.anchor = GridBagConstraints.WEST;
        // window.add(playerPanel);
        layeredPane.add(playerPanel, JLayeredPane.DEFAULT_LAYER);

        hpPanel = new JPanel();
        hpPanel.setBackground(Color.black);
        hpPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        hpLabel = new JLabel("HP: ");
        hpLabel.setFont(normalFont);
        hpLabel.setForeground(Color.white);
        hpPanel.add(hpLabel);

        hpLabelNum = new JLabel();
        hpLabelNum.setFont(normalFont);
        hpLabelNum.setForeground(Color.white);
        hpPanel.add(hpLabelNum);

        gbc.gridx = 0;
        gbc.gridy = 0;
        playerPanel.add(hpPanel, gbc);

        weaponPanel = new JPanel();
        weaponPanel.setBackground(Color.black);
        weaponPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        weaponLabel = new JLabel("Weapon:");
        weaponLabel.setFont(normalFont);
        weaponLabel.setForeground(Color.white);
        weaponPanel.add(weaponLabel);

        weaponLabelName = new JLabel();
        weaponLabelName.setFont(normalFont);
        weaponLabelName.setForeground(Color.white);
        weaponPanel.add(weaponLabelName);

        gbc.gridx = 0;
        gbc.gridy = 1;
        playerPanel.add(weaponPanel, gbc);

        // Combat UI
        combatTextPanel = new JPanel();
        combatTextPanel.setBounds(10, 400, 490, 150);
        combatTextPanel.setBackground(Color.black);
        combatTextPanel.setLayout(new BorderLayout()); // Use BorderLayout for the panel
        combatTextPanel.setVisible(false);
        window.add(combatTextPanel);

        combatTextArea = new JTextArea("This is the combat text area");
        combatTextArea.setBackground(Color.black);
        combatTextArea.setForeground(Color.white);
        combatTextArea.setFont(normalFont);
        combatTextArea.setEditable(false); // make sure the text area is not editable
        combatTextArea.setLineWrap(true); // make sure the text does not go over the screen
        combatTextArea.setWrapStyleWord(true);

        // Wrap the combatTextArea in a JScrollPane
        combatTextScrollPane = new JScrollPane(combatTextArea);
        combatTextScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        combatTextScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        combatTextPanel.add(combatTextScrollPane, BorderLayout.CENTER); // Add JScrollPane to the panel

        // Adjust scrollbar for smoother scrolling
        combatTextScrollPane.getVerticalScrollBar().setUnitIncrement(16); // Smooth scrolling
        combatTextScrollPane.getVerticalScrollBar().setBlockIncrement(32); // Larger block jumps

        // Optional: Add MouseWheelListener for further custom control
        combatTextArea.addMouseWheelListener(e -> {
            JScrollBar vertical = combatTextScrollPane.getVerticalScrollBar();
            int currentValue = vertical.getValue();
            int amount = e.getUnitsToScroll() * 10; // Customize scroll factor here
            vertical.setValue(currentValue + amount);
        });

        // combat choice button
        combatButtonPanel = new JPanel();
        combatButtonPanel.setBounds(500, 400, 280, 150);
        combatButtonPanel.setBackground(Color.black);
        combatButtonPanel.setLayout(new GridLayout(4, 1)); // make the layout of choice button vertical
        combatButtonPanel.setVisible(false);
        window.add(combatButtonPanel);

        // combat choice1
        combatChoice1 = new JButton("Choice 1");
        combatChoice1.setBackground(Color.black);
        combatChoice1.setForeground(Color.white);
        combatChoice1.setFont(normalFont);
        combatButtonPanel.add(combatChoice1);
        combatChoice1.setFocusPainted(false);
        combatChoice1.addActionListener(choiceHandler); // determine where it goes depends on the position
        combatChoice1.setActionCommand("c1");

        // combat choice2
        combatChoice2 = new JButton("Choice 2");
        combatChoice2.setBackground(Color.black);
        combatChoice2.setForeground(Color.white);
        combatChoice2.setFont(normalFont);
        combatButtonPanel.add(combatChoice2);
        combatChoice2.setFocusPainted(false);
        combatChoice2.addActionListener(choiceHandler);
        combatChoice2.setActionCommand("c2");

        // combat choice3
        combatChoice3 = new JButton("Use Item");
        combatChoice3.setBackground(Color.black);
        combatChoice3.setForeground(Color.white);
        combatChoice3.setFont(normalFont);
        combatButtonPanel.add(combatChoice3);
        combatChoice3.setFocusPainted(false);
        combatChoice3.addActionListener(choiceHandler);
        combatChoice3.setActionCommand("useItem");

        // combat choice4
        combatChoice4 = new JButton("Choice 4");
        combatChoice4.setBackground(Color.black);
        combatChoice4.setForeground(Color.white);
        combatChoice4.setFont(normalFont);
        combatButtonPanel.add(combatChoice4);
        combatChoice4.setFocusPainted(false);
        combatChoice4.addActionListener(choiceHandler);
        combatChoice4.setActionCommand("c4");

        // Player Stats Panel for Combat
        combatPlayerPanel = new JPanel();
        combatPlayerPanel.setBounds(0, 0, 300, 150); // original 10, 400, 300, 150
        combatPlayerPanel.setBackground(Color.black);
        combatPlayerPanel.setLayout(new GridBagLayout()); // Use GridBagLayout
        combatPlayerPanel.setBorder(BorderFactory.createLineBorder(Color.white)); // Add border
        GridBagConstraints combatGbc = new GridBagConstraints();
        combatGbc.insets = new Insets(5, 5, 5, 5); // Add some padding
        combatGbc.anchor = GridBagConstraints.WEST;
        combatPlayerPanel.setVisible(false);
        window.add(combatPlayerPanel);

        combatHpPanel = new JPanel();
        combatHpPanel.setBackground(Color.black);
        combatHpPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        combatHpLabel = new JLabel("HP: ");
        combatHpLabel.setFont(normalFont);
        combatHpLabel.setForeground(Color.white);
        combatHpPanel.add(combatHpLabel);

        combatHpLabelNum = new JLabel();
        combatHpLabelNum.setFont(normalFont);
        combatHpLabelNum.setForeground(Color.white);
        combatHpPanel.add(combatHpLabelNum);

        combatGbc.gridx = 0;
        combatGbc.gridy = 0;
        combatPlayerPanel.add(combatHpPanel, combatGbc);

        combatWeaponPanel = new JPanel();
        combatWeaponPanel.setBackground(Color.black);
        combatWeaponPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        combatWeaponLabel = new JLabel("Weapon:");
        combatWeaponLabel.setFont(normalFont);
        combatWeaponLabel.setForeground(Color.white);
        combatWeaponPanel.add(combatWeaponLabel);

        combatWeaponLabelName = new JLabel();
        combatWeaponLabelName.setFont(normalFont);

        combatWeaponLabelName.setForeground(Color.white);
        combatWeaponPanel.add(combatWeaponLabelName);

        combatGbc.gridx = 0;
        combatGbc.gridy = 1;
        combatPlayerPanel.add(combatWeaponPanel, combatGbc);

        // Enemy Stats Panel similar to Player Stats Panel but only has enemy name and
        // HP
        // Enemy Stats Panel
        enemyPanel = new JPanel();
        enemyPanel.setBounds(500, 300, 300, 150);
        enemyPanel.setBackground(Color.black);
        enemyPanel.setLayout(new BorderLayout());
        enemyPanel.setBorder(BorderFactory.createLineBorder(Color.white));
        enemyPanel.setVisible(false);
        window.add(enemyPanel);

        enemyLabel = new JLabel("");
        enemyLabel.setForeground(Color.white);
        enemyLabel.setFont(normalFont);
        enemyPanel.add(enemyLabel, BorderLayout.NORTH);

        // Create a JPanel to hold the HP label and number
        JPanel hpPanel = new JPanel();
        hpPanel.setBackground(Color.black);
        hpPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        enemyHpLabel = new JLabel("HP: ");
        enemyHpLabel.setForeground(Color.white);
        enemyHpLabel.setFont(normalFont);
        hpPanel.add(enemyHpLabel);

        enemyHpLabelNum = new JLabel();
        enemyHpLabelNum.setForeground(Color.white);
        enemyHpLabelNum.setFont(normalFont);
        hpPanel.add(enemyHpLabelNum);

        enemyPanel.add(hpPanel, BorderLayout.CENTER);

        // Inventory Button
        inventoryButton = new JButton("Inventory");
        inventoryButton.setBounds(10, 10, 150, 50);
        inventoryButton.setBackground(Color.black);
        inventoryButton.setForeground(Color.white);
        inventoryButton.setFont(normalFont);
        inventoryButton.setFocusPainted(false);
        inventoryButton.addActionListener(choiceHandler);
        inventoryButton.setActionCommand("toggleInventory");
        // window.add(inventoryButton);
        layeredPane.add(inventoryButton, JLayeredPane.PALETTE_LAYER);

        // Inventory Panel
        inventoryPanel = new JPanel();
        inventoryPanel.setBounds(100, 100, 600, 400);
        inventoryPanel.setBackground(Color.black);
        inventoryPanel.setLayout(new BorderLayout());
        inventoryPanel.setVisible(false);
        // window.add(inventoryPanel);
        layeredPane.add(inventoryPanel, JLayeredPane.MODAL_LAYER);

        inventoryTextArea = new JTextArea();
        inventoryTextArea.setBackground(Color.black);
        inventoryTextArea.setForeground(Color.white);
        inventoryTextArea.setFont(normalFont);
        inventoryTextArea.setEditable(false);
        inventoryTextArea.setLineWrap(true);
        inventoryTextArea.setWrapStyleWord(true);

        inventoryScrollPane = new JScrollPane(inventoryTextArea);
        inventoryScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        inventoryScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        inventoryPanel.add(inventoryScrollPane, BorderLayout.CENTER);

        // IMAGE PANEL

        // CLASS SELECT IMAGE PANEL
        ClassSelectImagePanel = new JPanel();
        ClassSelectImagePanel.setBounds(150, 180, 300, 220);
        ClassSelectImagePanel.setBackground(Color.black);
        ClassSelectImagePanel.setVisible(false);
        layeredPane.add(ClassSelectImagePanel, JLayeredPane.DEFAULT_LAYER);

        ClassSelectImageLabel = new JLabel();

        // image = new ImageIcon("Adventurerpg/res/knight.png");
        // Resize the image to fit the ClassSelectImagePanel
        // Image scaledImage = image.getImage().getScaledInstance(300, 250,
        // Image.SCALE_SMOOTH);
        // image = new ImageIcon(scaledImage);
        // ClassSelectImageLabel.setIcon(image);
        ClassSelectImagePanel.add(ClassSelectImageLabel);

        // STORY CLASS IMAGE PANEL
        StoryClassImagePanel = new JPanel();
        StoryClassImagePanel.setBounds(10, 40, 300, 350);
        StoryClassImagePanel.setBackground(Color.black);
        StoryClassImagePanel.setVisible(false);
        layeredPane.add(StoryClassImagePanel, JLayeredPane.DEFAULT_LAYER);

        StoryClassImageLabel = new JLabel();
        StoryClassImagePanel.add(StoryClassImageLabel);

        // COMBAT IMAGE PANEL
        // COMBAT CLASS IMAGE PANEL
        CombatClassImagePanel = new JPanel();
        CombatClassImagePanel.setBounds(50, 160, 300, 230);
        CombatClassImagePanel.setBackground(Color.black);
        CombatClassImagePanel.setVisible(false);
        layeredPane.add(CombatClassImagePanel, JLayeredPane.DEFAULT_LAYER);

        CombatClassImageLabel = new JLabel();
        CombatClassImagePanel.add(CombatClassImageLabel);

        window.setVisible(true);

        // Initialize CombatEnemyImagePanel and CombatEnemyImageLabel
        CombatEnemyImagePanel = new JPanel();
        CombatEnemyImagePanel.setBounds(500, 5, 300, 290);
        CombatEnemyImagePanel.setBackground(Color.black);
        CombatEnemyImagePanel.setVisible(false); // Initially hidden
        layeredPane.add(CombatEnemyImagePanel, JLayeredPane.DEFAULT_LAYER);

        CombatEnemyImageLabel = new JLabel();
        CombatEnemyImagePanel.add(CombatEnemyImageLabel);
    }

    public void showInventory(String inventoryText) {
        inventoryTextArea.setText(inventoryText);
        inventoryPanel.setVisible(true);
        inventoryButton.setText("X"); // Change button label to "X"
    }

    public void hideInventory() {
        inventoryPanel.setVisible(false);
        inventoryButton.setText("Inventory"); // Change button label back to "Inventory"
    }

    public void toggleInventory(String inventoryText) {
        if (inventoryPanel.isVisible()) {
            hideInventory();
        } else {
            showInventory(inventoryText);
        }
    }

    public void showCombatUI(String enemyName, int enemyHp) {
        // Hide regular game UI components
        mainTextPanel.setVisible(false);
        choiceButtonPanel.setVisible(false);
        playerPanel.setVisible(false);
        inventoryButton.setVisible(false); // Hide inventory button during combat
        StoryClassImagePanel.setVisible(false);

        // Show combat UI components
        combatTextPanel.setVisible(true);
        combatButtonPanel.setVisible(true);
        combatPlayerPanel.setVisible(true);
        enemyPanel.setVisible(true);
        CombatClassImagePanel.setVisible(true);
        // Make sure the CombatEnemyImagePanel is visible
        CombatEnemyImagePanel.setVisible(true);

        // Update combat UI with enemy information
        enemyLabel.setText(enemyName);
        enemyHpLabelNum.setText("" + enemyHp);

        // Show the image of the player's class
        // Set the enemy image based on the enemy name
        setEnemyImage(enemyName);
        ImageIcon classImage = null;
        if (player.className.equals("Knight")) {
            classImage = new ImageIcon("Adventurerpg/res/knight.png");
        } else if (player.className.equals("Sentinel")) {
            classImage = new ImageIcon("Adventurerpg/res/sentinel.png");
        } else if (player.className.equals("Berserker")) {
            classImage = new ImageIcon("Adventurerpg/res/berserker.png");
        }

        CombatClassImagePanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.NORTH; // Align the image to the top of the panel
        gbc.insets = new Insets(-100, 0, 0, 0); // Move the image upwards by 50 pixels

        Image scaledImage = classImage.getImage().getScaledInstance(300, 370, Image.SCALE_SMOOTH);
        classImage = new ImageIcon(scaledImage);
        CombatClassImageLabel.setIcon(classImage);

        CombatClassImagePanel.add(CombatClassImageLabel, gbc);

        // Show the image of the enemy
        // setEnemyImage(enemyName);

    }

    public void hideCombatUI() {
        // Hide combat UI components
        combatTextPanel.setVisible(false);
        combatButtonPanel.setVisible(false);
        combatPlayerPanel.setVisible(false);
        enemyPanel.setVisible(false);
        CombatClassImagePanel.setVisible(false);
        CombatEnemyImagePanel.setVisible(false); // Hide enemy image panel

        // Show regular game UI components
        mainTextPanel.setVisible(true);
        choiceButtonPanel.setVisible(true);
        playerPanel.setVisible(true);
        inventoryButton.setVisible(true); // Show inventory button after combat
        StoryClassImagePanel.setVisible(true);
    }

    public void setEnemyImage(String enemyName) {
        ImageIcon enemyImage = null;
        switch (enemyName.toLowerCase()) {
            case "eylis":
                enemyImage = new ImageIcon("Adventurerpg/res/eylis.png");
                break;
            case "carthar":
                enemyImage = new ImageIcon("Adventurerpg/res/carthar.png");
                break;
            case "guardian":
                enemyImage = new ImageIcon("Adventurerpg/res/guardian.png");
                break;
            case "pyrelord":
                enemyImage = new ImageIcon("Adventurerpg/res/pyrelord.png");
                break;
            case "star fallen beast":
                enemyImage = new ImageIcon("Adventurerpg/res/starfallenbeast.png");
                break;
            case "starlit sentinels":
                enemyImage = new ImageIcon("Adventurerpg/res/starlightsentinel.png");
                break;
            case "astral wraiths":
                enemyImage = new ImageIcon("Adventurerpg/res/astralwraith.png");
                break;
            case "veyra":
                enemyImage = new ImageIcon("Adventurerpg/res/veyra.png");
                break;
            // Add more cases as needed for other enemies
            default:
                System.out.println("Enemy image not found for: " + enemyName);
                return; // Exit if no image is found
        }

        // Scale and set the enemy image
        Image scaledImage = enemyImage.getImage().getScaledInstance(300, 290, Image.SCALE_SMOOTH);
        enemyImage = new ImageIcon(scaledImage);
        CombatEnemyImageLabel.setIcon(enemyImage);
        CombatEnemyImagePanel.setVisible(true); // Show enemy image panel
    }

    public void resetScrollPosition() {
        mainTextArea.setCaretPosition(0);
        combatTextArea.setCaretPosition(0);
    }

    public void hideAllImagePanels() {
        ClassSelectImagePanel.setVisible(false);
        StoryClassImagePanel.setVisible(false);
        CombatClassImagePanel.setVisible(false);
        CombatEnemyImagePanel.setVisible(false);
    }

    public void createUI() {
        // Results Panel
        resultsPanel = new JPanel();
        resultsPanel.setBounds(50, 50, 700, 500);
        resultsPanel.setLayout(null);
        resultsPanel.setBackground(Color.DARK_GRAY);

        // Score Label
        scoreLabel = new JLabel("Score: 0");
        scoreLabel.setBounds(20, 20, 200, 30);
        scoreLabel.setForeground(Color.WHITE);
        scoreLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        resultsPanel.add(scoreLabel);

        // High Scores Text Area
        highScoresTextArea = new JTextArea();
        highScoresTextArea.setBounds(50, 100, 600, 300);
        highScoresTextArea.setBackground(Color.BLACK);
        highScoresTextArea.setForeground(Color.WHITE);
        highScoresTextArea.setFont(new Font("Arial", Font.PLAIN, 16));
        highScoresTextArea.setEditable(false);
        resultsPanel.add(highScoresTextArea);

        // Add resultsPanel to window but keep it hidden initially
        resultsPanel.setVisible(false);
        window.add(resultsPanel);

        // Final window settings
        window.setVisible(true);
    }

    public void initializeResultsPanel() {
        // Initialize results panel
        resultsPanel = new JPanel();
        resultsPanel.setLayout(new BoxLayout(resultsPanel, BoxLayout.Y_AXIS));
        resultsPanel.setBackground(Color.BLACK);

        // Initialize and style the message label
        messageLabel = new JLabel();
        messageLabel.setVerticalAlignment(JLabel.TOP);
        messageLabel.setHorizontalAlignment(JLabel.LEFT);
        messageLabel.setForeground(Color.WHITE);
        messageLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        // Initialize and style the high scores text area
        highScoresTextArea = new JTextArea();
        highScoresTextArea.setEditable(false);
        highScoresTextArea.setForeground(Color.YELLOW);
        highScoresTextArea.setBackground(Color.BLACK);
        highScoresTextArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        highScoresTextArea.setMargin(new Insets(10, 10, 10, 10));

        // Initialize and style the restart button
        AbstractButton restartButton = new JButton("Restart Game");
        restartButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        restartButton.addActionListener(e -> restartGame());

        // Add components to results panel
        resultsPanel.add(messageLabel);
        resultsPanel.add(Box.createVerticalStrut(20)); // Add space
        resultsPanel.add(highScoresTextArea);
        resultsPanel.add(Box.createVerticalStrut(20)); // Add space
        resultsPanel.add(restartButton);
    }

    /**
     * Update the score in the results panel.
     */
    public void updateScore(int newScore) {
        scoreLabel.setText("Score: " + newScore);
    }

    /**
     * Display a message in the results panel.
     */
    public void displayMessage(String message) {
        messageLabel.setText("<html>" + message.replace("\n", "<br>") + "</html>");
        resultsPanel.revalidate();
        resultsPanel.repaint();
    }

    /**
     * Display high scores in the results panel.
     */
    public void displayHighScores(String highScores) {
        highScoresTextArea.setText(highScores);
        resultsPanel.revalidate();
        resultsPanel.repaint();
    }

    private void restartGame() {
        System.out.println("Restarting the game...");
        // Add logic to restart the game or return to the main menu
    }
}

// public void setEnemyImage(String enemyName) {
// ImageIcon enemyImage = null;
// if (enemyName.equals("AstralWraith")) {
// enemyImage = new ImageIcon("Adventurerpg/res/astralwraith.png");
// } else if (enemyName.equals("Carthar")) {
// enemyImage = new ImageIcon("Adventurerpg/res/carthar.png");
// } else if (enemyName.equals("Eylis")) {
// enemyImage = new ImageIcon("Adventurerpg/res/eylis.png");
// } else if (enemyName.equals("Guardian")) {
// enemyImage = new ImageIcon("Adventurerpg/res/guardian.png");
// } else if (enemyName.equals("Pyrelord")) {
// enemyImage = new ImageIcon("Adventurerpg/res/pyrelord.png");
// } else if (enemyName.equals("Star Fallen Beast")) {
// enemyImage = new ImageIcon("Adventurerpg/res/starfallenbeast.png");
// } else if (enemyName.equals("Starlit Sentinels")) {
// enemyImage = new ImageIcon("Adventurerpg/res/starlightsentinels.png");
// } else if (enemyName.equals("Veyra")) {
// enemyImage = new ImageIcon("Adventurerpg/res/veyra.png");
// }

// if (enemyImage != null) {
// Image scaledImage = enemyImage.getImage().getScaledInstance(300, 290,
// Image.SCALE_SMOOTH);
// enemyImage = new ImageIcon(scaledImage);
// CombatEnemyImageLabel.setIcon(enemyImage);
// CombatEnemyImagePanel.setVisible(true); // Show enemy image panel
// }
// }
