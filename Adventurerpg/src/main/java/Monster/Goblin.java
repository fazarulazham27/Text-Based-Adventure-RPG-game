/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Monster;

/**
 *
 * @author Fazarul Azham
 */
public class Goblin extends Monsters{
    
    public Goblin(){
        
        name = "Goblin";
        hp = 12;
        attack = 10;
        attackMessage = "The goblin hit you with its club!";
        scoreValue = 100; //set score value for defeating this monster
    }
    
}
