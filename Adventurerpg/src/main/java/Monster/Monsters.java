
package Monster;



public class Monsters {
    
    public String name;
    public int hp;
    public int attack;
    public String attackMessage;
    public int scoreValue; //add score value field
    
    // Getters for common monster properties
    public String getName() {
        return name;
    }
    
    public int getHp() {
        return hp;
    }
    
    public int getAttack() {
        return attack;
    }
    
    public String getAttackMessage() {
        return attackMessage;
    }
    
    public int getScoreValue() {
        return scoreValue; //getter for score value
    }
    
    //Method to apply damage to the monster
    public void takeDamage(int damage) {
        hp -= damage;
        if (hp < 0) {
            hp = 0;
        }
    }
    
    //check if the monster is defeated
    public boolean isDefeated() {
        return hp <= 0;
    }
}


