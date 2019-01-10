package Stage1;
import Items.HealthPotion;
import Items.Item;
import Main.Hero;
import static java.lang.System.out;


import Main.MasterStage;

import java.util.Scanner;
public class S1Well extends MasterStage {
    Scanner input = new Scanner(System.in);
    public boolean WellPotion = true;
    private HealthPotion s1wellhpot=new HealthPotion();
    public void start(){
        out.println("You walk south to see a well");
        out.println("What do you do");
        out.println("Enter 1 to investigate the well");
        out.println("Enter 2 to go back");
        String S1Well = input.nextLine();
        while(!S1Well.trim().equals("1")||!S1Well.trim().equals("2")) {
            if (S1Well.trim().equals("1")) {
                WellInvestigate();

            } else if (S1Well.trim().equals("2")) {
                out.println("You head back to where you started");
                stage1.start();

            } else {
                out.println("Invalid input please try again");
                S1Well = input.nextLine();
            }

        }


    }
    public void WellInvestigate(){
        if(WellPotion) {
            out.println("You investigated the well and found a potion");
            hero.addInventory(s1wellhpot);
            WellPotion=false;
            out.println("You head back to where you started");
            stage1.start();
        }
        else {
            out.println("There is nothing of interested here");
            out.println("You head back to where you started");
            stage1.start();
        }
    }




}
