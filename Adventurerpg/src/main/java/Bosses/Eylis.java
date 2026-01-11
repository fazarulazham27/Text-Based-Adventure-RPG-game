package Bosses;

public class Eylis {
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
    

    public Eylis() {
        this.name = "Eylis";
        this.hp = 20; // Initial HP
        this.attack = 5; // Initial attack power
        this.phaseThreshold = 10; // HP threshold for phase transition
        this.inPhaseTwo = false; // Initial phase

        // Add dialogues
        this.phaseTwoDialogue = "You dare challenge the Keeper of Stars further? Witness the true fury of the cosmos!";
        this.defeatDialogue = "Even the stars fade... but their memory shall outlast you.";
        
        //Assign score value for defeating this boss
        this.scoreValue = 500;  //award points for bosses
    }
}
