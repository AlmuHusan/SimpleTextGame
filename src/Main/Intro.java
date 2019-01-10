package Main;

import Main.MasterStage;

import java.io.File;
import java.util.Scanner;

public class Intro extends MasterStage {
    public static void main (String[]args){
        File s = new File("save.bin");
        if(s.exists()&&!s.isDirectory()){
            try {
                SaveData save = SaveLoad.load();
                hero=save.getHero();
                save.setTriggers();
                LoadArea load= new LoadArea(save.getTavern());

            }
            catch(Exception e){ e.printStackTrace();}
        }
        else {
            String choiceA;
            boolean NotPickedProfession = true;
            Scanner input = new Scanner(System.in);
            System.out.println("Hello and welcome to this adventure");
            System.out.println("To start what is your name");
            choiceA = input.nextLine();
            System.out.println("Now choose your class");
            System.out.println("Type 1 to become a Warrior");
            System.out.println("Type 2 to become a Rogue");
            System.out.println("Type 3 to become a Mage");

            String choiceB = input.next();
            while (NotPickedProfession) {
                if (choiceB.trim().equals("1")) {
                    choiceB = "Warrior";
                    hero.SetProfession(choiceA, choiceB);
                    NotPickedProfession = false;
                } else if (choiceB.trim().equals("2")) {
                    choiceB = "Rogue";
                    hero.SetProfession(choiceA, choiceB);
                    NotPickedProfession = false;
                } else if (choiceB.trim().equals("3")) {
                    choiceB = "Mage";
                    hero.SetProfession(choiceA, choiceB);
                    NotPickedProfession = false;
                } else {
                    System.out.println("Incorrect input pls try again");
                    choiceB = input.next();
                }
            }
            System.out.println("Your name is " + hero.getName() + " and you are a " + hero.getProfession());
            System.out.println("Now your adventure begins");
            stage1.start();
        }



}




}
