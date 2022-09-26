package com.Jonathan;
import java.util.concurrent.ThreadLocalRandom;

final public class Warrior extends Character
{
    private final int spirit; //extra strength that a Warrior can possess
    private final int attack;

    public Warrior(String name)
    {
        super(name);

        this.spirit = ThreadLocalRandom.current().nextInt(25, 51 + 1);
        setHealth(spirit);
        this.attack = ThreadLocalRandom.current().nextInt(25, 35 + 1);
    }

    public void fight(Character c, Human h)
    {

        h.setHealth(-1 * ((Warrior) c).getAttack());

        Human.printMsg("You've been hit by the Warrior!"  + " -" + ((Warrior)c).getAttack() + "HP!"  ,10);

        if (this.getHealth() < 50)
        {
            Human.printMsg("You now have " + h.getHealth()  + "HP[LOW HEALTH]",10);
        }
        else if (this.getHealth() > 100)
        {
            Human.printMsg("You now have " + h.getHealth()  + "HP"+ "[OVERCHARGED]" ,10);
        }
        else
        {
            Human.printMsg("You now have " + h.getHealth()  + "HP",10);
        }

        Human.printMsg("----------------",1);
    }

    public void incomingDamage(int val)
    {
        super.setHealth(-1 * val);
    }

    public int getAttack()
    {
        return attack;
    }

    //Get info based on whether Warrior is dead. (Useful when displaying town info)
    @Override
    public String getInfo()
    {
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_GREEN = "\u001B[32m";
        final String YELLOW_UNDERLINED = "\033[4;33m";
        final String ANSI_RESET = "\u001B[0m";

        if (this.deathStatus())
        {
            return "\nThere is a " + YELLOW_UNDERLINED + "Warrior "  + getName() + ANSI_RESET + " with " + getHealth() + "HP " + ANSI_RED + "[DEAD]" + ANSI_RESET;
        }
        else
        {
            return "\nThere is a " + YELLOW_UNDERLINED + "Warrior "  + getName() + ANSI_RESET + " with " + getHealth() + "HP " + ANSI_GREEN + "[ALIVE]" + ANSI_RESET;
        }
    }

}
