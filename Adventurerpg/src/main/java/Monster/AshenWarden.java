package Monster;

public class AshenWarden extends Monsters{
    
    public AshenWarden(){
        
        name = "Ashen Warden";
        hp = 20;
        attack = 15;
        attackMessage = "The Ashen Warden hit you with its fiery sword!";
        scoreValue = 250;  //set score value for defeating this monster
        // Insert ashenwarden.png into the combatenemyimagepanel
        // UI.CombatEnemyImagePanel = new ImageIcon "Adventurerpg/res/ashenwarden.png.";
        
    }

}
