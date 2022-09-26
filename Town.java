package com.Jonathan;

import java.util.Random;

/*Town Class which can hold different objects. A town can contain A type of Magician, Character (Enemy), Weapon and Potion*/
final public class Town
{
    private final String name;
    private Magician magician;
    private final Character fighter;
    private final Weapon weapon;
    private final Potion potion;
    private int magCap;

    //Array of names randomly chosen for characters
    String[] magNames = {"Oogway","Landrover","Falqway","Tyron","Landin","Masdack"};
    String[] warNames = {"Erq","Ragnarock","Buntu","Desdrick","Jonsa", "Kulum"};
    int rnd1 = new Random().nextInt(warNames.length);
    int rnd2 = new Random().nextInt(magNames.length);

    //Town constructor for creating town with fixed weapons
    public Town(String name)
    {
        this.name = name;
        this.fighter = Math.random() > 0.55 ? new Warrior(warNames[rnd1]):new Monster(warNames[rnd1]); //Character fighter = new Warrior Or new Monster (Substitution Principle).Type of object is based on probability.
        this.magician = Math.random() > 0.5 ? new GoodMagician(magNames[rnd2]):new BadMagician(magNames[rnd2]); //Magician magician = new GoodMagician or new BadMagician (Substitution Principle).Type of object is based on probability.
        this.weapon = Math.random() > 0.55 ? new Weapon("Axe",20):new Weapon("Rock",5);
        this.potion = new Potion();
    }

    //Overloaded Town Constructor which allows for creation of custom weapons
    public Town(String name,Weapon customWeapon)
    {
        this.name = name;
        this.fighter = Math.random() > 0.33 ? new Warrior(warNames[rnd1]):new Monster(warNames[rnd1]); //Character fighter = new Warrior Or new Monster (Substitution Principle).Type of object is based on probability.
        this.magician = Math.random() > 0.5 ? new GoodMagician(magNames[rnd2]):new BadMagician(magNames[rnd2]); //Substitution Principle. Type of object is based on probability.
        this.weapon = Math.random() > 0.6 ? customWeapon :new Weapon("Spear",15);
        this.potion = new Potion();
    }

    public void generateMagician()
    {
        this.magician = Math.random() > 0.5 ? new GoodMagician(magNames[rnd2]):new BadMagician(magNames[rnd2]);
    }

    public void setCap()
    {
        magCap++;
    }

    public int getCap()
    {
        return magCap;
    }

    //Town Information Retrieval
    public String getInfo(Town t)
    {
        final String ANSI_CYAN = "\u001B[36m";
        final String ANSI_RESET = "\u001B[0m";

        return "Town ---> |" + ANSI_CYAN + t.name + ANSI_RESET + "|" + fighterInfo(fighter) + magician.getInfo(t) + weapon.getInfo() + potion.getInfo(); //Dynamic Binding for Magician. Overridden method getInfo is resolved at runtime depending on what type of magician is created.
    }

    //Grabbing information of fighter present depending on Its type
    public String fighterInfo(Character c)
    {
        String info = "";

        /*Dynamic Binding present as the overridden method getInfo is resolved to be called at runtime depending on instance c holds*/

        info = (c).getInfo();

        return info;
    }

    //getters for respective objects a town can hold
    public Character getFighter()
    {
        return fighter;
    }

    public Magician getMagician()
    {
        return magician;
    }

    public Weapon getWeapon()
    {
        return weapon;
    }

    public Potion getPotion()
    {
        return potion;
    }

    public String getName()
    {
        return name;
    }
}

