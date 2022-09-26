package com.Jonathan;

import java.util.concurrent.ThreadLocalRandom;

final public class Monster extends Character
{
    private final int attack;

    public Monster(String name)
    {
        super(name);
        attack = ThreadLocalRandom.current().nextInt(8, 15 + 1);
    }

    public int getAttack()
    {
        return attack;
    }

    public void fight(Character c, Human h)
    {

        h.setHealth(-1* ((Monster)c).getAttack());

        Human.printMsg("You've been hit by the Monster! "+ "-" + ((Monster)c).getAttack() + "HP!" ,10);
        if (this.getHealth() < 50)
        {
            Human.printMsg("You now have "  + h.getHealth()  + "HP[LOW HEALTH]",10);
        }
        else if (this.getHealth() > 100)
        {
            Human.printMsg("You now have "  + h.getHealth()  + "HP"+ "[OVERCHARGED]" ,10);
        }
        else
        {
            Human.printMsg("You now have "  + h.getHealth()  + "HP",10);
        }

        Human.printMsg("----------------",1);
    }

    public void incomingDamage(int val)
    {
        super.setHealth(-1 * val);
    }

    //Get info based on whether Monster is dead. (Useful when displaying town info)
    public String getInfo()
    {
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_GREEN = "\u001B[32m";
        final String BLACK_BACKGROUND = "\033[40m";
        final String ANSI_RESET = "\u001B[0m";

        if (this.deathStatus())
        {
            return "\nThere is a " + BLACK_BACKGROUND + "Monster "  + getName() + ANSI_RESET +" with " + getHealth() + "HP " + ANSI_RED + "[DEAD]" + ANSI_RESET;
        }
        else
        {
            return "\nThere is a " + BLACK_BACKGROUND + "Monster "  + getName() + ANSI_RESET + " with " + getHealth() + "HP " + ANSI_GREEN + "[ALIVE]" + ANSI_RESET;
        }
    }
}
