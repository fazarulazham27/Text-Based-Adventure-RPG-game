/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Monster;

/**
 *
 * @author Fazarul Azham
 */
public class Bear extends Monsters{
    
    public Bear(){
        
        name = "Bear";
        hp = 800;
        attack = 6000;
        attackMessage = "The bear transform into the Ancient Rune Bear and attacked you";
        scoreValue = 1000; //set score value for defeating this monster
    }
    
}
