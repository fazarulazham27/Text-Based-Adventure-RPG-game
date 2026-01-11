package Game;

import java.util.Random;

import Bosses.Carthar;
import Bosses.Eylis;
import Bosses.Veyra;
import Monster.AshenWarden;
import Monster.AstralWraiths;
import Monster.Bear;
import Monster.Goblin;
import Monster.Monsters;
import Monster.StarFallenBeast;
import Monster.StarlitSentinels;
import NPC.Kaelor;
import package02.WeaponKnife;
import package02.WeaponLongSword;

public class Story {

    Game game;
    UI ui;
    VisibilityManager vm;
    // Enemy currentEnemy;

    // Player
    Player player;

    // NPC
    Kaelor kaelor;

    // Monsters
    Monsters monster;
    Monsters guardian;

    // Bosses
    Eylis eylis;
    Veyra veyra;
    Carthar carthar;

    // Items needed for the story
    // int silverRing;

    boolean hasEclipseShard = false;
    boolean hasSeveredEmber = false;
    boolean emberOfThePyrelord = false;

    boolean fireKeepersEyes = false;

    boolean defeatedEylis = false; // Add this flag to track Eylis's defeat
    boolean defeatedVeyra = false; // Track Pyrelord defeat
    boolean defeatedCarthar = false; // Track Pyrelord defeat

    int cindersouls;

    public String currentArea; // Track the player's current area
    public boolean firstLeverPulled = false; // Track if the first lever has been pulled
    public boolean secondLeverPulled = false; // Track if the second lever has been pulled

    boolean obtainedHolyRelic = false; // Track if the holy relic is obtained
    boolean killedNpc = false; // Track if the NPC was killed
    boolean placedSoulInGuardian = false; // Track if the NPC's soul is placed in the guardian
    boolean kaelorKilled = false; // Track if Kaelor has been killed
    boolean guardianDefeated = false; // Track if the guardian has been defeated
    boolean firstTimeTalkToFirekeeper = true; // Track if the player has talked to the Firekeeper for the first time

    // Track the player's current platform
    public int playerPlatform = 0;

    // Final Boss Attacks
    public boolean isChargingAttack = false;
    public int chargeCounter = 0;
    public int corruptedPlatform = 0;
    public int corruptionCounter = 0;

    public Story(UI ui, Player player) {
        this.ui = ui;
        this.player = player;
    }

    // public void startCombat(Enemy enemy) {
    // this.currentEnemy = enemy;
    // ui.showCombatUI(enemy.getName(), enemy.hp);
    // }

    public Story(Game g, UI userInterface, VisibilityManager vManager, Player p) {

        game = g;
        ui = userInterface;
        vm = vManager;
        player = game.player;
    }

    public void defaultSetup() {

        // use the current player hp based on the selected class
        player.hp = player.maxHp;
        ui.hpLabelNum.setText("" + player.hp);

        player.currentWeapon = new WeaponKnife();
        ui.weaponLabelName.setText("" + player.currentWeapon.name);

        // Items
        // silverRing = 0;
        cindersouls = 0;
    }

    public void showInventory() {
        StringBuilder inventoryText = new StringBuilder();
        inventoryText.append("Healing Potions: ").append(player.healingItems).append("\n\n");
        inventoryText.append("Items:\n");
        for (String item : player.inventory) {
            inventoryText.append("- ").append(item).append("\n");
        }
        ui.showInventory(inventoryText.toString());
    }

    public void selectPosition(String nextPosition) {

        switch (nextPosition) {
            // case "townGate" : townGate(); break;
            // case "talkGuard": talkGuard(); break;
            // case "attackGuard": attackGuard(); break;

            // Dark souls Lore

            // Pyre Chamber
            case "pyreChamberFirst":
                pyreChamberFirst();
                break;
            case "pyreChamber":
                pyreChamber();
                break;
            case "restAtBonfire":
                restAtBonfire();
                break;
            case "teleport":
                teleport();
                break;
            case "talkToFirekeeper":
                talkToFirekeeper();
                break;
            case "farewellFirekeeper":
                farewellFirekeeper();
                break;
            case "askAboutPyrelords":
                askAboutPyrelords();
                break;
            case "askAboutPurpose":
                askAboutPurpose();
                break;
            case "pyrelordExplanation2":
                pyrelordExplanation2();
                break;
            case "pyrelordExplanation3":
                pyrelordExplanation3();
                break;
            case "pyrelordExplanationEnd":
                pyrelordExplanationEnd();
                break;
            // case "talkToBlacksmith": talkToBlacksmith(); break;
            // case "talkToMerchant": talkToMerchant(); break;
            // case "inspectThrones": inspectThrones(); break;
            // case "moveToOtherAreas": moveToOtherAreas(); break;

            // Areas
            // Valley of Dim Stars
            case "valleyOfDimStars":
                ValleyofDimStars();
                break;
            case "starKissedBonfire":
                starKissedBonfire();
                break;
            case "crossroadsOfDimStars":
                crossroadsOfDimStars();
                break;
            case "lockedDoorArea":
                lockedDoorArea();
                break;
            case "grindingStoneArea":
                grindingStoneArea();
                break;
            case "ruinedPathArea":
                ruinedPathArea();
                break;
            case "pullWestLever":
                pullWestLever();
                break;
            case "pullEastLever":
                pullEastLever();
                break;
            case "fightInRuinedPath":
                fightInRuinedPath();
                break;
            case "playerAttackInRuinedPath":
                playerAttackInRuinedPath();
                break;
            case "monsterAttackInRuinedPath":
                monsterAttackInRuinedPath();
                break;
            case "winInRuinedPath":
                winInRuinedPath();
                break;
            case "celestialRuins":
                celestialRuins();
                break;
            case "approachStatue":
                approachStatue();
                break;
            case "eylisAwakens":
                eylisAwakens();
                break;
            case "cannotFleeEylis":
                cannotFleeEylis();
                break;
            case "fightEylis":
                fightEylis();
                break;
            case "playerAttackEylis":
                playerAttackEylis();
                break;
            case "eylisAttack":
                eylisAttack();
                break;
            case "eylisPhaseTwo":
                eylisPhaseTwo();
                break;
            case "winEylis":
                winEylis();
                break;

            // The Scorched Wilds
            case "theScorchedWilds":
                theScorchedWilds();
                break;
            case "approachNpc":
                approachNpc();
                break;
            case "killNpc":
                killNpc();
                break;
            case "refuseNpc":
                refuseNpc();
                break;
            case "wildsCrossroads":
                wildsCrossroads();
                break;
            case "wildsBonfire":
                wildsBonfire();
                break;
            case "holyRelicGuardianRoom":
                holyRelicGuardianRoom();
                break;
            case "exploreChamber":
                exploreChamber();
                break;
            case "obsidianGate":
                obsidianGate();
                break;
            case "wildsCliffs":
                wildsCliffs();
                break;
            case "fightGuardian":
                fightGuardian();
                break;
            case "playerAttackGuardian":
                playerAttackGuardian();
                break;
            case "guardianAttack":
                guardianAttack();
                break;
            case "winGuardian":
                winGuardian();
                break;
            case "placeSoulInGuardian":
                placeSoulInGuardian();
                break;
            case "bossRoom":
                bossRoom();
                break;
            case "summonKaelor":
                summonKaelor();
                break;
            case "encounterVeyra":
                encounterVeyra();
                break;
            case "encounterVeyraWithKaelor":
                encounterVeyraWithKaelor();
                break;
            case "fightVeyra":
                fightVeyra();
                break;
            case "playerAttackVeyra":
                playerAttackVeyra();
                break;
            case "veyraAttack":
                veyraAttack();
                break;
            case "veyraAttackWithKaelor":
                veyraAttackWithKaelor();
                break;
            case "winVeyra":
                winVeyra();
                break;
            case "veyraPhaseTwo":
                veyraPhaseTwo();
                break;
            case "veyraPhaseTwoWithKaelor":
                veyraPhaseTwoWithKaelor();
                break;
            case "fightVeyraWithKaelor":
                fightVeyraWithKaelor();
                break;
            case "playerAttackVeyraWithKaelor":
                playerAttackVeyraWithKaelor();
                break;
            case "kaelorAttackVeyra":
                kaelorAttackVeyra();
                break;
            case "exploreBossRoom":
                exploreBossRoom();
                break;
            case "kaelorDefeated":
                kaelorDefeated();
                break;

            // The Ashen Sanctum
            case "theFracturedGate":
                theFracturedGate();
                break;
            case "hallOfCinders":
                hallOfCinders();
                break;
            case "courtyardCollapsedGate":
                courtyardCollapsedGate();
                break;
            case "searchSkeletons":
                searchSkeletons();
                break;
            case "hallConjuction":
                hallConjuction();
                break;
            case "centralAshChamber":
                centralAshChamber();
                break;
            case "theCradleOfAsh":
                theCradleOfAsh();
                break;
            case "finalBossRoom":
                finalBossRoom();
                break;
            case "fightCarthar":
                fightCarthar();
                break;
            case "attemptToEscape":
                attemptToEscape();
                break;
            case "playerAttackCarthar":
                playerAttackCarthar();
                break;
            case "cartharAttack":
                cartharAttack();
                break;
            case "enterSecondPhase":
                enterSecondPhase();
                break;
            case "fightCartharPhaseTwo":
                fightCartharPhaseTwo();
                break;
            case "playerAttackCartharPhaseTwo":
                playerAttackCartharPhaseTwo();
                break;
            case "cartharAttackPhaseTwo":
                cartharAttackPhaseTwo();
                break;
            case "choosePlatform":
                choosePlatform();
                break;
            case "jumpToPlatform1":
                jumpToPlatform1();
                break;
            case "jumpToPlatform2":
                jumpToPlatform2();
                break;
            case "jumpToPlatform3":
                jumpToPlatform3();
                break;
            case "winCarthar":
                winCarthar();
                break;

            // case "east": east(); break;
            // case "west": west(); break;
            // case "fight": fight(); break;
            // case "playerAttack": playerAttack(); break;
            // case "monsterAttack": monsterAttack(); break;

            // Others
            // case "win": win(); break;

            // If the player loses
            case "lose":
                lose();
                break;

            // Ending
            // case "ending": ending(); break;
            case "allBossesDefeated":
                allBossesDefeated();
                break;
            case "pyreChamberAfterBosses":
                pyreChamberAfterBosses();
                break;
            case "talkToFirekeeperAfterBosses":
                talkToFirekeeperAfterBosses();
                break;
            case "normalEnding":
                normalEnding();
                break;
            case "endFireEnding":
                endFireEnding();
                break;
            case "endGame":
                endGame();
                break;
            case "toTitle":
                toTitle();
                break;

        }

    }

    // STORY
    public void startGame() {
        ui.mainTextArea.setText(
                "Long ago, the Pyre of Eternity burned brightly, sustaining life and order in the realm. " +
                        "But now, it flickers weakly, on the verge of being extinguished.\n" +
                        "Three Pyrelords, corrupted by greed and ambition, stole its sacred flames to fuel their own power.\n\n"
                        +
                        "You are the last hope, chosen by fate to restore the Pyre or decide its ultimate fate.\n");
        ui.resetScrollPosition(); // Reset the scroll position to the top

        ui.choice1.setText("Begin your journey");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "pyreChamberFirst";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    // STORY
    // Dark Souls Lore
    public void pyreChamberFirst() {
        currentArea = "pyreChamber"; // Update current area
        ui.mainTextArea.setText(
                "You awaken in the Pyre Chamber, a vast, dimly lit hall dominated by the flickering Pyre of Eternity.\n"
                        +
                        "The air is thick with ash and silence, except for the crackle of weak flames.\n" +
                        "\nBefore you stands the Firekeeper, her presence calm and resolute.\n\n" +
                        "What will you do?");
        ui.resetScrollPosition(); // Reset the scroll position to the top

        ui.choice1.setText("Rest at the Bonfire");
        ui.choice2.setText("Talk to the Firekeeper");
        // ui.choice3.setText("Inspect the thrones");
        // ui.choice4.setText("Move to other areas");

        game.nextPosition1 = "restAtBonfire";
        game.nextPosition2 = "talkToFirekeeper";
        // game.nextPosition3 = "inspectThrones";
        // game.nextPosition4 = "moveToOtherAreas";
    }

    public void pyreChamber() {
        currentArea = "pyreChamber"; // Update current area
        ui.mainTextArea.setText(
                "You awaken in the Pyre Chamber, a vast, dimly lit hall dominated by the flickering Pyre of Eternity.\n"
                        +
                        "\nBefore you stands the Firekeeper, her presence calm and resolute.\n\n" +
                        "What will you do?");
        ui.resetScrollPosition(); // Reset the scroll position to the top

        ui.choice1.setText("Rest at the Bonfire");
        ui.choice2.setText("Talk to the Firekeeper");
        // ui.choice3.setText("Inspect the thrones");
        // ui.choice4.setText("Move to other areas");//might remove this

        game.nextPosition1 = "restAtBonfire";
        game.nextPosition2 = "talkToFirekeeper";
        // game.nextPosition3 = "inspectThrones";
        // game.nextPosition4 = "moveToOtherAreas";
    }

    public void restAtBonfire() {
        player.hp = player.maxHp; // Restore HP to max HP
        player.healingItems = Player.MAX_HEALING_ITEMS; // Replenish healing items
        ui.mainTextArea.setText(
                "You sit by the flickering bonfire. Its faint warmth seeps into your body, restoring your strength.\n" +
                        "\nYour HP is fully restored. ");

        ui.hpLabelNum.setText("" + player.hp);
        ui.resetScrollPosition(); // Reset the scroll position to the top

        ui.choice1.setText("Stand up");
        ui.choice2.setText("Teleport");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = currentArea; // Go back to the current area
        game.nextPosition2 = "teleport";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void teleport() {
        if (allBossesDefeated()) {
            pyreChamberAfterBosses();
        } else {
            ui.mainTextArea.setText(
                    "The bonfire flares slightly, revealing a list of known locations. Where would you like to go?");

            if (currentArea.equals("pyreChamber")) {
                ui.choice1.setText("Go Back");
                ui.choice2.setText("Valley of Dim Stars");
                ui.choice3.setText("The Scorched Wilds");
                ui.choice4.setText("The Ashen Sanctum");

                game.nextPosition1 = "pyreChamber";
                game.nextPosition2 = "valleyOfDimStars";
                game.nextPosition3 = "theScorchedWilds";
                game.nextPosition4 = "theFracturedGate";

            } else if (currentArea.equals("starKissedBonfire")) {
                ui.choice1.setText("Go Back");
                ui.choice2.setText("Pyre Chamber");
                ui.choice3.setText("The Scorched Wilds");
                ui.choice4.setText("The Ashen Sanctum");

                game.nextPosition1 = "starKissedBonfire";
                game.nextPosition2 = "pyreChamber";
                game.nextPosition3 = "theScorchedWilds";
                game.nextPosition4 = "theFracturedGate";

            } else if (currentArea.equals("wildsBonfire")) {
                ui.choice1.setText("Go Back");
                ui.choice2.setText("Pyre Chamber");
                ui.choice3.setText("The Ashen Sanctum");
                ui.choice4.setText("Valley of Dim Stars");

                game.nextPosition1 = "wildsBonfire";
                game.nextPosition2 = "pyreChamber";
                game.nextPosition3 = "theFracturedGate";
                game.nextPosition4 = "valleyOfDimStars";

            } else if (currentArea.equals("centralAshChamber")) {
                ui.choice1.setText("Go Back");
                ui.choice2.setText("Valley of Dim Stars");
                ui.choice3.setText("The Scorched Wilds");
                ui.choice4.setText("Pyre Chamber");

                game.nextPosition1 = "centralAshChamber";
                game.nextPosition2 = "valleyOfDimStars";
                game.nextPosition3 = "theScorchedWilds";
                game.nextPosition4 = "pyreChamber";
            } else if (currentArea.equals("pyreChamberAfterBosses")) {
                ui.choice1.setText("Go Back");
                ui.choice2.setText("Valley of Dim Stars");
                ui.choice3.setText("The Scorched Wilds");
                ui.choice4.setText("The Ashen Sanctum");

                game.nextPosition1 = "pyreChamberAfterBosses";
                game.nextPosition2 = "valleyOfDimStars";
                game.nextPosition3 = "theScorchedWilds";
                game.nextPosition4 = "theFracturedGate";
            }
        }
    }

    public void talkToFirekeeper() {
        if (firstTimeTalkToFirekeeper) {
            ui.mainTextArea.setText(
                    "A blind maiden, shrouded in a dark robe, stands before you. She dons a white crown that cover her eyes and her pale skin is almost translucent.\n"
                            +
                            "\nThe FireKeeper turns her head as you draw near, her sightless gaze seeming to fixate on you.\n"
                            +
                            "\n'Welcome to the bonfire, Unkindled One. I am a Fire Keeper. I tend to the flame, and tend to thee.\nThe Lords have left their thrones, and must be deliver'd to them. To this end, I am at thy side.'");
            firstTimeTalkToFirekeeper = false;
        } else {
            ui.mainTextArea.setText(
                    "The Firekeeper senses your presence and turns her head towards you.\n\n" +
                            "\"Welcome Home, ashen one. Speak thine heart's desire.\"\n");
        }

        vm.showFirekeeperImage(); // Show the Firekeeper image

        ui.resetScrollPosition(); // Reset the scroll position to the top

        ui.choice1.setText("Go Back");
        ui.choice2.setText("Ask about Pyrelords");
        ui.choice3.setText("Ask about purpose");
        ui.choice4.setText("");

        game.nextPosition1 = "farewellFirekeeper";
        game.nextPosition2 = "askAboutPyrelords";
        game.nextPosition3 = "askAboutPurpose";
        game.nextPosition4 = "";
    }

    public void farewellFirekeeper() {
        ui.mainTextArea.setText(
                "\"Farewell, ashen one. May the flames guide thee.\"");

        vm.showPlayerClassImage(player.className); // Show the player's class image

        ui.choice1.setText("Go Back");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "pyreChamber";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void askAboutPyrelords() {
        ui.mainTextArea.setText(
                "'The Pyrelords were once keepers of the eternal flame but were consumed by their own desires,' the Firekeeper begins.\n\n"
                        +
                        "'Eylis, Keeper of Stars, sought to bind the cosmos to her will, harnessing the Pyre to create eternal constellations.'");

        ui.choice1.setText("> ");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "pyrelordExplanation2";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void pyrelordExplanation2() {
        ui.mainTextArea.setText(
                "'Veyra, Huntress of Flames, became obsessed with\nthe hunt, using the Pyre's power to craft a weapon\nthat could consume entire forests.'");

        ui.choice1.setText("> ");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "pyrelordExplanation3";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void pyrelordExplanation3() {
        ui.mainTextArea.setText(
                "'Carthar, King of Ash, sought dominion over life and death, twisting the Pyre's essence into a force of\ndecay and ruin.'");

        ui.choice1.setText("> ");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "pyrelordExplanationEnd";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void pyrelordExplanationEnd() {
        ui.mainTextArea.setText(
                "'They have scattered, their powers corrupting the\nlands they claim as their own.\n" +
                        "\nTo face them is to challenge their ambitions and reclaim what was stolen.'");

        ui.choice1.setText("Go back");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "talkToFirekeeper";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void askAboutPurpose() {
        ui.mainTextArea.setText(
                "The Firekeeper's voice is calm and soothing as she speaks:\n\n" +
                        "\"Your mission is to reclaim the stolen flames from the Pyrelords. Each of them holds a fragment of the Pyre's power, "
                        +
                        "known as Cinder Souls. You must defeat them to restore the Pyre of Eternity.\"\n\n" +
                        "\"Use the bonfires to teleport to their domains. The Valley of Dim Stars, The Scorched Wilds, and The Ashen Sanctum "
                        +
                        "are where they reside. Be vigilant, for their power is immense.\"\n");

        ui.resetScrollPosition(); // Reset the scroll position to the top

        ui.choice1.setText("Go Back");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "talkToFirekeeper";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    // public void moveToOtherAreas() {
    // ui.mainTextArea.setText(
    // "You walk through the exit and find yourself in a\nnarrow alleyway connecting
    // to other areas.\n" +
    // "\nTo your left, you hear the rhythmic clanging of the\nBlacksmith. To your
    // right, the Merchant’s voice\nbeckons."
    // );

    // ui.resetScrollPosition(); // Reset the scroll position to the top

    // ui.choice1.setText("Go Back");
    // ui.choice2.setText("Go to the Blacksmith");
    // ui.choice3.setText("Visit the Merchant");
    // ui.choice4.setText("");

    // game.nextPosition1 = "pyreChamber";
    // game.nextPosition2 = "talkToBlacksmith";
    // game.nextPosition3 = "talkToMerchant";
    // game.nextPosition4 = "";
    // }

    // public void talkToBlacksmith() {
    // ui.mainTextArea.setText(
    // "The Blacksmith glances up briefly, wiping soot from his hands.\n" +
    // "'Aye, you’ll need stronger steel to face the Pyrelords. Bring me materials,
    // and I’ll forge somethin’ worthy.'"
    // );

    // ui.choice1.setText("Go Back");
    // ui.choice2.setText("");
    // ui.choice3.setText("");
    // ui.choice4.setText("");

    // game.nextPosition1 = "moveToOtherAreas";
    // }

    // public void talkToMerchant() {
    // ui.mainTextArea.setText(
    // "The Merchant gives you a sly smile.\n" +
    // "'Coins and trinkets may seem worthless, but they can save your life. Take a
    // look at my wares, Chosen.'"
    // );

    // ui.choice1.setText("Go Back");
    // ui.choice2.setText("");
    // ui.choice3.setText("");
    // ui.choice4.setText("");

    // game.nextPosition1 = "moveToOtherAreas";
    // }

    // public void inspectThrones() {
    // ui.mainTextArea.setText(
    // "The grand thrones are cold and empty, but each bear an inscription.\n" +
    // "\nOne reads 'Eylis, Keeper of Stars,' another 'Veyra, \nHuntress of Flames,'
    // and the last 'Carthar, King of \nAsh.'\n" +
    // "\nThe Pyrelords' presence is palpable even in their\nabsence."
    // );

    // ui.resetScrollPosition(); // Reset the scroll position to the top

    // ui.choice1.setText("Go Back");
    // ui.choice2.setText("");
    // ui.choice3.setText("");
    // ui.choice4.setText("");

    // game.nextPosition1 = "pyreChamber";
    // }

    // Area of Pyrelords (Eylis)
    public void ValleyofDimStars() {
        ui.mainTextArea.setText(
                "You step into the *Valley of Dim Stars*, a forsaken land shrouded in eternal twilight.\n" +
                        "The air is thick with ash, and the faint glow of dying stars casts eerie shadows across the cracked ground.\n"
                        +
                        "\nAhead, a wavering flame flickers faintly in the distance—a lone *bonfire*, offering respite amidst the desolation.\n"
                        +
                        "\nThere are no paths back to where you came. The oppressive darkness feels endless,\n" +
                        "and you sense that rest is your only salvation.");

        ui.resetScrollPosition(); // Reset scroll position

        // Player's only option is to go to the bonfire
        ui.choice1.setText("Head toward the bonfire");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "starKissedBonfire"; // Move to the bonfire area
    }

    // First Bonfire in the Valley of Dim Stars
    public void starKissedBonfire() {
        currentArea = "starKissedBonfire"; // Update current area
        ui.mainTextArea.setText(
                "You stand before the *bonfire*. Its embers glow softly, casting warmth against the cold void.\n" +
                        "\nThe silence of the valley presses against you, but here, for a fleeting moment, there is peace.\n"
                        +
                        "\nWill you rest and let the flames mend your wounds?");

        ui.resetScrollPosition();

        // Give the player the choice to rest or not
        ui.choice1.setText("Rest at the bonfire");
        ui.choice2.setText("Explore further");
        ui.choice3.setText("Go Back");
        ui.choice4.setText("");

        game.nextPosition1 = "restAtBonfire"; // Resting logic
        game.nextPosition2 = "crossroadsOfDimStars"; // Move to the crossroads
        game.nextPosition3 = "valleyOfDimStars"; // Go back to the Valley of Dim Stars
    }

    // Crossroads of Dim Stars
    public void crossroadsOfDimStars() {
        currentArea = "crossroadsOfDimStars"; // Update current area
        ui.mainTextArea.setText(
                "You arrive at the *Crossroads of Dim Stars*. A stone plaza sprawls before you, its surface fractured "
                        +
                        "and littered with embers. Four distinct paths stretch in all directions.\n\n" +
                        "To the *North*, a massive locked door looms, shrouded in an ominous presence.\n" +
                        "To the *East*, a winding path disappears into shadowed ruins.\n" +
                        "To the *West*, a jagged passage leads toward faint sounds of grinding stone.\n" +
                        "To the *South*, the valley slopes gently back toward the Star-Kissed Bonfire.\n\n" +
                        "Where will you go?");

        ui.resetScrollPosition();

        // Player's choices for navigation
        ui.choice1.setText("Go North");
        ui.choice2.setText("Go East");
        ui.choice3.setText("Go West");
        ui.choice4.setText("Go South");

        // Update next positions for choices
        game.nextPosition1 = "lockedDoorArea"; // Path leading to the north
        game.nextPosition2 = "ruinedPathArea"; // Path leading to the right
        game.nextPosition3 = "grindingStoneArea"; // Path leading to the left
        game.nextPosition4 = "starKissedBonfire"; // Back to the first bonfire

        // Hide the combat UI
        ui.hideCombatUI();

        ui.hpLabelNum.setText("" + player.hp);
    }

    // Locked Door Area
    public void lockedDoorArea() {
        currentArea = "lockedDoorArea";

        if (firstLeverPulled && secondLeverPulled) {
            ui.mainTextArea.setText(
                    "The massive door shudders as the last seal fades away. With a deep groan, it creaks open, revealing the path ahead.");
            ui.choice1.setText("Step through the door");
            ui.choice2.setText("");
            ui.choice3.setText("");
            ui.choice4.setText("");

            game.nextPosition1 = "celestialRuins";
        } else {
            ui.mainTextArea.setText(
                    "The locked door stands silent, its runes dimly glowing.\n\n" +
                            "\"The path will open when the twin flames are rekindled.\"\n\n" +
                            "You sense that mechanisms elsewhere must still be activated.");
            ui.choice1.setText("Go Back");
            ui.choice2.setText("");
            ui.choice3.setText("");
            ui.choice4.setText("");

            game.nextPosition1 = "crossroadsOfDimStars";
        }

        ui.resetScrollPosition();
    }

    // Grinding Stone Area (West Path)
    public void grindingStoneArea() {
        currentArea = "grindingStoneArea";
        ui.mainTextArea.setText(
                "You venture west into a cavernous passage. The grinding sound grows louder until you reach a stone chamber.\n\n"
                        +
                        "A *lever* stands embedded in the ground, covered in dust and rust. It seems ancient but functional.\n\n"
                        +
                        "Do you wish to pull the lever?");

        ui.resetScrollPosition();

        ui.choice1.setText("Pull the Lever");
        ui.choice2.setText("Go Back");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "pullWestLever";
        game.nextPosition2 = "crossroadsOfDimStars";
    }

    public void pullWestLever() {
        pullLever("west");
    }

    // Ruined Path Area (East Path)
    public void ruinedPathArea() {
        currentArea = "ruinedPathArea";
        int encounterChance = new java.util.Random().nextInt(100) + 1;

        if (encounterChance <= 100) { // 100% chance to encounter an enemy
            // Randomly select an enemy
            if (encounterChance <= 33) {
                monster = new AstralWraiths();
                ui.showCombatUI(monster.name, monster.hp);
            } else if (encounterChance <= 66) {
                monster = new StarlitSentinels();
                ui.showCombatUI(monster.name, monster.hp);
            } else {
                monster = new StarFallenBeast();
                ui.showCombatUI(monster.name, monster.hp);
            }

            ui.combatHpLabelNum.setText("" + player.hp);
            ui.combatWeaponLabelName.setText("" + player.currentWeapon.name);
            ui.enemyHpLabelNum.setText("" + monster.hp);

            ui.combatTextArea.setText(
                    "As you venture deeper into the shadowy ruins, you suddenly encounter a " + monster.name + "!\n" +
                            "You can see the lever to the door is right behind the enemy.\n\n" +
                            "What do you do?");

            ui.combatChoice1.setText("Fight");
            ui.combatChoice2.setText("Run");
            ui.combatChoice3.setText("");
            ui.combatChoice4.setText("");

            game.nextPosition1 = "fightInRuinedPath";
            game.nextPosition2 = "crossroadsOfDimStars";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        } else { // This else block is redundant since encounterChance is always <= 100
            ui.combatTextArea.setText(
                    "You follow the eastern path into shadowy ruins. The air feels heavy, and faint flickers of ember light the way.\n\n"
                            +
                            "At the far end of the ruin, a *lever* waits, half-buried in rubble but intact.\n\n" +
                            "Do you wish to pull the lever?");

            ui.combatChoice1.setText("Pull the Lever");
            ui.combatChoice2.setText("Go Back");
            ui.combatChoice3.setText("");
            ui.combatChoice4.setText("");

            game.nextPosition1 = "pullEastLever";
            game.nextPosition2 = "crossroadsOfDimStars";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }

        ui.resetScrollPosition();
    }

    public void fightInRuinedPath() {
        currentArea = "ruinedPathArea";
        ui.combatTextArea.setText(monster.name + ": " + monster.hp + " HP\n\nWhat do you do?");

        ui.combatChoice1.setText("Attack");
        ui.combatChoice2.setText("Run");
        ui.combatChoice3.setText("Use Heal");
        ui.combatChoice4.setText("");

        game.nextPosition1 = "playerAttackInRuinedPath";
        game.nextPosition2 = "crossroadsOfDimStars";
        game.nextPosition3 = "useHealingItem";
        game.nextPosition4 = "";
    }

    public void playerAttackInRuinedPath() {
        int playerDamage = new java.util.Random().nextInt(player.currentWeapon.damage) + 1;

        monster.hp -= playerDamage;
        ui.combatTextArea.setText("(You attacked the " + monster.name + " and dealt " + playerDamage + " damage!)");

        ui.combatChoice1.setText(">");
        ui.combatChoice2.setText("");
        ui.combatChoice3.setText("");
        ui.combatChoice4.setText("");

        ui.enemyHpLabelNum.setText("" + monster.hp);

        if (monster.hp > 0) {
            game.nextPosition1 = "monsterAttackInRuinedPath";
        } else {
            game.nextPosition1 = "winInRuinedPath";
        }

        if (player.hp <= 0) {
            playerDies();
        }
    }

    public void monsterAttackInRuinedPath() {
        int monsterDamage = new java.util.Random().nextInt(monster.attack) + 1;
        int effectiveDamage = Math.max(monsterDamage - player.def, 0);
        player.hp -= effectiveDamage;

        ui.combatTextArea.setText(monster.attackMessage + "\n(The " + monster.name + " attacked you and dealt "
                + effectiveDamage + " damage!)");

        ui.combatHpLabelNum.setText("" + player.hp);

        ui.combatChoice1.setText(">");
        ui.combatChoice2.setText("");
        ui.combatChoice3.setText("");
        ui.combatChoice4.setText("");

        if (player.hp > 0) {
            game.nextPosition1 = "fightInRuinedPath";
        } else {
            game.nextPosition1 = "lose";
        }
    }

    public void winInRuinedPath() {
        // Award score for defeating the monster
        int scoreAwarded = monster.getScoreValue();
        player.addScore(scoreAwarded);
        ui.mainTextArea.setText("You've defeated the " + monster.name + "!\n\n" + "You earned" + scoreAwarded
                + " point! Your total score is now:" + player.getScore() + "!\n\n"
                + "At the far end of the ruin, a *lever* waits, half-buried in rubble but intact.\n\n"
                + "Do you wish to pull the lever?");

        ui.choice1.setText("Pull the Lever");
        ui.choice2.setText("Go Back");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "pullEastLever";
        game.nextPosition2 = "crossroadsOfDimStars";
        game.nextPosition3 = "";
        game.nextPosition4 = "";

        // Hide the combat UI
        ui.hideCombatUI();

        ui.hpLabelNum.setText("" + player.hp);
    }

    public void pullEastLever() {
        pullLever("east");
    }

    // Pull Lever Logic - Shared for both levers
    public void pullLever(String leverName) {
        boolean isLeverAlreadyPulled = (leverName.equals("west") && firstLeverPulled)
                || (leverName.equals("east") && secondLeverPulled);

        if (isLeverAlreadyPulled) {
            ui.mainTextArea.setText(
                    "The lever has already been pulled. The mechanism remains silent.");
        } else {
            if (leverName.equals("west")) {
                firstLeverPulled = true;
            } else if (leverName.equals("east")) {
                secondLeverPulled = true;
            }

            String progressMessage = determineLeverProgress();
            ui.mainTextArea.setText(
                    "You pull the lever. A deep rumbling echoes in the distance as unseen mechanisms grind to life.\n\n"
                            + progressMessage);
        }

        ui.resetScrollPosition();

        ui.choice1.setText("Go Back");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "crossroadsOfDimStars";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    // Helper Method: Determine Lever Progress
    public String determineLeverProgress() {
        if (firstLeverPulled && secondLeverPulled) {
            return "You feel the faint resonance of two mechanisms now active. The door to the north should open.";
        } else {
            return "You sense that another mechanism remains to be activated elsewhere.";
        }
    }

    // New Area Beyond the Door
    public void celestialRuins() {
        currentArea = "celestialRuins";
        if (defeatedEylis) {
            ui.mainTextArea.setText(
                    "The *Celestial Ruins* are eerily quiet. The statue of Eylis, now lifeless, kneels in the center of the chamber.\n\n"
                            +
                            "The celestial blade lies on the ground, its light dimmed. The air is still, and the sense of ancient sorrow has lifted.\n\n"
                            +
                            "Eylis, Keeper of Stars, has been defeated. Her presence is no longer felt here.");

            ui.choice1.setText("Explore the Ruins");
            ui.choice2.setText("Go Back");
            ui.choice3.setText("");
            ui.choice4.setText("");

            game.nextPosition1 = "exploreRuinsEdges"; // Placeholder for future content for Random loot
            game.nextPosition2 = "crossroadsOfDimStars";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        } else {
            ui.mainTextArea.setText(
                    "Beyond the massive door lies the *Celestial Ruins*, a vast chamber bathed in faint starlight streaming through cracks "
                            +
                            "in the crumbling stone ceiling.\n\n" +
                            "The ground is covered in ash and scattered embers, whispering of forgotten battles. At the center of the ruins, "
                            +
                            "a colossal *statue of a woman* kneels, her hands gently resting upon the hilt of a slender, celestial blade embedded in the ground.\n\n"
                            +
                            "The air feels heavy with ancient sorrow. Starlight swirls faintly around the figure, as if waiting... for you.");

            ui.choice1.setText("Approach the Statue");
            ui.choice2.setText("Explore the Ruins"); // Placeholder for future content for Random loot
            ui.choice3.setText("Go Back");
            ui.choice4.setText("");

            game.nextPosition1 = "approachStatue";
            game.nextPosition2 = "exploreRuinsEdges";
            game.nextPosition3 = "crossroadsOfDimStars";
            game.nextPosition4 = "";
        }

        ui.resetScrollPosition();
    }

    // Approach the Statue
    public void approachStatue() {
        currentArea = "approachStatue";
        ui.mainTextArea.setText(
                "You cautiously approach the kneeling statue. The figure is unmistakably feminine, her features serene but resolute.\n\n"
                        +
                        "Her sword, though dulled by time, still glimmers faintly with a starlit aura.\n\n" +
                        "As you step closer, the embers on the ground stir violently, and threads of starlight begin to converge upon the blade.\n\n"
                        +
                        "A soft, yet commanding voice echoes through the chamber, as though carried on the light itself:\n"
                        +
                        "\"Who dares disturb the Keeper of Stars? Have you come to claim the light... or to extinguish it?\"");

        ui.resetScrollPosition();

        ui.choice1.setText("Stand your ground");
        ui.choice2.setText("Step back and leave");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "eylisAwakens";
        game.nextPosition2 = "celestialRuins";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    // Eylis Awakens (Boss Encounter)
    public void eylisAwakens() {
        eylis = new Eylis(); // Initialize Eylis boss
        // Show combat UI
        ui.showCombatUI("Eylis", eylis.hp);
        ui.combatHpLabelNum.setText("" + player.hp);
        ui.combatWeaponLabelName.setText(player.currentWeapon.name);
        ui.enemyHpLabelNum.setText("" + eylis.hp);
        ui.combatTextArea.setText(
                "The chamber shudders as the statue begins to move. Threads of starlight weave around her, lifting her celestial blade "
                        +
                        "with grace and power.\n\n" +
                        "Her eyes open, glowing with the light of countless stars. Her voice, now resolute and echoing with power, fills the chamber:\n"
                        +
                        "\"I am *Eylis, Keeper of Stars*. These ruins are mine to guard, and this flame is not yours to take. Show me your resolve, "
                        +
                        "or be scattered like dust upon the void.\"\n\n" +
                        "*Eylis, Keeper of Stars has awakened.*");

        ui.resetScrollPosition();

        ui.combatChoice1.setText("Fight Eylis");
        ui.combatChoice2.setText("Attempt to flee");
        ui.combatChoice3.setText("");
        ui.combatChoice4.setText("");

        game.nextPosition1 = "fightEylis";
        game.nextPosition2 = "cannotFleeEylis";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void cannotFleeEylis() {
        ui.combatTextArea.setText(
                "You attempt to flee, but the chamber's doors slam shut with a force that shakes the ground.\n\n" +
                        "Eylis's voice echoes through the chamber: \"There is no escape. Face me, or be consumed by the void.\"\n\n"
                        +
                        "You have no choice but to fight.");

        ui.resetScrollPosition();

        ui.combatChoice1.setText("Fight Eylis");
        ui.combatChoice2.setText("");
        ui.combatChoice3.setText("");
        ui.combatChoice4.setText("");

        game.nextPosition1 = "fightEylis";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void fightEylis() {
        currentArea = "fightEylis";
        ui.combatTextArea.setText("Eylis: \"I am the Keeper of Stars. Your resolve will be tested.\"" +
                "\n\nWhat do you do?");

        ui.combatChoice1.setText("Attack");
        ui.combatChoice2.setText("");
        ui.combatChoice3.setText("Use Heal");
        ui.combatChoice4.setText("Run");

        game.nextPosition1 = "playerAttackEylis";
        game.nextPosition2 = "";
        game.nextPosition3 = "useHealingItem";
        game.nextPosition4 = "celestialRuins"; // Flee back to the area before the fight
    }

    public void playerAttackEylis() {
        int playerDamage = new java.util.Random().nextInt(player.currentWeapon.damage) + 1;

        eylis.hp -= playerDamage;
        ui.enemyHpLabelNum.setText("" + eylis.hp);
        ui.combatTextArea.setText("(You attacked Eylis and dealt " + playerDamage + " damage!)\n");

        ui.combatChoice1.setText(">");
        ui.combatChoice2.setText("");
        ui.combatChoice3.setText("");
        ui.combatChoice4.setText("");

        ui.enemyHpLabelNum.setText("" + eylis.hp);

        if (eylis.hp > eylis.phaseThreshold && !eylis.inPhaseTwo) {
            game.nextPosition1 = "eylisAttack";
        } else if (eylis.hp <= eylis.phaseThreshold && !eylis.inPhaseTwo) {
            game.nextPosition1 = "eylisPhaseTwo";
        } else if (eylis.hp <= 0) {
            game.nextPosition1 = "winEylis";
        } else {
            game.nextPosition1 = "eylisAttack";
        }
    }

    public void eylisAttack() {
        int eylisDamage = new java.util.Random().nextInt(eylis.attack) + 10;
        int effectiveDamage = Math.max(eylisDamage - player.def, 0);
        player.hp -= effectiveDamage;

        ui.combatTextArea.setText("Eylis attacks with a flurry of celestial strikes!\n"
                + "(You take " + effectiveDamage + " damage!)");

        ui.combatHpLabelNum.setText("" + player.hp);

        ui.combatChoice1.setText(">");
        ui.combatChoice2.setText("");
        ui.combatChoice3.setText("");
        ui.combatChoice4.setText("");

        if (player.hp > 0) {
            game.nextPosition1 = "fightEylis";
        } else {
            game.nextPosition1 = "lose";
        }
    }

    public void eylisPhaseTwo() {
        eylis.inPhaseTwo = true;
        eylis.attack += 5; // Increase attack power in Phase Two

        ui.combatTextArea.setText("Eylis: \"Impressive... but now, behold the true light of the cosmos!\"\n\n"
                + "Eylis's celestial blade ignites with starlight, and her attacks grow fiercer.");

        ui.combatChoice1.setText("Continue");
        ui.combatChoice2.setText("");
        ui.combatChoice3.setText("");
        ui.combatChoice4.setText("");

        game.nextPosition1 = "fightEylis";
    }

    public void winEylis() {
        ui.mainTextArea.setText("Eylis: \"You... are stronger than I imagined. Take this shard, "
                + "and let the stars guide your path.\"\n\n"
                + "Eylis, Keeper of Stars, has been defeated.\n\n(You obtained the Eclipse Shard!)");

        hasEclipseShard = true;
        player.inventory.add("Eclipse Shard");
        defeatedEylis = true; // Set the flag to true when Eylis is defeated
        // cindersouls = cindersouls + 1;

        ui.choice1.setText("Leave the ruins");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "celestialRuins";

        // Hide the combat UI
        ui.hideCombatUI();

        ui.hpLabelNum.setText("" + player.hp);
    }

    // Area of Pyrelords (Veyra)
    // The Scorched Wilds
    public void theScorchedWilds() {
        currentArea = "theScorchedWilds";
        if (kaelorKilled) {
            ui.mainTextArea.setText(
                    "You find yourself in the Scorched Wilds, a desolate landscape of charred trees and smoldering earth.\n"
                            +
                            "The place where Kaelor once sat is now empty. His soul has been taken, and his body lies still.");

            ui.choice1.setText("Move forward");
            ui.choice2.setText("");
            ui.choice3.setText("");
            ui.choice4.setText("");

            game.nextPosition1 = "wildsCrossroads";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        } else {
            ui.mainTextArea.setText(
                    "You step into *The Scorched Wilds*, a land where flames once roared fiercely but now smolder dimly.\n"
                            +
                            "The air is thick with heat and the acrid scent of ash. Cracked, charred earth crunches beneath your feet.\n"
                            +
                            "In the distance, faint whispers of flame flicker, hinting at dangers ahead.\n" +
                            "\nYou notice a figure sitting by the bonfire, their armor battered and worn.");

            ui.resetScrollPosition();

            ui.choice1.setText("Approach the figure");
            ui.choice2.setText("Continue forward");
            ui.choice3.setText("");
            ui.choice4.setText("");

            game.nextPosition1 = "approachNpc";
            game.nextPosition2 = "wildsCrossroads";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }
    }

    public void approachNpc() {
        currentArea = "approachNpc";
        if (kaelorKilled) {
            ui.mainTextArea.setText(
                    "The place where Kaelor once sat is now empty. His soul has been taken, and his body lies still.");

            ui.choice1.setText("Move forward");
            ui.choice2.setText("");
            ui.choice3.setText("");
            ui.choice4.setText("");

            game.nextPosition1 = "wildsCrossroads";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        } else {
            ui.mainTextArea.setText(
                    "The figure looks up as you approach. His face is scarred, his expression grim.\n" +
                            "'Hello brave warrior, I am Kaelor, once a warrior like you. I've hunted Veyra for years, but now... I'm no longer capable.'\n\n"
                            +
                            "Kaelor explains that the obsidian gate ahead is sealed and can only be opened with a holy relic,\n"
                            +
                            "guarded by a powerful foe deeper within the wilds. He pauses, his voice thick with sorrow.\n\n"
                            +
                            "'Veyra burned my family to ashes. I must see her destroyed. Take my soul, and place it in a strong vessel,\n"
                            +
                            "so I may fight alongside you. Will you grant me this mercy?'");

            ui.resetScrollPosition();

            ui.choice1.setText("Accept Kaelor's request");
            ui.choice2.setText("Refuse Kaelor's request");
            ui.choice3.setText("Go back");
            ui.choice4.setText("");

            game.nextPosition1 = "killNpc";
            game.nextPosition2 = "refuseNpc";
            game.nextPosition3 = "theScorchedWilds";
            game.nextPosition4 = "";
        }
    }

    public void killNpc() {
        killedNpc = true;
        kaelorKilled = true; // Set the flag to true when Kaelor is killed
        ui.mainTextArea.setText(
                "Kaelor kneels before you. 'Do it quickly,' he whispers.\n" +
                        "You deliver the final blow, and his soul manifests, a faint glow lingering in the air.\n" +
                        "'Thank you,' his voice echoes faintly as his body collapses. You take his soul for future use.");

        ui.resetScrollPosition();

        ui.choice1.setText("Move forward");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "wildsCrossroads";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void refuseNpc() {
        ui.mainTextArea.setText(
                "Kaelor's shoulders slump as you refuse. 'So be it,' he says quietly.\n" +
                        "'I will wait here... and grieve my failures.' He does not stop you as you leave.");

        ui.choice1.setText("Move forward");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "wildsCrossroads";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void wildsCrossroads() {
        currentArea = "wildsCrossroads";
        ui.mainTextArea.setText(
                "You arrive at the *Crossroads of Scorched Wilds*. Charred remains of twisted trees line the paths ahead.\n"
                        +
                        "The *North* leads to a faintly glowing bonfire.\n" +
                        "The *East* descends into a canyon, where a faint glow hints at danger.\n" +
                        "The *West* rises into jagged cliffs, their peaks lost in smoke.\n" +
                        "The *South* slopes back toward the bonfire.\n\n" +
                        "Where will you go?");

        ui.resetScrollPosition();

        ui.choice1.setText("Go North");
        ui.choice2.setText("Go East");
        ui.choice3.setText("Go West");
        ui.choice4.setText("Go South");

        game.nextPosition1 = "wildsBonfire";
        game.nextPosition2 = "holyRelicGuardianRoom";
        game.nextPosition3 = "wildsCliffs";
        game.nextPosition4 = "theScorchedWilds";
    }

    public void wildsBonfire() {
        currentArea = "wildsBonfire";
        ui.mainTextArea.setText(
                "You step into a small clearing where a bonfire flickers softly. The air here is slightly cooler, offering a brief respite from the heat of the wilds.\n"
                        +
                        "Will you rest at the bonfire?");

        ui.resetScrollPosition();

        ui.choice1.setText("Rest at the bonfire");
        ui.choice2.setText("Continue North");
        ui.choice3.setText("Go back");
        ui.choice4.setText("");

        game.nextPosition1 = "restAtBonfire";
        game.nextPosition2 = "obsidianGate";
        game.nextPosition3 = "wildsCrossroads";
        game.nextPosition4 = "";
    }

    public void obsidianGate() {
        currentArea = "obsidianGate";
        if (obtainedHolyRelic) {
            ui.mainTextArea.setText(
                    "The *Obsidian Gate* looms before you, its surface etched with ancient runes.\n" +
                            "As you approach, the holy relic in your possession begins to glow, resonating with the runes on the gate.\n"
                            +
                            "With a deep rumble, the gate slowly opens, revealing the path to the boss room.");

            ui.choice1.setText("Enter the boss room");
            ui.choice2.setText("Go back");
            ui.choice3.setText("");
            ui.choice4.setText("");

            game.nextPosition1 = "bossRoom"; // Replace with the actual method name for the boss room
            game.nextPosition2 = "wildsCrossroads";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        } else {
            ui.mainTextArea.setText(
                    "The *Obsidian Gate* looms before you, its surface etched with ancient runes.\n" +
                            "The air shimmers with heat, and the gate radiates a palpable sense of power.\n" +
                            "You sense that the gate is sealed with ancient magic.");

            ui.choice1.setText("Go back");
            ui.choice2.setText("");
            ui.choice3.setText("");
            ui.choice4.setText("");

            game.nextPosition1 = "wildsCrossroads";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }
    }

    // This place can be use to implement random loot
    public void wildsCliffs() {
        currentArea = "wildsCliffs";
        ui.mainTextArea.setText(
                "You climb the jagged cliffs, the air growing thinner as you ascend.\n" +
                        "The path is treacherous, but the view from the peak is breathtaking.\n" +
                        "You see the vast expanse of the Scorched Wilds below, the flames flickering like distant stars.\n"
                        +
                        "The wind howls, carrying the whispers of the past.");

        ui.resetScrollPosition();

        // Call the random loot method
        findRandomLoot();

        ui.choice1.setText("Go back");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "wildsCrossroads";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void holyRelicGuardianRoom() {
        currentArea = "holyRelicGuardianRoom";
        if (guardianDefeated) {
            ui.mainTextArea.setText(
                    "The chamber is now silent, the guardian's body lies still on the ground.\n" +
                            "The air is still thick with the remnants of the battle.\n\n" +
                            "You notice something glimmering in the corner of the room.");

            ui.choice1.setText("Explore the chamber");
            ui.choice2.setText("Leave the chamber");
            ui.choice3.setText("");
            ui.choice4.setText("");

            game.nextPosition1 = "exploreChamber";
            game.nextPosition2 = "wildsCrossroads";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        } else {
            guardian = new AshenWarden(); // Initialize the guardian as AshenWarden
            ui.showCombatUI(guardian.name, guardian.hp);
            ui.combatHpLabelNum.setText("" + player.hp);
            ui.combatWeaponLabelName.setText(player.currentWeapon.name);
            ui.enemyHpLabelNum.setText("" + guardian.hp);
            ui.combatTextArea.setText(
                    "You step into a vast chamber. At its center stands a towering figure, molten veins glowing beneath its charred armor.\n"
                            +
                            "This is the guardian of the holy relic. As it turns toward you, it lets out a deafening roar, ready to strike.");

            ui.resetScrollPosition();

            ui.combatChoice1.setText("Fight the guardian");
            ui.combatChoice2.setText("Flee");
            ui.combatChoice3.setText("");
            ui.combatChoice4.setText("");

            game.nextPosition1 = "fightGuardian";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }
    }

    // Random loot can be implemented here
    public void exploreChamber() {
        ui.mainTextArea.setText(
                "You explore the chamber and find a hidden alcove with some valuable items.\n\n" +
                        "(You obtained a rare item!)");

        ui.choice1.setText("Leave the chamber");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "wildsCrossroads";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void fightGuardian() {
        currentArea = "fightGuardian";
        ui.combatTextArea.setText(
                "You step into a vast chamber. At its center stands the Ashen Warden, molten veins glowing beneath its charred armor.\n"
                        +
                        "The Ashen Warden lets out a deafening roar, ready to strike.\n\n");

        ui.resetScrollPosition();

        ui.combatChoice1.setText("Attack");
        ui.combatChoice2.setText("");
        ui.combatChoice3.setText("Use Heal");
        ui.combatChoice4.setText("");

        game.nextPosition1 = "playerAttackGuardian";
        game.nextPosition2 = "";
        game.nextPosition3 = "useHealingItem";
        game.nextPosition4 = "";
    }

    public void playerAttackGuardian() {
        int playerDamage = new java.util.Random().nextInt(player.currentWeapon.damage) + 1;

        guardian.hp -= playerDamage;
        ui.combatTextArea.setText("(You attacked the " + guardian.name + " and dealt " + playerDamage + " damage!)\n");

        ui.combatChoice1.setText(">");
        ui.combatChoice2.setText("");
        ui.combatChoice3.setText("");
        ui.combatChoice4.setText("");

        ui.enemyHpLabelNum.setText("" + guardian.hp);

        if (guardian.hp > 0) {
            game.nextPosition1 = "guardianAttack";
        } else {
            game.nextPosition1 = "winGuardian";
        }
    }

    public void guardianAttack() {
        int guardianDamage = new java.util.Random().nextInt(guardian.attack) + 1;
        int effectiveDamage = Math.max(guardianDamage - player.def, 0);
        player.hp -= effectiveDamage;

        ui.combatTextArea.setText(guardian.attackMessage + "\n(The " + guardian.name + " attacked you and dealt "
                + effectiveDamage + " damage!)\n");

        ui.combatHpLabelNum.setText("" + player.hp);

        ui.combatChoice1.setText(">");
        ui.combatChoice2.setText("");
        ui.combatChoice3.setText("");
        ui.combatChoice4.setText("");

        if (player.hp > 0) {
            game.nextPosition1 = "fightGuardian";
        } else {
            game.nextPosition1 = "lose";
        }
    }

    public void winGuardian() {
        // Award score for defeating the monster
        int scoreAwarded = guardian.getScoreValue();
        player.addScore(scoreAwarded);
        ui.mainTextArea.setText("You've defeated the " + guardian.name + "!\n\n(You obtained the holy relic!)");
        obtainedHolyRelic = true;
        guardianDefeated = true; // Set the flag to true when the guardian is defeated

        if (killedNpc) {
            ui.mainTextArea.append("\n\nYou have Kaelor's soul. Do you wish to place it into the guardian?");
            ui.choice1.setText("Place Kaelor's soul");
            ui.choice2.setText("Leave the chamber");
            ui.choice3.setText("");
            ui.choice4.setText("");

            game.nextPosition1 = "placeSoulInGuardian";
            game.nextPosition2 = "wildsCrossroads";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        } else {
            ui.choice1.setText("Leave the chamber");
            ui.choice2.setText("");
            ui.choice3.setText("");
            ui.choice4.setText("");

            game.nextPosition1 = "wildsCrossroads";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }
        // Hide the combat UI
        ui.hideCombatUI();

        ui.hpLabelNum.setText("" + player.hp);
    }

    public void placeSoulInGuardian() {
        placedSoulInGuardian = true;
        ui.mainTextArea.setText(
                "You place Kaelor's soul into the guardian's body. The molten veins pulse brighter, and the figure stands tall.\n"
                        +
                        "'I am reborn,' Kaelor's voice rumbles. 'Face Veyra, Huntress of Flames, and when you do... Summon me. Summon my Soul'");

        ui.choice1.setText("Go back");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "wildsCrossroads";
    }

    public void bossRoom() {
        currentArea = "bossRoom";
        if (defeatedVeyra) {
            ui.mainTextArea.setText(
                    "The boss room is now empty, the air still heavy with the remnants of the battle.\n" +
                            "Veyra, Huntress of Flames, has been defeated. Her presence is no longer felt here.\n\n" +
                            "You notice something glimmering in the corner of the room.");

            ui.choice1.setText("Explore the area");
            ui.choice2.setText("Leave the boss room");
            ui.choice3.setText("");
            ui.choice4.setText("");

            game.nextPosition1 = "exploreBossRoom";
            game.nextPosition2 = "obsidianGate";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        } else {
            if (placedSoulInGuardian) {
                ui.mainTextArea.setText(
                        "You step into the boss room, the air thick with tension. The guardian's body stands ready, its molten veins pulsing with energy.\n");

                ui.choice1.setText("Summon Kaelor");
                ui.choice2.setText("Face the boss alone");
                ui.choice3.setText("Go back");
                ui.choice4.setText("");

                game.nextPosition1 = "summonKaelor";
                game.nextPosition2 = "encounterVeyra";
                game.nextPosition3 = "obsidianGate";
                game.nextPosition4 = "";
            } else {
                ui.mainTextArea.setText(
                        "You step into the boss room, the air thick with tension. The ground trembles as the boss approaches.");

                ui.choice1.setText("Face the boss");
                ui.choice2.setText("Go back");
                ui.choice3.setText("");
                ui.choice4.setText("");

                game.nextPosition1 = "encounterVeyra";
                game.nextPosition2 = "obsidianGate";
                game.nextPosition3 = "";
                game.nextPosition4 = "";
            }
        }
    }

    public void exploreBossRoom() {
        ui.mainTextArea.setText(
                "You explore the boss room and find a hidden alcove with some valuable items.\n\n" +
                        "(You obtained a rare item!)");

        ui.choice1.setText("Leave the boss room");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "obsidianGate";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void summonKaelor() {
        ui.mainTextArea.setText(
                "You summon Kaelor, and the guardian's body springs to life. Kaelor's voice rumbles.\n" +
                        "\n\"Curse you, Veyra!\n" + //
                        "Your flames consumed my family and scarred my soul!\n" + //
                        "But today, your infernal reign ends!\"\n" + //
                        "\n" + //
                        "\"Behold, a warrior reborn! I am Kaelor, the Broken Blade,\n" + //
                        "and I shall become your undoing!\"\n" + //
                        "\n" + //
                        "\"Your fire may burn eternal, foul Pyrelord,\n" + //
                        "but I will douse it with my fury and vengeance!\n" + //
                        "With every strike, every ounce of strength I possess,\n" + //
                        "I will carve your demise into the very flames you wield!\"\n" + //
                        "\nThe ground trembles as the boss approaches.");

        ui.resetScrollPosition();

        ui.choice1.setText(">");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "encounterVeyraWithKaelor";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    // Player vs. Veyra (1vs1)
    public void encounterVeyra() {
        veyra = new Veyra(); // Initialize Veyra boss
        ui.showCombatUI(veyra.name, veyra.hp);
        ui.combatHpLabelNum.setText("" + player.hp);
        ui.combatWeaponLabelName.setText(player.currentWeapon.name);
        ui.enemyHpLabelNum.setText("" + veyra.hp);

        ui.combatTextArea.setText(
                "The ground shakes as Veyra, Huntress of Flames, emerges from the shadows. Her eyes burn with a fierce intensity, and her weapon glows with a searing heat.\n"
                        +
                        "'You dare challenge me? Prepare to be consumed by the flames!'");

        ui.combatChoice1.setText("Fight Veyra");
        ui.combatChoice2.setText("");
        ui.combatChoice3.setText("");
        ui.combatChoice4.setText("");

        game.nextPosition1 = "fightVeyra";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void fightVeyra() {
        currentArea = "fightVeyra";
        ui.combatTextArea.setText(
                "Veyra: \"You dare challenge me? Prepare to be consumed by the flames!\"\n\n" + "What do you do?");

        ui.combatChoice1.setText("Attack");
        ui.combatChoice2.setText("");
        ui.combatChoice3.setText("Use Heal");
        ui.combatChoice4.setText("Run");

        game.nextPosition1 = "playerAttackVeyra";
        game.nextPosition2 = "";
        game.nextPosition3 = "useHealingItem";
        game.nextPosition4 = "obsidianGate"; // Flee back to the area before the fight
    }

    public void playerAttackVeyra() {
        int playerDamage = new java.util.Random().nextInt(player.currentWeapon.damage) + 1;

        veyra.hp -= playerDamage;
        ui.combatTextArea.setText("(You attacked Veyra and dealt " + playerDamage + " damage!)\n");

        ui.combatChoice1.setText(">");
        ui.combatChoice2.setText("");
        ui.combatChoice3.setText("");
        ui.combatChoice4.setText("");

        ui.enemyHpLabelNum.setText("" + veyra.hp);

        if (veyra.hp > veyra.phaseThreshold && !veyra.inPhaseTwo) {
            game.nextPosition1 = "veyraAttack";
        } else if (veyra.hp <= veyra.phaseThreshold && !veyra.inPhaseTwo) {
            game.nextPosition1 = "veyraPhaseTwo";
        } else if (veyra.hp <= 0) {
            game.nextPosition1 = "winVeyra";
        } else {
            game.nextPosition1 = "veyraAttack";
        }
    }

    public void veyraAttack() {
        int veyraDamage = new java.util.Random().nextInt(veyra.attack) + 1;
        int effectiveDamage = Math.max(veyraDamage - player.def, 0);
        player.hp -= effectiveDamage;

        ui.combatTextArea.setText("Veyra attacks with a fiery strike!\n"
                + "(You take " + effectiveDamage + " damage!)\n");

        ui.combatHpLabelNum.setText("" + player.hp);

        ui.combatChoice1.setText(">");
        ui.combatChoice2.setText("");
        ui.combatChoice3.setText("");
        ui.combatChoice4.setText("");

        if (player.hp > 0) {
            game.nextPosition1 = "fightVeyra";
        } else {
            game.nextPosition1 = "lose";
        }
    }

    public void veyraPhaseTwo() {
        veyra.inPhaseTwo = true;
        veyra.attack += 10; // Increase attack power in Phase Two

        ui.combatTextArea.setText("Veyra: \"You think you can defeat me? Feel the true wrath of the flames!\"\n\n"
                + "Veyra's weapon ignites with intense flames, and her attacks grow fiercer.");

        ui.combatChoice1.setText("Continue");
        ui.combatChoice2.setText("");
        ui.combatChoice3.setText("");
        ui.combatChoice4.setText("");

        game.nextPosition1 = "fightVeyra";
    }

    // Player & Kaelor vs. Veyra (Boss Fight)
    public void encounterVeyraWithKaelor() {
        kaelor = new Kaelor(); // Initialize Kaelor as an ally
        veyra = new Veyra(); // Initialize Veyra boss
        ui.showCombatUI(veyra.name, veyra.hp);
        ui.combatHpLabelNum.setText("" + player.hp);
        ui.combatWeaponLabelName.setText(player.currentWeapon.name);
        ui.enemyHpLabelNum.setText("" + veyra.hp);

        ui.combatTextArea.setText(
                "The ground shakes as Veyra, Huntress of Flames, emerges from the shadows. Her eyes burn with a fierce intensity, and her weapon glows with a searing heat.\n"
                        +
                        "'You dare challenge me? Prepare to be consumed by the flames!'\n\n" +
                        "Kaelor stands by your side, ready to fight.");

        ui.resetScrollPosition();

        ui.combatChoice1.setText("Fight Veyra");
        ui.combatChoice2.setText("");
        ui.combatChoice3.setText("");
        ui.combatChoice4.setText("");

        game.nextPosition1 = "fightVeyraWithKaelor";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void fightVeyraWithKaelor() {
        currentArea = "fightVeyraWithKaelor";
        ui.combatTextArea.setText(
                "Veyra: \"You dare challenge me? Prepare to be consumed by the flames!\"\n\n" + "What do you do?");

        ui.combatChoice1.setText("Attack");
        ui.combatChoice2.setText("");
        ui.combatChoice3.setText("Use Heal");
        ui.combatChoice4.setText("Run");

        game.nextPosition1 = "playerAttackVeyraWithKaelor";
        game.nextPosition2 = "";
        game.nextPosition3 = "useHealingItem";
        game.nextPosition4 = "obsidianGate"; // Flee back to the area before the fight
    }

    public void playerAttackVeyraWithKaelor() {
        int playerDamage = new java.util.Random().nextInt(player.currentWeapon.damage) + 1;

        veyra.hp -= playerDamage;
        ui.combatTextArea.setText("(You attacked Veyra and dealt " + playerDamage + " damage!)\n");

        ui.combatChoice1.setText(">");
        ui.combatChoice2.setText("");
        ui.combatChoice3.setText("");
        ui.combatChoice4.setText("");

        ui.enemyHpLabelNum.setText("" + veyra.hp);

        if (veyra.hp > veyra.phaseThreshold && !veyra.inPhaseTwo) {
            game.nextPosition1 = "kaelorAttackVeyra";
        } else if (veyra.hp <= veyra.phaseThreshold && !veyra.inPhaseTwo) {
            game.nextPosition1 = "veyraPhaseTwoWithKaelor";
        } else if (veyra.hp <= 0) {
            game.nextPosition1 = "winVeyra";
        } else {
            game.nextPosition1 = "kaelorAttackVeyra";
        }
    }

    public void kaelorAttackVeyra() {
        int kaelorDamage = new java.util.Random().nextInt(kaelor.weapon.damage) + 1;

        veyra.hp -= kaelorDamage;
        ui.combatTextArea.setText("(Kaelor attacked Veyra and dealt " + kaelorDamage + " damage!)\n");

        ui.combatChoice1.setText(">");
        ui.combatChoice2.setText("");
        ui.combatChoice3.setText("");
        ui.combatChoice4.setText("");

        if (veyra.hp > veyra.phaseThreshold && !veyra.inPhaseTwo) {
            game.nextPosition1 = "veyraAttackWithKaelor";
        } else if (veyra.hp <= veyra.phaseThreshold && !veyra.inPhaseTwo) {
            game.nextPosition1 = "veyraPhaseTwoWithKaelor";
        } else if (veyra.hp <= 0) {
            game.nextPosition1 = "winVeyra";
        } else {
            game.nextPosition1 = "veyraAttackWithKaelor";
        }
    }

    public void veyraAttackWithKaelor() {
        int target;
        if (kaelor.hp <= 0) {
            target = 0; // Always target the player if Kaelor is defeated
        } else {
            target = new java.util.Random().nextInt(2); // 0 for player, 1 for Kaelor
        }

        int veyraDamage = new java.util.Random().nextInt(veyra.attack) + 1;
        int effectiveDamage;

        if (target == 0) {
            effectiveDamage = Math.max(veyraDamage - player.def, 0);
            player.hp -= effectiveDamage;
            ui.combatTextArea.setText("Veyra attacks you with a fiery strike!\n"
                    + "(You take " + effectiveDamage + " damage!)\n");
            ui.combatHpLabelNum.setText("" + player.hp);
        } else {
            effectiveDamage = Math.max(veyraDamage - kaelor.def, 0);
            kaelor.hp -= effectiveDamage;
            ui.combatTextArea.setText("Veyra attacks Kaelor with a fiery strike!\n"
                    + "(Kaelor takes " + effectiveDamage + " damage!)\n"
                    + "\nKaelor's HP: " + kaelor.hp);
        }

        ui.combatChoice1.setText(">");
        ui.combatChoice2.setText("");
        ui.combatChoice3.setText("");
        ui.combatChoice4.setText("");

        if (player.hp > 0 && kaelor.hp > 0) {
            game.nextPosition1 = "fightVeyraWithKaelor";
        } else if (player.hp <= 0) {
            game.nextPosition1 = "lose";
        } else {
            game.nextPosition1 = "kaelorDefeated";
        }
    }

    public void veyraPhaseTwoWithKaelor() {
        veyra.inPhaseTwo = true;
        veyra.attack += 10; // Increase attack power in Phase Two

        ui.combatTextArea.setText("Veyra: \"You think you can defeat me? Feel the true wrath of the flames!\"\n\n"
                + "Veyra's weapon ignites with intense flames, and her attacks grow fiercer.");

        ui.combatChoice1.setText("Continue");
        ui.combatChoice2.setText("");
        ui.combatChoice3.setText("");
        ui.combatChoice4.setText("");

        game.nextPosition1 = "fightVeyraWithKaelor";
    }

    // If Kaelor is defeated, player will face Veyra alone
    public void kaelorDefeated() {
        ui.combatTextArea.setText(
                "Kaelor: \"I... I have failed... My family... I couldn't avenge them...\"\n\n" +
                        "Kaelor's body collapses to the ground, lifeless. His spirit fades away, leaving you to face Veyra alone.");

        ui.combatChoice1.setText("Continue");
        ui.combatChoice2.setText("");
        ui.combatChoice3.setText("");
        ui.combatChoice4.setText("");

        game.nextPosition1 = "fightVeyraAlone";
    }

    // If Kaerlor is defeated, player will face Veyra alone
    public void fightVeyraAlone() {
        currentArea = "fightVeyraAlone";
        ui.combatTextArea.setText(
                "Veyra: \"You dare challenge me? Prepare to be consumed by the flames!\"\n\n" + "What do you do?");

        ui.combatChoice1.setText("Attack");
        ui.combatChoice2.setText("");
        ui.combatChoice3.setText("Use Heal");
        ui.combatChoice4.setText("");

        game.nextPosition1 = "playerAttackVeyraAlone";
        game.nextPosition2 = "";
        game.nextPosition3 = "useHealingItem";
        game.nextPosition4 = ""; // Flee back to the area before the fight
    }

    public void playerAttackVeyraAlone() {
        int playerDamage = new java.util.Random().nextInt(player.currentWeapon.damage) + 1;

        veyra.hp -= playerDamage;
        ui.combatTextArea.setText("(You attacked Veyra and dealt " + playerDamage + " damage!)\n");

        ui.combatChoice1.setText(">");
        ui.combatChoice2.setText("");
        ui.combatChoice3.setText("");
        ui.combatChoice4.setText("");

        ui.enemyHpLabelNum.setText("" + veyra.hp);

        if (veyra.hp > veyra.phaseThreshold && !veyra.inPhaseTwo) {
            game.nextPosition1 = "veyraAttackAlone";
        } else if (veyra.hp <= veyra.phaseThreshold && !veyra.inPhaseTwo) {
            game.nextPosition1 = "veyraPhaseTwoAlone";
        } else if (veyra.hp <= 0) {
            game.nextPosition1 = "winVeyra";
        } else {
            game.nextPosition1 = "veyraAttackAlone";
        }
    }

    public void veyraAttackAlone() {
        int veyraDamage = new java.util.Random().nextInt(veyra.attack) + 1;
        int effectiveDamage = Math.max(veyraDamage - player.def, 0);
        player.hp -= effectiveDamage;

        ui.combatTextArea.setText("Veyra attacks with a fiery strike!\n"
                + "(You take " + effectiveDamage + " damage!)\n");

        ui.combatHpLabelNum.setText("" + player.hp);

        ui.combatChoice1.setText(">");
        ui.combatChoice2.setText("");
        ui.combatChoice3.setText("");
        ui.combatChoice4.setText("");

        if (player.hp > 0) {
            game.nextPosition1 = "fightVeyraAlone";
        } else {
            game.nextPosition1 = "lose";
        }
    }

    public void veyraPhaseTwoAlone() {
        veyra.inPhaseTwo = true;
        veyra.attack += 10; // Increase attack power in Phase Two

        ui.combatTextArea.setText("Veyra: \"You think you can defeat me? Feel the true wrath of the flames!\"\n\n"
                + "Veyra's weapon ignites with intense flames, and her attacks grow fiercer.");

        ui.combatChoice1.setText("Continue");
        ui.combatChoice2.setText("");
        ui.combatChoice3.setText("");
        ui.combatChoice4.setText("");

        game.nextPosition1 = "fightVeyraAlone";
    }

    public void winVeyra() {
        if (kaelor != null && kaelor.hp > 0) {
            int scoreAwarded = veyra.getScoreValue();
            player.addScore(scoreAwarded);
            ui.mainTextArea.setText(
                    "Veyra: \"No... I was the hunter... How could I fall to the likes of you? Burn this memory... into eternity...\"\n\n"
                            +
                            "Veyra, Huntress of Flames, has been defeated.\n\n" +
                            "Kaelor: \"You shall haunt me no longer!\"\n\n" +
                            "As Veyra falls, Kaelor kneels beside her ashes. 'I have avenged my family. Thank you, warrior.'\n"
                            +
                            "With that, the light fades from his form, and his body collapses." +
                            "\n\n(You obtained the Severed Ember!)");
        } else {
            ui.mainTextArea.setText(
                    "Veyra: \"No... I was the hunter... How could I fall to the likes of you? Burn this memory... into eternity...\"\n\n"
                            +
                            "Veyra, Huntress of Flames, has been defeated.\n\n(You obtained the Severed Ember!)");
        }

        player.inventory.add("Severed Ember");
        hasSeveredEmber = true;
        defeatedVeyra = true; // Set the flag to true when Veyra is defeated
        cindersouls = cindersouls + 1;

        ui.choice1.setText("Return to bonfire");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "wildsBonfire";

        // Hide the combat UI
        ui.hideCombatUI();

        ui.hpLabelNum.setText("" + player.hp);
    }

    // The Ashen Sanctum
    public void theFracturedGate() {
        currentArea = "theFracturedGate";
        ui.mainTextArea.setText(
                "You stand before the *Fractured Gate*, its shattered remnants clawing upward like jagged fangs. " +
                        "Ash rains down in a relentless haze, coating the ground and filling the air with the acrid scent of smoldering ruin.\n\n"
                        +
                        "To the left, a section of the gate has collapsed, revealing a narrow passage leading to what appears to be a ruined courtyard."
                        +
                        "\nThe main path ahead leads deeper into the Ashen Sanctum, its entrance marked by colossal doors carved with images of flame and decay.\n\n"
                        +
                        "You feel the weight of countless battles fought and lost here, the echoes of desperation etched into every fragment of this place.");

        ui.resetScrollPosition();

        ui.choice1.setText("Step through the gate");
        ui.choice2.setText("Go left");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "hallOfCinders";
        game.nextPosition2 = "courtyardCollapsedGate";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    // Courtyard Path
    public void courtyardCollapsedGate() {
        currentArea = "courtyardCollapsedGate"; // Update current area
        ui.mainTextArea.setText(
                "You squeeze through the narrow opening, emerging into a *ruined courtyard*. The air is eerily still, broken only "
                        +
                        "by the faint crackle of embers. In the center of the courtyard stands a *charred tree*, its twisted branches reaching skyward like claws.\n\n"
                        +
                        "Beneath its roots, you notice a skeletal remains lie scattered, you found one remains with tattered black robe, striking a resemblane to the FireKeeper back in the Pyre Chamber, clutching "
                        +
                        "an item in its hands.");

        ui.resetScrollPosition(); // Reset the scroll position to the top

        ui.choice1.setText("Search the skeletons");
        ui.choice2.setText("");
        ui.choice3.setText("Go back");
        ui.choice4.setText("");

        game.nextPosition1 = "searchSkeletons";
        game.nextPosition2 = "";
        game.nextPosition3 = "theFracturedGate";
        game.nextPosition4 = "";
    }

    public void searchSkeletons() {
        if (!fireKeepersEyes) {
            ui.mainTextArea.setText(
                    "You search the skeletons and find a pair of eyes, faintly glowing with an eerie light.\n\n" +
                            "(You obtained the Fire Keeper's Eyes!)");

            // Add the Fire Keeper's Eyes to the player's inventory
            player.inventory.add("Fire Keeper's Eyes");
            fireKeepersEyes = true; // Set the flag to true
        } else {
            ui.mainTextArea.setText(
                    "You search the skeletons but find nothing of interest. It seems you have already taken the Fire Keeper's Eyes.");
        }

        ui.choice1.setText("Go back");

        game.nextPosition1 = "courtyardCollapsedGate";

    }

    // Entrance to the Ashen Sanctum
    public void hallOfCinders() {
        currentArea = "hallOfCinders"; // Update current area
        ui.mainTextArea.setText(
                "You proceed through the fractured gate, stepping over the brittle remains of forgotten warriors. Each step echoes faintly, swallowed by the oppressive silence."
                        +
                        "The path ahead leads to the *Hall of Cinders*, a vast chamber shrouded in shadows. The air is thick with the scent of ash and decay, and the walls are lined with "
                        +
                        "crumbling statues of ancient warriors.\n\n" +
                        "The statues seem almost alive, their forms twisted as if caught in their final moments of agony."
                        +
                        "At the far end, a massive shadowed figure looms, but as you draw closer, it vanishes into the rising smoke."
                        +
                        "The walls tremble periodically, a low rumble reverberating through the hall, as if the very stone resents your presence.");

        ui.resetScrollPosition(); // Reset the scroll position to the top

        ui.choice1.setText("Proceed");
        ui.choice2.setText("");
        ui.choice3.setText("Go back");
        ui.choice4.setText("");

        game.nextPosition1 = "hallConjuction";
        game.nextPosition2 = "";
        game.nextPosition3 = "theFracturedGate";
        game.nextPosition4 = "";
    }

    public void hallConjuction() {
        currentArea = "hallConjuction"; // Update current area
        ui.mainTextArea.setText(
                "You steel yourself and move forward, the oppressive heat intensifying with every step. The faint sound of cracking stone echoes behind you, but you don’t dare look back."
                        +
                        "The path splits into two directions, each leading deeper into the Ashen Sanctum." +
                        "To your north, you see a slight flickering of ember." +
                        "To your East, you notice a faint glow emanating from a crack in the wall.");

        ui.resetScrollPosition(); // Reset the scroll position to the top

        ui.choice1.setText("Go North");
        ui.choice2.setText("Go East");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "centralAshChamber";
        game.nextPosition2 = "easternAshChamber";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void centralAshChamber() {
        // description of the area with bonfire
        currentArea = "centralAshChamber"; // Update current area
        ui.mainTextArea.setText(
                "You step into the *Central Ash Chamber*, the air thick with the scent of smoldering embers. The chamber is vast, its walls lined with ancient runes and symbols long forgotten."
                        +
                        "At the center of the chamber, a *bonfire* burns with a steady flame, casting flickering shadows across the room."
                        +
                        "The flames dance with an otherworldly light, their warmth beckoning you closer." +
                        "You feel a sense of calm wash over you, the crackling of the flames a soothing melody amidst the oppressive silence.");

        ui.resetScrollPosition();

        ui.choice1.setText("Rest at the bonfire");
        ui.choice2.setText("Go Deeper");
        ui.choice3.setText("Go Back");
        ui.choice4.setText("");

        game.nextPosition1 = "restAtBonfire";
        game.nextPosition2 = "theCradleOfAsh";
        game.nextPosition3 = "hallConjuction";
    }

    public void theCradleOfAsh() {
        currentArea = "theCradleOfAsh"; // Update current area
        ui.mainTextArea.setText(
                "You found yourself in a place with towering staircase. The staircase spirals upward, each step more jagged and unstable than the last.\nThe walls are scorched black, glowing faintly with veins of molten ash.\n\nAs you ascend, the heat intensifies, and the oppressive atmosphere grows heavier. At the top of the stairs, a colossal circular door looms, sealed with runes that pulse faintly with a fiery glow.\n\nThe door begins to creak open as you approach, the runes flaring one final time before fading into darkness. Smoke and flame spill through the widening gap, revealing the ominous arena beyond.");

        ui.resetScrollPosition();

        ui.choice1.setText("Step through the door");
        ui.choice2.setText("Go Back");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "finalBossRoom";
        game.nextPosition2 = "centralAshChamber";
        game.nextPosition3 = "";
    }

    // final boss room
    public void finalBossRoom() {
        currentArea = "finalBossRoom"; // Update current area

        if (defeatedCarthar) {
            ui.mainTextArea.setText(
                    "The boss room is now empty, the air still heavy with the remnants of the battle.\n" +
                            "Carthar, King of Ash, has been defeated. His presence is no longer felt here.\n\n" +
                            "You notice something glimmering in the corner of the room.");

            ui.choice1.setText("Go back");
            ui.choice2.setText("");
            ui.choice3.setText("");
            ui.choice4.setText("");

            game.nextPosition1 = "theCradleOfAsh";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        } else {
            carthar = new Carthar(); // Initialize Pyrelord boss
            ui.showCombatUI(carthar.name, carthar.hp);
            ui.combatHpLabelNum.setText("" + player.hp);
            ui.combatWeaponLabelName.setText(player.currentWeapon.name);
            ui.enemyHpLabelNum.setText("" + carthar.hp);

            ui.combatTextArea.setText(
                    "You step through the door, entering the *Final Boss Room*. The air is thick with the acrid scent of burning ash, and the ground trembles beneath your feet.\n\n"
                            +
                            "At the center of the room stands the *Pyrelord*, a towering figure wreathed in flames. Its eyes burn with an otherworldly light, and its voice echoes through the chamber like the roar of a distant inferno.\n\n"
                            +
                            "The Pyrelord raises its weapon, a massive blade of molten fire, and the ground erupts in a shower of embers. The final battle begins.");

            ui.resetScrollPosition(); // Reset the scroll position to the top

            ui.combatChoice1.setText("Fight Carthar");
            ui.combatChoice2.setText("");
            ui.combatChoice3.setText("");
            ui.combatChoice4.setText("");

            game.nextPosition1 = "fightCarthar";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }
    }

    public void fightCarthar() {
        currentArea = "fightCarthar";
        ui.combatTextArea.setText(
                "Carthar raises its weapon, a massive blade of molten fire, and the ground erupts in a shower of embers. The final battle begins.\n\n"
                        + "What do you do?");

        ui.combatChoice1.setText("Attack");
        ui.combatChoice2.setText("");
        ui.combatChoice3.setText("Use Heal");
        ui.combatChoice4.setText("Run");

        game.nextPosition1 = "playerAttackCarthar";
        game.nextPosition2 = "";
        game.nextPosition3 = "useHealingItem";
        game.nextPosition4 = "attemptToEscape";
    }

    public void attemptToEscape() {
        ui.combatTextArea.setText(
                "You attempt to flee, but the Pyrelord's flames block your path. There is no escape.\n\nWhat do you do?");

        ui.combatChoice1.setText("Fight Carthar");
        ui.combatChoice2.setText("");
        ui.combatChoice3.setText("");
        ui.combatChoice4.setText("");

        game.nextPosition1 = "fightCarthar";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void playerAttackCarthar() {
        int playerDamage = new java.util.Random().nextInt(player.currentWeapon.damage) + 1;

        carthar.hp -= playerDamage;
        ui.combatTextArea.setText("(You attacked the Carthar and dealt " + playerDamage + " damage!)\n");

        ui.combatChoice1.setText(">");
        ui.combatChoice2.setText("");
        ui.combatChoice3.setText("");
        ui.combatChoice4.setText("");

        ui.enemyHpLabelNum.setText("" + carthar.hp);

        if (carthar.hp > carthar.phaseThreshold) {
            game.nextPosition1 = "cartharAttack";
        } else if (carthar.hp <= carthar.phaseThreshold && !carthar.inPhaseTwo) {
            game.nextPosition1 = "enterSecondPhase";
        } else if (carthar.hp <= 0) {
            game.nextPosition1 = "winCarthar";
        } else {
            game.nextPosition1 = "cartharAttack";
        }
    }

    public void cartharAttack() {
        int cartharDamage;
        int effectiveDamage;
        int attackType = new java.util.Random().nextInt(3); // Randomly choose attack type (0, 1, or 2)

        switch (attackType) {
            case 0: // Normal attack
                cartharDamage = new java.util.Random().nextInt(carthar.attack) + 1;
                effectiveDamage = Math.max(cartharDamage - player.def, 0);
                player.hp -= effectiveDamage;
                ui.combatTextArea.setText("Carthar attacks with a fiery strike!\n"
                        + "(You take " + effectiveDamage + " damage!)\n");
                game.nextPosition1 = "fightCarthar";// Allow player's turn
                break;
            case 1: // Stun attack
                cartharDamage = new java.util.Random().nextInt(carthar.attack) + 1;
                effectiveDamage = Math.max(cartharDamage - player.def, 0);
                player.hp -= effectiveDamage;
                boolean isStunned = new java.util.Random().nextInt(100) < 20; // 20% chance to stun
                if (isStunned) {
                    ui.combatTextArea.setText("Carthar attacks with a stunning strike!\n"
                            + "(You take " + effectiveDamage + " damage and are stunned!)\n");
                    game.nextPosition1 = "cartharAttack"; // Skip player's turn
                } else {
                    ui.combatTextArea.setText("Carthar attacks with a stunning strike!\n"
                            + "(You take " + effectiveDamage + " damage!)\n");
                    game.nextPosition1 = "fightCarthar"; // Allow player's turn
                }
                break;
            case 2: // Sacrifice HP for extra attack
                cartharDamage = new java.util.Random().nextInt(carthar.attack) + 1;
                effectiveDamage = Math.max(cartharDamage - player.def, 0);
                player.hp -= effectiveDamage;
                carthar.hp -= 5; // Sacrifice 5 HP for an extra attack
                ui.combatTextArea.setText("Carthar sacrifices some HP for an extra attack!\n"
                        + "(You take " + effectiveDamage + " damage!)\n"
                        + "Carthar sacrifices 5 HP.\n");
                game.nextPosition1 = "cartharAttack"; // Skip player's turn
                break;
        }

        ui.combatHpLabelNum.setText("" + player.hp);

        ui.combatChoice1.setText(">");
        ui.combatChoice2.setText("");
        ui.combatChoice3.setText("");
        ui.combatChoice4.setText("");

        if (player.hp > 0 && game.nextPosition1 != "cartharAttack") {
            game.nextPosition1 = "fightCarthar";
        } else if (player.hp <= 0) {
            game.nextPosition1 = "lose";
        }
    }

    // Second Phase
    public void enterSecondPhase() {
        carthar.inPhaseTwo = true; // Set the flag to true when entering the second phase
        playerPlatform = 1; // Set the player to start on Platform 1
        isChargingAttack = false; // Reset the charging state
        chargeCounter = 0; // Reset the charge counter
        ui.combatTextArea.setText(
                "Carthar slams his molten blade into the ground, and the entire arena trembles violently. Streams of lava burst forth, "
                        +
                        "forming three unstable platforms above the churning fire below. His ash-encrusted form erupts into a towering inferno, "
                        +
                        "his hollow eyes now blazing with fury.\n\n" +
                        "Carthar roars: \n" +
                        "\"*Witness my rebirth in fire and despair! None shall escape the King of Ash!*\"\n\n" +
                        "You leap onto Platform " + playerPlatform + " as the heat rises, your resolve tested anew.\n\n"
                        + "What do you do?");

        ui.resetScrollPosition();

        ui.combatChoice1.setText(">");
        ui.combatChoice2.setText("");
        ui.combatChoice3.setText("");
        ui.combatChoice4.setText("");

        game.nextPosition1 = "fightCartharPhaseTwo";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    // Add method of fightPyrelordPhaseTwo
    public void fightCartharPhaseTwo() {
        currentArea = "fightCartharPhaseTwo";
        ui.combatTextArea.setText(
                // fix this dialogue
                "The platforms groan and shift beneath your feet, barely holding against the searing heat. Carthar glares at you from across the molten chasm, "
                        +
                        "his fiery blade raised high as embers swirl around him.\n\n" +
                        "Carthar sneers: \n" +
                        "\"*You persist? You fight against the inevitable? The Pyre consumes all, and so shall you!*\"\n\n"
                        +
                        "You steady yourself on Platform " + playerPlatform + ", preparing for your next move.\n\n"
                        + "What do you do?");

        ui.resetScrollPosition();

        ui.combatChoice1.setText("Attack");
        ui.combatChoice2.setText("Jump");
        ui.combatChoice3.setText("");
        ui.combatChoice4.setText("");

        game.nextPosition1 = "playerAttackCartharPhaseTwo";
        game.nextPosition2 = "choosePlatform";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void playerAttackCartharPhaseTwo() {
        int playerDamage = new java.util.Random().nextInt(player.currentWeapon.damage) + 1;

        carthar.hp -= playerDamage;
        ui.combatTextArea.setText("(You attacked Carthar and dealt " + playerDamage + " damage!)\n");

        ui.combatChoice1.setText(">");
        ui.combatChoice2.setText("");
        ui.combatChoice3.setText("");
        ui.combatChoice4.setText("");

        ui.enemyHpLabelNum.setText("" + carthar.hp);

        if (carthar.hp > 0) {
            game.nextPosition1 = "cartharAttackPhaseTwo";
        } else {
            game.nextPosition1 = "winCarthar";
        }
    }

    public void cartharAttackPhaseTwo() {
        int cartharDamage;
        int effectiveDamage;
        int cartharLifeSteal;
        int attackType = new java.util.Random().nextInt(3); // Randomly choose attack type (0, 1, or 2)

        if (isChargingAttack) {
            chargeCounter++;
            if (chargeCounter >= 2) { // Unleash the charged attack after 2 turns
                cartharDamage = new java.util.Random().nextInt(carthar.attack * 2) + 1; // Double the attack power
                effectiveDamage = Math.max(cartharDamage - player.def, 0);
                player.hp -= effectiveDamage;
                ui.combatTextArea.setText("Carthar unleashes its charged attack!\n"
                        + "(You take " + effectiveDamage + " damage!)\n");
                isChargingAttack = false; // Reset the charging state
                chargeCounter = 0; // Reset the charge counter
            } else {
                ui.combatTextArea.setText("Carthar is still charging its attack.\n"
                        + "It will unleash a powerful attack in " + (2 - chargeCounter) + " turns.");
            }
        } else if (corruptedPlatform != 0) {
            corruptionCounter++;
            if (corruptionCounter >= 3) { // Revert the platform back to normal after 3 turns
                ui.combatTextArea.setText("The corruption on Platform " + corruptedPlatform + " fades away.\n");
                corruptedPlatform = 0; // Reset the corrupted platform
                corruptionCounter = 0; // Reset the corruption counter
            } else if (playerPlatform == corruptedPlatform) {
                int corruptionDamage = new java.util.Random().nextInt(5) + 1; // Deal damage over time
                player.hp -= corruptionDamage;
                ui.combatTextArea.setText("You are standing on a corrupted platform!\n"
                        + "(You take " + corruptionDamage + " damage from the corruption!)\n");
            }
        } else {
            switch (attackType) {
                case 0: // Soul Drain
                    cartharLifeSteal = new java.util.Random().nextInt(10) + 1; // Steal a small amount of HP
                    player.hp -= cartharLifeSteal; // Steal HP from the player
                    carthar.hp += cartharLifeSteal; // Heal the boss with the stolen HP
                    ui.combatTextArea.setText("Carthar uses Soul Drain!\n"
                            + "(You lose " + cartharLifeSteal + " HP and Carthar heals for " + cartharLifeSteal
                            + " HP!)\n");
                    break;
                case 1: // Attack Amplifier
                    isChargingAttack = true; // Set the charging state
                    chargeCounter = 0; // Reset the charge counter
                    ui.combatTextArea.setText("Carthar uses Attack Amplifier! Carthar is charging its attack.\n"
                            + "It will unleash a powerful attack in a few turns.");
                    break;
                case 2: // Corrupted Zone
                    corruptedPlatform = new java.util.Random().nextInt(3) + 1; // Randomly choose a platform to corrupt
                    corruptionCounter = 0; // Reset the corruption counter
                    ui.combatTextArea.setText(
                            "Carthar uses Corrupted Zone! Platform " + corruptedPlatform + " is now corrupted.\n"
                                    + "Standing on it will deal damage over time.");
                    break;
            }
        }

        ui.combatHpLabelNum.setText("" + player.hp);

        ui.combatChoice1.setText(">");
        ui.combatChoice2.setText("");
        ui.combatChoice3.setText("");
        ui.combatChoice4.setText("");

        if (player.hp > 0) {
            game.nextPosition1 = "fightCartharPhaseTwo";
        } else {
            game.nextPosition1 = "lose";
        }
    }

    public void choosePlatform() {
        ui.mainTextArea.setText("Choose a platform to jump to:");

        ui.combatChoice1.setText("Platform 1");
        ui.combatChoice2.setText("Platform 2");
        ui.combatChoice3.setText("Platform 3");
        ui.combatChoice4.setText("Go back");

        game.nextPosition1 = "jumpToPlatform1";
        game.nextPosition2 = "jumpToPlatform2";
        game.nextPosition3 = "jumpToPlatform3";
        game.nextPosition4 = "fightCartharPhaseTwo";
    }

    public void jumpToPlatform1() {
        playerPlatform = 1; // Update player's current platform
        ui.combatTextArea.setText("You jumped to Platform 1");
        // End player's turn after jumping
        ui.combatChoice1.setText(">");
        ui.combatChoice2.setText("");
        ui.combatChoice3.setText("");
        ui.combatChoice4.setText("");

        game.nextPosition1 = "CartharAttackPhaseTwo";
    }

    public void jumpToPlatform2() {
        playerPlatform = 2; // Update player's current platform
        ui.combatTextArea.setText("You jumped to Platform 2.");
        // End player's turn after jumping
        ui.combatChoice1.setText(">");
        ui.combatChoice2.setText("");
        ui.combatChoice3.setText("");
        ui.combatChoice4.setText("");

        game.nextPosition1 = "CartharAttackPhaseTwo";
    }

    public void jumpToPlatform3() {
        playerPlatform = 3; // Update player's current platform
        ui.combatTextArea.setText("You jumped to Platform 3.");
        // End player's turn after jumping
        ui.combatChoice1.setText(">");
        ui.combatChoice2.setText("");
        ui.combatChoice3.setText("");
        ui.combatChoice4.setText("");

        game.nextPosition1 = "CartharAttackPhaseTwo";
    }

    public void winCarthar() {
        int scoreAwarded = carthar.getScoreValue();
        player.addScore(scoreAwarded);
        ui.mainTextArea.setText(
                "Carthar roars in defeat, its flames flickering and fading. The Pyrelord collapses to the ground, its fiery form dissipating into smoke and ash.\n\n"
                        +
                        "The chamber grows still, the oppressive heat lifting as the flames die down. You have emerged victorious, the Pyrelord vanquished.\n\n"
                        +
                        "(You obtained the Ember of the Pyrelord!)");

        ui.resetScrollPosition();

        player.inventory.add("Ember of the PyreLord");
        emberOfThePyrelord = true; // Set the flag to true when the item is obtained
        defeatedCarthar = true; // Set the flag to true when Carthar is defeated
        cindersouls = cindersouls + 1; // Gain 1 cindersoul for defeating Carthar

        ui.choice1.setText("Return to the bonfire");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "centralAshChamber";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";

        // Hide the combat UI
        ui.hideCombatUI();

        ui.hpLabelNum.setText("" + player.hp);
    }

    // Check if all bosses are defeated
    public boolean allBossesDefeated() {
        return defeatedEylis && defeatedVeyra && defeatedCarthar;
    }

    // Update the Pyre Chamber description after all bosses are defeated
    public void pyreChamberAfterBosses() {
        currentArea = "pyreChamberAfterBosses"; // Update current area
        ui.mainTextArea.setText(
                "Before you could choose the place to teleport to, you are suddenly teleported back to The Pyre Chamber.\n\n"
                        +
                        "However, The Pyre Chamber feels different. The flickering flame of the Pyre of Eternity burns brighter, its embers casting long, wavering shadows.\n"
                        +
                        "The air is heavy with the weight of your triumphs, but also with the burden of choice.\n\n" +
                        "The Firekeeper stands silently before the Pyre, her gaze fixed on you.\n\n" +
                        "What will you do?");

        ui.resetScrollPosition();

        ui.choice1.setText("Talk to Firekeeper");
        ui.choice2.setText("Rest at Bonfire");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "talkToFirekeeperAfterBosses";
        game.nextPosition2 = "restAtBonfire";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    // Interaction with the Firekeeper after all bosses are defeated
    public void talkToFirekeeperAfterBosses() {
        ui.mainTextArea.setText(
                "The Firekeeper turns to face you, her calm, unwavering gaze meeting yours.\n\n" +
                        "\"Ashen one, you have retrieved the Cindersouls of the fallen Pyrelords. Their flames now reside with you, "
                        +
                        "and the fate of this world lies in your hands.\"\n\n" +
                        "Her voice softens, as though carrying the weight of countless ages:\n" +
                        "\"Will you rekindle the flame and prolong this Age of Fire, or shall we let it fade into darkness? The choice is yours, as it has always been.\"\n\n"
                        +
                        "The Pyre flickers faintly in the distance, awaiting your decision.");

        ui.choice1.setText("Give Cindersouls");
        ui.choice2.setText("Leave");
        ui.choice3.setText("");
        ui.choice4.setText("");

        if (fireKeepersEyes) {
            ui.choice3.setText("Give Firekeeper's Eyes");
            game.nextPosition3 = "endFireEnding"; // End of Fire ending
        }

        game.nextPosition1 = "normalEnding"; // To link the flame
        game.nextPosition2 = "pyreChamberAfterBosses"; // Stay in the chamber
        game.nextPosition4 = "";
    }

    // Normal Ending: Link the Flame
    public void normalEnding() {
        ui.mainTextArea.setText(
                "The Firekeeper gently takes the Cindersouls from your hands. She steps aside, her calm gaze resting on you:\n\n"
                        +
                        "\"Chosen Undying, the Pyre is whole once more. Now, it falls to you to rekindle the flame and preserve the Age of Flame.\"\n\n"
                        +
                        "You approach the Pyre of Eternity and place the Cindersouls within its flickering embers. The flame roars to life, engulfing you.\n"
                        +
                        "The world is rekindled, and the Age of Flame continues, but at the cost of your own soul.\n\n"
                        +
                        "<THE END>\n\n(Ending 1: To Link the Flame)");

        ui.resetScrollPosition();

        endGame();

        ui.choice1.setText("Back to title screen");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "toTitle";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    // End of Fire Ending
    public void endFireEnding() {
        ui.mainTextArea.setText(
                "The Firekeeper gently takes the Cindersouls and the Firekeeper's Eyes from your hands. She steps toward the Pyre, her voice soft and calm:\n\n"
                        +
                        "\"Ashen one, this is your wish? To see the fire fade, and embrace the dark? So be it.\"\n\n" +
                        "The flame flickers weakly as the Firekeeper chants in an ancient tongue. Slowly, the Pyre dims, and the chamber is bathed in shadows. "
                        +
                        "The world beyond begins to fade, its light surrendering to an endless night.\n\n" +
                        "As the last embers die, the Firekeeper turns to you, her voice now a whisper:\n" +
                        "\"May the dark bestow peace.\"\n\n" +
                        "The chamber grows cold, and silence reigns as the Age of Fire comes to an end. In the distance, faint stars begin to awaken in the abyss of night.\n\n"
                        +
                        "<THE END>\n\n(Ending 2: End of Fire)");

        ui.resetScrollPosition();

        endGame();

        ui.choice1.setText("Back to title screen");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "toTitle";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void playerDies() {
        ui.mainTextArea.setText("You have been defeated. The game is over.");
        ui.hideAllImagePanels();
        // Additional code to handle game over...
    }

    // Shared Endgame Method
    public void endGame() {
        ui.choice1.setVisible(false);
        ui.choice2.setVisible(false);
        ui.choice3.setVisible(false);
        ui.choice4.setVisible(false);
        ui.hideAllImagePanels();
        ui.mainTextArea.append("\n\nThank you for playing!");
    }

    // public void east(){
    // ui.mainTextArea.setText("You walked into a forest and found a Long sword!.
    // \n\n(You obtained a Long Sword)");

    // player.currentWeapon = new WeaponLongSword();
    // ui.weaponLabelName.setText(player.currentWeapon.name);

    // ui.choice1.setText("go back");
    // ui.choice2.setText("");
    // ui.choice3.setText("");
    // ui.choice4.setText("");

    // game.nextPosition1 = "crossRoad";
    // game.nextPosition2 = "";
    // game.nextPosition3 = "";
    // game.nextPosition4 = "";
    // }

    // public void west(){

    // //Random Encounter
    // int i = new java.util.Random().nextInt(100)+1;

    // if (i<90){
    // monster = new Goblin();
    // }else{
    // monster = new Bear();
    // }

    // //monster = new Goblin();

    // ui.mainTextArea.setText("You encounter a " + monster.name + "! \n\nWhat do
    // you do?");

    // ui.choice1.setText("Fight");
    // ui.choice2.setText("Run");
    // ui.choice3.setText("");
    // ui.choice4.setText("");

    // game.nextPosition1 = "fight";
    // game.nextPosition2 = "crossRoad";
    // game.nextPosition3 = "";
    // game.nextPosition4 = "";
    // }

    // public void fight(){

    // ui.mainTextArea.setText(monster.name + ": " + monster.hp + "\n\nWhat do you
    // do?");

    // ui.choice1.setText("Attack");
    // ui.choice2.setText("Run");
    // ui.choice3.setText("");
    // ui.choice4.setText("");

    // game.nextPosition1 = "playerAttack";
    // game.nextPosition2 = "crossRoad";
    // game.nextPosition3 = "";
    // game.nextPosition4 = "";
    // }

    // public void playerAttack(){

    // int playerDamage = new
    // java.util.Random().nextInt(player.currentWeapon.damage);

    // ui.mainTextArea.setText("(You attacked the " + monster.name + " and gave " +
    // playerDamage + " damage!)");

    // monster.hp = monster.hp - playerDamage;

    // ui.choice1.setText(">");
    // ui.choice2.setText("");
    // ui.choice3.setText("");
    // ui.choice4.setText("");

    // if(monster.hp > 0){
    // game.nextPosition1 = "monsterAttack";
    // game.nextPosition2 = "";
    // game.nextPosition3 = "";
    // game.nextPosition4 = "";
    // }
    // else if(monster.hp == 0 || monster.hp < 0){
    // game.nextPosition1 = "win";
    // game.nextPosition2 = "";
    // game.nextPosition3 = "";
    // game.nextPosition4 = "";
    // }

    // }

    // public void monsterAttack(){
    // int monsterDamage = new java.util.Random().nextInt(monster.attack);
    // int effectiveDamage = Math.max(monsterDamage - player.def, 0); // Reduce
    // damage by player's defense

    // ui.mainTextArea.setText(monster.attackMessage + "\n(The " + monster.name + "
    // attacked you and gave " + monsterDamage + " damage!)");

    // player.hp = player.hp - effectiveDamage;
    // ui.hpLabelNum.setText("" + player.hp);

    // ui.choice1.setText(">");
    // ui.choice2.setText("");
    // ui.choice3.setText("");
    // ui.choice4.setText("");

    // if(player.hp > 0){
    // game.nextPosition1 = "fight";
    // game.nextPosition2 = "";
    // game.nextPosition3 = "";
    // game.nextPosition4 = "";
    // }
    // else if(player.hp == 0 || player.hp < 0){
    // game.nextPosition1 = "lose";
    // game.nextPosition2 = "";
    // game.nextPosition3 = "";
    // game.nextPosition4 = "";
    // }

    // }

    public void lose() {
        ui.hideCombatUI();
        ui.hpLabelNum.setText("0");

        ui.mainTextArea.setText("You are dead. \n\n<GAME OVER>");

        ui.choice1.setText("Back to title screen");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "toTitle";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";

    }

    public void toTitle() {

        defaultSetup();
        vm.showTitleScreen();

    }

    public void continueFight() {
        if (currentArea.equals("ruinedPathArea")) {
            game.nextPosition1 = "fightInRuinedPath";
        } else if (currentArea.equals("fightVeyra")) {
            game.nextPosition1 = "fightVeyra";
        } else if (currentArea.equals("fightEylis")) {
            game.nextPosition1 = "fightEylis";
        } else if (currentArea.equals("fightGuardian")) {
            game.nextPosition1 = "fightGuardian";
        } else if (currentArea.equals("fightVeyraWithKaelor")) {
            game.nextPosition1 = "fightVeyraWithKaelor";
        } else if (currentArea.equals("fightVeyraAlone")) {
            game.nextPosition1 = "fightVeyraAlone";
        } else if (currentArea.equals("fightCarthar")) {
            game.nextPosition1 = "fightCarthar";
        } else if (currentArea.equals("fightCartharPhaseTwo")) {
            game.nextPosition1 = "fightCartharPhaseTwo";
        } else {
            // Default to a generic fight position if no specific area is matched
            game.nextPosition1 = "fight";
        }
    }

    public void useHealingItem() {
        if (player.healingItems > 0) {
            int healAmount = (int) (player.maxHp * 0.5);
            player.hp = Math.min(player.hp + healAmount, player.maxHp);
            player.healingItems--;

            ui.combatTextArea.setText("You used a Healing Potion and restored " + healAmount + " HP!\n" +
                    "You have " + player.healingItems + " healing items left.");
            ui.combatHpLabelNum.setText("" + player.hp);

            ui.combatChoice1.setText(">");
            ui.combatChoice2.setText("");
            ui.combatChoice3.setText("");
            ui.combatChoice4.setText("");

            continueFight(); // Call the generic method to continue the fight
        } else {
            ui.combatTextArea.setText("You have no healing items!");

            ui.combatChoice1.setText(">");
            ui.combatChoice2.setText("");
            ui.combatChoice3.setText("");
            ui.combatChoice4.setText("");

            continueFight(); // Call the generic method to continue the fight
        }
    }

    public void findRandomLoot() {
        Random random = new Random();
        int chance = random.nextInt(100); // Generate a random number between 0 and 99

        if (chance < 50) { // 50% chance to find a healing item
            player.healingItems = Math.min(player.healingItems + 1, Player.MAX_HEALING_ITEMS);
            ui.mainTextArea
                    .append("\n\nYou found a Healing Potion! You now have " + player.healingItems + " healing items.");
        } else {
            ui.mainTextArea.append("\n\nYou found nothing of value.");

        }
    }

    public void checkGameOver() {
        System.out.println("checkGameOver() called. Player HP: " + player.hp);
        if (player.hp <= 0) {
            System.out.println("Player HP is 0. Game Over!");
            game.endGame();
        }
    }
}
