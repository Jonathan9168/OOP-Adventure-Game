package com.Jonathan;

abstract public class Character
{
    private final String name;
    private int health; //general health stat for all characters

    public Character(String name)
    {
        this.name = name;
        this.health = 100;
    }

    public void fight(Character c, Human h)
    {
        c.incomingDamage(h.getAttack());

        if (c instanceof Warrior)
        {
            h.incomingDamage(((Warrior) c).getAttack());
        }
        else if (c instanceof Monster)
        {
            h.incomingDamage(((Monster) c).getAttack());
        }
    }
    //setters and getters for help
    public void setHealth(int val)
    {
        this.health += val;
    }

    public int getHealth()
    {
        return this.health;
    }

    public void incomingDamage(int val)
    {
        this.health -= val;
    }

    public String getName() {
        return name;
    }

    public boolean deathStatus()
    {
        return this.health <= 0;
    }

    //unrefined getInfo. General info but no depth
    public String getInfo()
    {
        if (this.deathStatus())
        {
            return "\nThis Is " + this.name + ". This character has " + this.health + "HP [DEAD]";
        }
        else
        {
            return "\nThis Is " + this.name + "This character has " + this.health + "HP ";
        }
    }
}
