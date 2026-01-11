package Bosses;

public class Veyra {
    public String name;
    public int hp;
    public int attack;
    public int phaseThreshold;
    public boolean inPhaseTwo;

    // Dialogues
    public String phaseTwoDialogue;
    public String defeatDialogue;
    
    //Add scoreValue for bosses
    private int scoreValue;
    
    public int getScoreValue() {
        return scoreValue; //getter for score value
    }   
    

    public Veyra() {
        this.name = "Veyra";
        this.hp = 40; // Initial HP
        this.attack = 10; // Initial attack power
        this.phaseThreshold = 15; // HP threshold for phase transition
        this.inPhaseTwo = false; // Initial phase

        // Add dialogues
        this.phaseTwoDialogue = "Feel the wrath of the flames that consumed my prey! Your ashes will join theirs!";
        this.defeatDialogue = "No... I was the hunter... How could I fall to the likes of you? Burn this memory... into eternity...";
        
         //Assign score value for defeating this boss
        this.scoreValue = 750;  //award points for bosses    
    }
}
