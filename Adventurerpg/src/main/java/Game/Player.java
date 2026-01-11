package Game;

import java.util.ArrayList;
import java.util.List;

import PlayerClass.Berserker;
import PlayerClass.Knight;
import PlayerClass.Sentinel;
import package02.Weapon;

public class Player {
    public String className;
    public int hp;
    public int maxHp;
    public int atk;
    public int def;
    public Weapon currentWeapon;
    public String name;
    public List<String> inventory;
    public int healingItems;
    public static final int MAX_HEALING_ITEMS = 3;
    public int score = 0; // track the player's score

    public Player() {
        inventory = new ArrayList<>();
        healingItems = MAX_HEALING_ITEMS;
        this.name = name;
        this.score = 0;
    }

    // method to add score
    public void addScore(int points) {
        score += points;
        System.out.println("Score added:" + points + ". Total score: " + score);
    }

    // method to get current score
    public int getScore() {
        return score;
    }

    public void setKnight() {
        Knight knight = new Knight();
        this.hp = knight.hp;
        this.maxHp = knight.hp;
        this.atk = knight.atk;
        this.def = knight.def;
        this.currentWeapon = knight.weapon;
    }

    public void setSentinel() {
        Sentinel sentinel = new Sentinel();
        this.hp = sentinel.hp;
        this.maxHp = sentinel.hp;
        this.atk = sentinel.atk;
        this.def = sentinel.def;
        this.currentWeapon = sentinel.weapon;
    }

    public void setBerserker() {
        Berserker berserker = new Berserker();
        this.hp = berserker.hp;
        this.maxHp = berserker.hp;
        this.atk = berserker.atk;
        this.def = berserker.def;
        this.currentWeapon = berserker.weapon;
    }
}
