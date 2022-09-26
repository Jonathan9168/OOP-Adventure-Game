package com.Jonathan;

public class Magician extends Character
{
    private final int charm; //charm attribute which can hinder health or increase health

    //Added charm instance variable so magicians can affect Human's Health
    public Magician(String name,int charm)
    {
        super(name);
        this.charm = charm;
    }

    //Apply charm to human
    public String giveCharm(Human h,Town t)
    {
        setHealth(charm);
        return charm + "CHARM given";
    }

    //getters for fields
    public int getCharm()
{
    return charm;
}

    //method overridden from superclass giving more specific info
    public String getInfo(Town t)
    {
        if (t.getCap() < 2)
        {
            return "\nThere is a Magician " + super.getName() + " present... He could be good or bad. You'll have to risk it for a biscuit!" + " [" + (2-t.getCap()) + " (TRIES/TRY) LEFT]";
        }
        else
        {
            return "\nNO MORE MAGICIANS SPAWNING HERE."  + " [" + (2-t.getCap()) + " (TRIES/TRY) LEFT]";
        }
    }
}
