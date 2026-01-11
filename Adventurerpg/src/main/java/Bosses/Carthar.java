package Bosses;

public class Carthar {
    
    public String name;
    public int hp;
    public int attack;
    public int phaseThreshold;
    public boolean inPhaseTwo;

    // New dialogues
    public String phaseTwoDialogue;
    public String defeatDialogue;

    //Add scoreValue for bosses
    private int scoreValue;
    
    public int getScoreValue() {
        return scoreValue; //getter for score value
    }   
    
    
    
    public Carthar() {
        this.name = "Carthar";
        this.hp = 40; // Initial HP
        this.attack = 5; // Initial attack power
        this.phaseThreshold = 20; // HP threshold for phase transition
        this.inPhaseTwo = false; // Initial phase

        // Add dialogues
        this.phaseTwoDialogue = "\"The flames hunger... and I shall feed them with your soul!\"\n" +
                        "\"Witness the Pyre's true wrath, forged in ash and agony. You cannot escape the fate that binds us all!\"";
        this.defeatDialogue = "The Pyre’s whispers... they promised eternity... yet here I fall. Another fool to the flame...\"\n" +
                        "\"...Perhaps you will fare no better...\" (his voice fades as his body crumbles to ash)";
        
       //Assign score value for defeating this boss
        this.scoreValue = 1000;  //award points for bosses 
        
    }
}
