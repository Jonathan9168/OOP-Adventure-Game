package com.Jonathan;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Initialise
{
    public static void main(String[] args) throws IOException
    {
        startGame();
    }

    //Method that kicks off the game. Responsible for creating towns; creating Human; displaying game synopsis and displaying general town info.
    public static void startGame() throws IOException {
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_YELLOW = "\u001B[33m";

        /* Create towns */
        ArrayList<Town> towns = new ArrayList<>();
        towns.add(new Town("Bind",new Weapon("Bow And Arrow [RARE]",30)));
        towns.add(new Town("Trope"));
        towns.add(new Town("Azaar",new Weapon("Sword Of Lapel [VERY RARE]", 40)));
        towns.add(new Town("Fracture"));
        towns.add(new Town("Haven", new Weapon("Gerald's Photon [ULTRA RARE]", 55)));

        int EnemiesSpawned = towns.size();

        String name = inputString("Enter a player name: ");
        Human H = new Human(name);

        System.out.println("\nWelcome " + name + "!\n");
        loadSynopsis();

        while (!H.deathStatus())
        {
            System.out.println("\nNAME:" + ANSI_YELLOW + name + ANSI_RESET + "\nATTACK:" + ANSI_RED + H.getAttack() + "[DMG]" + ANSI_RESET + "\nHP:" + ANSI_GREEN + H.pingHealth() + "%" + ANSI_RESET + "\n");
            System.out.println("What Town Would You Like To Travel To?"+ "\n---------------------------");

            //Generalised town info retrieval. Helps ease adding/removing towns
            for (Town town : towns) {
                System.out.println(town.getInfo(town) + "\n---------------------------");
            }

            StringBuilder s = new StringBuilder();
            //Creating generalised option selection menu for towns. Helps ease adding/removing towns
            for (int i = 0; i<towns.size();i++) {
                int temp = i + 1;
                s.append("\n[").append(temp).append("] ").append(towns.get(i).getName());
            }

            int choice = inputInt(s.toString());

            if (choice < towns.size() + 1 && choice > 0) {
                printMsg("\nTravelling " + ANSI_YELLOW + "-----> " + ANSI_RESET + towns.get(choice - 1).getName(),100);
                enterTown(towns.get(choice - 1), H, EnemiesSpawned);
            } else {
                System.out.println("\nInvalid Town Entered!");
            }
        }
    }

    //Entry to town, allows user to pick action to do.
    public static void enterTown(Town T, Human H, int EnemiesSpawned)
    {
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_YELLOW = "\u001B[33m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_RESET = "\u001B[0m";

        System.out.println("\nYou're in " + T.getName());
        System.out.println("\nNAME:" + ANSI_YELLOW + H.getName() + ANSI_RESET + "\nATTACK:" + ANSI_RED + H.getAttack() + "[DMG]" + ANSI_RESET + "\nHP:" + ANSI_GREEN + H.pingHealth() + "%" + ANSI_RESET);

        String option = inputString("\n[A] Fight Enemy \n[B] Try Magician \n[C] Equip Weapon \n[D] Drink Potion \n[E] Leave Town \n[F] View Inventory \n[Q] Quit").toUpperCase();

        if ("A".equals(option)) {
            optionA(T, H, EnemiesSpawned);
        } else if ("B".equals(option)) {
            optionB(T, H, EnemiesSpawned);
        } else if ("C".equals(option)) {
            optionC(T, H, EnemiesSpawned);
        } else if ("D".equals(option)) {
            optionD(T, H, EnemiesSpawned);
        } else if ("E".equals(option)) {
        }
        else if ("F".equals(option)) {
            optionF(T, H, EnemiesSpawned);
        }
        else if ("Q".equals(option)) {
            System.exit(0);
        } else {
            System.out.println("\nInvalid Option Selected!");
            enterTown(T, H, EnemiesSpawned);
        }
    }

    // Fight an enemy
    public static void optionA(Town T, Human H, int EnemiesSpawned)
    {
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_RESET = "\u001B[0m";

        System.out.println();

        if (T.getFighter().deathStatus())
        {
            System.out.println(ANSI_RED + "\nYou've already killed this fighter!" + ANSI_RESET);
            enterTown(T, H, EnemiesSpawned);
        } else
            {
            while (!H.deathStatus() && !T.getFighter().deathStatus())
            {
                H.fight(T.getFighter(),H);
            }

            if (H.deathStatus())
            {
                Loser(H);
            }
            else if (T.getFighter().deathStatus())
            {
                H.setKills();
                System.out.println(ANSI_GREEN + "\nEnemy Defeated!" + ANSI_RESET);
            }
            if (H.getKills() == EnemiesSpawned)
            {
               Winner(H);
            }
            else
            {
                enterTown(T, H, EnemiesSpawned);
            }
        }
    }

    //Try your luck with a magician
    public static void optionB(Town T, Human H, int EnemiesSpawned)
    {
        System.out.println(T.getMagician().giveCharm(H,T));

        if (H.deathStatus())
        {
           Loser(H);
        } else
            {
            T.generateMagician();
            enterTown(T, H, EnemiesSpawned);
        }
    }

    //Equip weapon in Town
    public static void optionC(Town T, Human H, int EnemiesSpawned)
    {
        if (!T.getWeapon().isReached())
        {
            H.setInventory(T.getWeapon());
        }
        System.out.println(T.getWeapon().giveBoost(H));
        enterTown(T, H, EnemiesSpawned);
    }

    //Drink a potion
    public static void optionD(Town T, Human H, int EnemiesSpawned)
    {
        System.out.println(H.drinkPotion(T.getPotion()));

        if (H.deathStatus())
        {
           Loser(H);
        }
        else {
            enterTown(T, H, EnemiesSpawned);
        }
    }

    public static void optionF(Town T, Human H, int EnemiesSpawned)
    {
        if (H.getInventory().isEmpty())
        {
            System.out.println("\nYOUR CURRENT INVENTORY IS EMPTY!");
        }
        else
        {
            System.out.print("\nCURRENT INVENTORY:");

            for (int i = 0; i < H.getInventory().size(); i++)
            {
                if (i == H.getInventory().size() - 1)
                {
                    System.out.print(" " + H.getInventory().get(i).getName() + "[+" + H.getInventory().get(i).getBoost() +" ATTACK]" + "\n");
                }
                else
                {
                    System.out.print(" " + H.getInventory().get(i).getName() + "[+" + H.getInventory().get(i).getBoost() +" ATTACK]" + ",");
                }
            }
        }
        enterTown(T, H, EnemiesSpawned);
    }

    //Load description of game from a file
    public static void loadSynopsis() throws IOException
    {
        {
            BufferedReader inputStream = new BufferedReader(new FileReader("synopsis.txt"));
            String line = inputStream.readLine();

            while (line != null)
            {
                printMsg(line,5);
                line = inputStream.readLine();
            }

            System.out.println();
        }
    }

    //When a Human has lost, display info and quit
    public static void Loser(Human H)
    {
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_RESET = "\u001B[0m";

        System.out.println(ANSI_RED + "\nYou lost. You were conquered. Game over." + ANSI_RESET);
        System.out.println("Fun Fact: You dealt a total of " + H.getDMGTracker() + "[DMG] to enemies!");
        System.exit(0);
    }

    //When a Human has won, display info and quit
    public static void Winner(Human H)
    {
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_RESET = "\u001B[0m";

        System.out.println(ANSI_GREEN + "\nYou have done well comrade. You have conquered all the towns! All adversaries have been neutralised!" + ANSI_RESET);
        System.out.println("Fun Fact: You dealt a total of " + H.getDMGTracker() + "[DMG] to enemies!");
        System.exit(0);
    }

    //General input method for string input
    public static String inputString(String message)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);

        return scanner.nextLine();
    }

    //General input method for integer input
    public static int inputInt(String message) throws IOException {
        try
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println(message);
            return Integer.parseInt(scanner.nextLine());
        }
        catch (Exception e)
        {
            System.out.println("\nOnly Integers Are Allowed!\n");
            startGame();
        }
        return 1;
    }

    //Print message using intervals
    public static void printMsg(String text, int time)
    {
        for (char c : text.toCharArray())
        {
            System.out.print(c);
            cooldown(time);
        }
        System.out.println();
    }

    //short stoppage to simulate typewriter effect
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