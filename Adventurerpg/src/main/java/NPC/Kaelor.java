package NPC;

import package02.WeaponAxe;

public class Kaelor {
    public String name;
    public int hp;
    public int atk;
    public int def;
    public WeaponAxe weapon;

    public Kaelor() {
        this.name = "Kaelor, the Broken Blade";
        this.hp = 30; // Initial HP
        this.atk = 10; // Initial attack power
        this.def = 5; // Initial defense
        this.weapon = new WeaponAxe(); // Assign a weapon to Kaelor
    }
}
