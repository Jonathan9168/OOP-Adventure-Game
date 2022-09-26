package com.Jonathan;

import java.util.concurrent.ThreadLocalRandom;

final public class Potion
{
    private final int healing; //Healing instance variable which will affect Human's Health/Attack Stat
    private int cap = 0; //Instance variable to keep track of interaction count between human and potion

    //random generated value that a potion can hold
    public Potion()
    {
       this.healing = ThreadLocalRandom.current().nextInt(-30, 35 + 1);
    }

    public boolean isReached()
    {
        return cap == 2;
    } //check if potion has be interacted with the maximum amount of times

    //getters and setters
    public String getInfo()
    {
        return "\nA potion with a health boost of up to 35 health is present." + " [" + (2-getCap()) + " (POTION/POTIONS) LEFT]" ;
    }

    public int getHealing()
    {
        return healing;
    }

    public void setCap()
    {
        cap++;
    }

    public int getCap()
    {
        return cap;
    }
}
