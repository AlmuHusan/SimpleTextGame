package Stage1;

import Items.Item;
import Main.Combat;
import Main.MasterStage;
import Monsters.MonsterList;

import java.util.Random;
import java.util.Scanner;

public class S1Cave extends MasterStage{
    Random rand = new Random();
    Scanner input = new Scanner(System.in);
    public void start(){
        int randNum = rand.nextInt((2) + 1) + 1;
        System.out.println(randNum);
        if(randNum==3){
            System.out.println("As you make your way towards the cave you are attacked by a bear");
            combat.Battle(hero, mL.newBear());
            System.out.println("After fighting the bear you continue north to find a cave.");
        }
        else{
            System.out.println("You travel north to find a cave.");

        }
        s1cave.cave();
    }

    public void cave(){
        int caveEntr=0;
        boolean caveEntrChoice=true;
        System.out.println("You reach the front of the cave what do you do?");
        System.out.println("Enter 1 to enter the cave (Make sure you are prepared!)");
        System.out.println("Enter 2 to go back");
        while(caveEntrChoice){
            try{
                caveEntr=input.nextInt();
                if(caveEntr==1){
                    caveEntrChoice=false;
                }
                else if(caveEntr==2){
                    caveEntrChoice=false;
                    s1town.town();
                }
                else{
                    throw new Exception();
                }
            }
            catch(Exception e){
                System.out.println("Invalid input please try again");
                continue;
            }
        }
        System.out.println("You venture into the cave");
        System.out.println("As you travel deeper and deeper into the cave it get very dark");
        if(hero.checkInventory("Torch")){
            System.out.println("Thankfully you have a torch and everything becomes clear");
            System.out.println("You are able to see a big pit right in front of you");
            System.out.println("What do you do?");
            System.out.println("Enter 1 to jump down");
            if(hero.checkInventory("Rope")){
                System.out.println("Enter 2 to use some rope");
            }
            int pitChoice =0;
            boolean pit = true;
            while(pit) {
                try {
                    pitChoice=input.nextInt();
                    if(pitChoice==1){
                        System.out.println("You brace yourself and you jump down");
                        System.out.println("You were able to barely able to take in the full impact of the landing");
                        System.out.println("You took 2 damage");
                        hero.TakeDamage(2);
                        System.out.println("You have "+hero.getHealth()+" Health!");
                        hero.healthCheck();
                        pit=false;
                    }
                    else if(pitChoice==2&& hero.checkInventory("Rope")){
                        System.out.println("Using the rope you bought from the shop you were able to safely reach the bottom of the pit");
                        pit=false;
                    }
                    else{ throw new Exception();}
                }
                catch (Exception e) {
                    System.out.println("Invalid input please try again");
                    continue;
                }
            }
        }
        else{
            System.out.println("You can barely see anything as you move foward");
            System.out.println("Suddenly you fall into a pit");
            System.out.println("You take 5 damage");
            hero.TakeDamage(5);
            System.out.println("You have "+hero.getHealth()+" Health!");
            hero.healthCheck();
            System.out.println("You collect yourself and stand up");

        }
        stop();
        System.out.println("You sense your surroundings and find a foldable ladder");
        System.out.println("At the bottom of the pit you see a long dark hallway with a light at the end of it.");
        if(hero.checkInventory("Torch")){
            System.out.println("Moving forward you notice a small tripwire trap and carefully pass right through it");
        }
        else{
            System.out.println("Going through the hallway you suddenly hit some sort of wire contrapment and you feel a blunt impact to the back of the head.");
            System.out.println("You fell for a hidden trap and took another 5 damage.");
            hero.TakeDamage(5);
            System.out.println("You have "+hero.getHealth()+" Health!");
            hero.healthCheck();
            System.out.println("You recover your marbles and continue foward");
        }
        stop();
        System.out.println("You make your way out of the hallway where you face a goblin encampment");
        System.out.println("All of the goblins see you and charge");
        combat.Battle(hero, mL.new_Goblin_Group());
        System.out.println("After beating the group of goblins you clear their camp to receive 25 gold");
        hero.addGold(25);
        System.out.println("You return to the town to recieve your bounty of 50 gold for clearing the camp");
        System.out.println("You have "+hero.getGold()+" gold!");
        System.out.println("Congratulations you beat the game");
        stop();
        System.exit(0);
        }
    }




