package com.Jonathan;

final public class Weapon
{
    private final String name;
    private final int boost; //additional boost attribute that increases Human's attack stat when equipped
    private int cap = 0; //Tracks interaction between Human and weapon in a given town

    public Weapon(String name,int boost)
    {
      this.name = name;
      this.boost = boost;
    }

    //Gives human boost if allowed and returns message
    public String giveBoost(Human h)
    {
        final String ANSI_YELLOW = "\u001B[33m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_RESET = "\u001B[0m";

        if (isReached())
        {
            return  ANSI_RED + "\nYou can only equip a weapon once!" + ANSI_RESET;
        }
        else
            {
            h.setAttack(boost);
            cap++;
            return "\nYou equipped (an/a) " + ANSI_YELLOW + getName() + ANSI_RESET + " this has boosted your attack by " + ANSI_YELLOW + getBoost() + ANSI_RESET + " DMG.";
        }
    }

    //checks if weapon has reached equip limit
    public boolean isReached()
    {
        return cap == 1;
    }

    //getters for relevant weapon info
    public String getInfo()
    {
        if (!isReached())
        {
            return "\n" + "There's a weapon present. Pick it up to find out more..." + " [" + (1-getCap()) + " (EQUIP/EQUIPS) LEFT]";
        }
        else
        {
            return "\nNO MORE WEAPONS PRESENT." + " [" + (0) + " (EQUIP/EQUIPS) LEFT]";
        }
    }

    public int getCap()
    {
        return cap;
    }

    public String getName()
    {
        return name;
    }

    public int getBoost()
    {
        return boost;
    }
}