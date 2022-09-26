package com.Jonathan;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

final public class Human extends Character
{
    private int attack;
    private int kills = 0;  //Tracks kills which can be used to determine if Human has won or lost.
    private int DMGTracker = 0; //Tracks overall how much damage a human has dealt.
    private final ArrayList<Weapon> Inventory = new ArrayList<>();

    public Human(String name)
    {
        super(name);
        this.attack = 10;
    }

    //Human action for drinking a potion item that has some healing attribute.
    public String drinkPotion(Potion p)
    {
       final String ANSI_RESET = "\u001B[0m";
       final String ANSI_RED = "\u001B[31m";
       final String ANSI_CYAN = "\u001B[36m";
       final String ANSI_GREEN = "\u001B[32m";

        if (p.getHealing() >= 0 && !p.isReached())
        {
            setHealth(p.getHealing());
            p.setCap();
            return "\nYou have consumed a potion that had " + ANSI_CYAN + p.getHealing() +ANSI_RESET + " healing attribute." +ANSI_GREEN + " +" + p.getHealing() +"HP" + ANSI_RESET;
        }
        else if (p.isReached())
        {
            return  ANSI_RED + "\nYou have reached the maximum consumption limit of 2 potions for this town! "+ ANSI_RESET;
        }
        else
        {
            setAttack(p.getHealing());
            p.setCap();
            return "\nYou have consumed a toxic potion that suppresses your attack! " + ANSI_RED + p.getHealing() +" ATTACK" + ANSI_RESET;
        }
    }

    public void fight(Character c,Human h)
    {
        commentary(c);
        trackDMG();

        /*Dynamic Binding for choosing what character will be fighting the Human. At runtime, depending on the character present in a town,
        when the Human selects the fight option, it will invoke the correct fight method so correct information is given for the commentary as well as stats.*/
        if (!c.deathStatus())
        {
            c.fight(c,h);
        }
    }

    //Initial commentary which says effect of Human attack on opponent
    public void commentary(Character c)
    {
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_GREEN = "\u001B[32m";

        c.incomingDamage(attack);

        printMsg("You dealt " + ANSI_RED + attack + "[DMG]" + ANSI_RESET,10);

        if (c.getHealth() < 50)
        {
            printMsg(c.getName() + " now has " + ANSI_RED + c.getHealth() + "HP[LOW HEALTH]"+ ANSI_RESET,10);
        }
        else
        {
            printMsg(c.getName() + " now has " + ANSI_GREEN + c.getHealth()  + "HP" + ANSI_RESET,10);
        }
    }

    //getters and setters for Human attributes
    public int getDMGTracker()
    {
        return DMGTracker;
    }

    public void trackDMG()
    {
        DMGTracker += attack;
    }

    public int pingHealth()
    {
        return super.getHealth();
    }

    public String getName()
    {
        return super.getName();
    }

    public int getAttack()
    {
        return attack;
    }

    public void setAttack(int val)
    {
        attack += val;
    }

    public void setKills()
    {
        kills++;
    }

    public void setInventory(Weapon w){Inventory.add(w);}

    public ArrayList<Weapon> getInventory(){return Inventory;}

    public int getKills()
    {
        return kills;
    }

    //printing to terminal every x milliseconds
    public static void printMsg(String text, int time)
    {
        for (char c : text.toCharArray())
        {
            System.out.print(c);
            cooldown(time);
        }
        System.out.println();
    }

    //short stoppage to simulate type writer effect
    public static void cooldown(int time)
    {
        try
        {
            TimeUnit.MILLISECONDS.sleep(time);
        }
        catch (InterruptedException e)
        {
            System.out.println("Error!");
        }
    }

}
