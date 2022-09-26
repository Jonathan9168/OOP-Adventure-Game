package com.Jonathan;
import java.util.concurrent.ThreadLocalRandom;

final public class BadMagician extends Magician
{
    public BadMagician(String name)
    {
        super(name,ThreadLocalRandom.current().nextInt(1, 30 + 1) * -1);
    }

    //Apply charm to human and check interaction status
    public String giveCharm(Human h,Town t)
    {
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_RESET = "\u001B[0m";

        if (isReached(t))
        {
            return  ANSI_RED + "\nYou have reached the maximum amount of interactions [2] with the magician in this town! "+ ANSI_RESET;
        }
        else
        {
            h.setHealth(getCharm());
            t.setCap();
            return ANSI_RED+"\nUnfortunately for you, this was a Bad Magician with " + getCharm() + " CHARM." + getCharm() +"HP" + ANSI_RESET;
        }
    }

    //check if interaction cap has been reached
    public boolean isReached(Town t)
    {
        return t.getCap() == 2;
    }
}
