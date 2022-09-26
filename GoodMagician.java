package com.Jonathan;
import java.util.concurrent.ThreadLocalRandom;

final public class GoodMagician extends Magician
{
    public GoodMagician(String name)
    {
        super(name,ThreadLocalRandom.current().nextInt(15, 40 + 1));
    }

    //Apply charm to human and check interaction status
    public String giveCharm(Human h,Town t)
    {
        final String ANSI_PURPLE = "\u001B[35m";
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_RED = "\u001B[31m";

        if (isReached(t))
        {
            return  ANSI_RED + "\nYou have reached the maximum amount of interactions [2] with the magician in this town! "+ ANSI_RESET;
        }
        else
        {
            h.setHealth(getCharm());
            t.setCap();
            return ANSI_PURPLE + "\nFortunately for you, this was a Good Magician with " + getCharm() + " CHARM."+ ANSI_RESET + ANSI_GREEN + " +" + getCharm() +"HP" +ANSI_RESET ;
        }
    }

    //check if interaction cap has been reached
    public boolean isReached(Town t)
    {
        return t.getCap() == 2;
    }
}
