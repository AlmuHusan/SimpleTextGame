package Stage1;

import Items.Item;
import Main.*;

import java.util.Scanner;


public class S1Town extends MasterStage {
    String s;
    public boolean caveUnlocked=false;
    public boolean gank=true;
    public boolean item1Bought=false,item2Bought=false,item3Bought=false;
    boolean villChoice;

    boolean shopChoice=true;

    Scanner input = new Scanner(System.in);
    public void start(){
        if(gank) {
            gank=false;
            System.out.println("As You travel north suddenly a goblin attacks.");
            combat.Battle(hero, mL.newGoblin());
            System.out.println("After killing the goblin you continue heading north to find" +
                    " an isolated village");
            System.out.println("You enter the village. What do you do?");
            s1town.town();

        }
        else{
            System.out.println("You head up north again and make your way back to the village.");
            System.out.println("What do you do?");
            s1town.town();
        }
    }

    public void town(){
        villChoice=true;
        System.out.println("Enter 0 to go to the tavern");
        System.out.println("Enter 1 to go to the shop");
        System.out.println("Enter 2 to check out the town hall");
        if(caveUnlocked) {
            System.out.println("Enter 3 to go north");
        }
        System.out.println("Enter 4 to exit south to where you first started.");
                s = input.nextLine();
                while(!s.trim().equals("0")||!s.trim().equals("1")||!s.trim().equals("2")||!(s.trim().equals("3")&&caveUnlocked)||!s.trim().equals("4")){
                    if(s.trim().equals("0")){
                        s="";
                        villChoice=false;
                        s1town.tavern();
                    }
                    else if(s.trim().equals("1")){
                        s="";
                        villChoice=false;
                        s1town.shop();
                    }
                    else if (s.trim().equals("2")){
                        s="";
                        villChoice=false;
                        System.out.println("You head towards the town hall");
                        s1town.townHall();
                    }
                    else if(s.trim().equals("3")&&caveUnlocked){
                        s="";
                        villChoice=false;
                        System.out.println("You head out north.");
                        s1cave.start();
                    }
                    else if(s.trim().equals("4")){
                        s="";
                        villChoice=false;
                        System.out.println("You exit the town and head south to where you first started");
                        stage1.start();
                    }
                    else{
                        System.out.println("Invalid input please try again");
                        s=input.nextLine();
                    }
                }

            }




    public void tavern(){
        System.out.println("You arrive at the tavern");
        System.out.println("Hello welcome to the tavern");
        System.out.println("What would you like?");
        System.out.println("Enter 1 to rest at the tavern");
        System.out.println("Enter 2 to leave");
        s=input.nextLine();
        while(!s.trim().equals("1")||!s.trim().equals("2")){
            try {
                if (s.trim().equals("1")) {
                    System.out.println("You rest at the tavern");
                    hero.setHealth(hero.getMaxHealth());
                    System.out.println("Your adventure is being saved");
                    WorldTriggers triggers=new WorldTriggers();
                    SaveData save = new SaveData(hero, 1,triggers);
                    System.out.println("Save Made");
                    SaveLoad.save(save);
                    System.out.println("Being rested you head back out to town");
                    s1town.town();
                } else if (s.trim().equals("2")) {
                    System.out.println("You return to town");
                    s1town.town();
                } else {
                    System.out.println("Invalid input please try again");
                    s=input.nextLine();
                }
            }
            catch (Exception e){e.printStackTrace();}
        }

    }

    public void shop(){
        shopChoice=true;
        System.out.println("You go to shop");
        System.out.println("Shopkeeper: \"Hi, what would you like to buy\".");
        s1town.shopOptions();
        while(!(s.trim().equals("1")&&!item1Bought)||!(s.trim().equals("2")&&!item2Bought)||!(s.trim().equals("3")&&!item3Bought)||!s.trim().equals("4")){
            s = input.nextLine();
            if(s.trim().equals("1")&&!item1Bought){
                if(hero.getGold()>=10){
                    System.out.println("You puchased some rope");
                    item1Bought=true;
                    hero.loseGold(10);
                    hero.addInventory(rope);
                    System.out.println("Shopkeeper: \"Anything else you would like\"");
                    s1town.shopOptions();
                    }
                    else{
                        System.out.println("You do not have enough gold...");
                        s1town.shopOptions();
                    }
                }
            else if (s.trim().equals("2")&&!item2Bought){
                if(hero.getGold()>=5){
                    System.out.println("You puchased a torch");
                    item2Bought=true;
                    hero.loseGold(5);
                    hero.addInventory(torch);
                    System.out.println("Shopkeeper: \"Anything else you would like\"");
                    s1town.shopOptions();
                    }
                    else{
                    System.out.println("You do not have enough gold...");
                    s1town.shopOptions();
                    }
                }
            else if(s.trim().equals("3")&&!item3Bought){
                if(hero.getGold()>=7){
                    System.out.println("You puchased a health potion.");
                    item3Bought=true;
                    hero.loseGold(7);
                    hero.addInventory(hpot);
                    System.out.println("Shopkeeper: \"Anything else you would like\"");
                    s1town.shopOptions();
                    }
                    else{
                        System.out.println("You do not have enough gold...");
                        s1town.shopOptions();
                    }
                }
            else if(s.trim().equals("4")){
                shopChoice=false;
                System.out.println("You leave the shop");
                try{
                    Thread.sleep(500);
                    }
                catch (Exception e){}
                    s1town.town();
                }
            }

    }

    public void shopOptions(){
        System.out.println("You have "+hero.getGold()+" gold.");
        if(!item1Bought){
            System.out.println("Enter 1 to buy a rope (10 Gold).");
        }
        if(!item2Bought) {
            System.out.println("Enter 2 to buy a torch (5 Gold).");
        }
        if(!item3Bought) {
            System.out.println("Enter 3 to buy a health potion (7 Gold).");
        }
        if(item1Bought&&item2Bought&&item3Bought) {
            System.out.println("There is nothing of interest to buy....");
        }
        System.out.println("Enter 4 to leave");
    }
    public void townHall(){
        if(!caveUnlocked) {
            System.out.println("At the town hall you find yourself looking at a particularly interested flyer.");
            System.out.println("The details encolsed talks about how the area has been having some issues with goblins in the area" +
                    "\nand how their hidout was discorvered to be in a cave in the north. ");
            System.out.println("For anyone who can deal with the cave will recieve a reward of 50 gold");
            System.out.println("Seeing this is simple task to do, you prepare yourself to head north to deal with this goblin hideout");
            System.out.println("You leave the town hall.");
            s1town.caveUnlocked=true;
            s1town.town();
        }
        else{
            System.out.println("You find nothing of interest at the town hall");
            s1town.town();
        }

    }







}
