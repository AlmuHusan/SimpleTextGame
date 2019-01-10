package Main;

import Monsters.Monster;

import java.util.Scanner;



public class Combat extends MasterStage {
    Scanner input = new Scanner(System.in);
    int usable = 0;
    String CombatChoice;

    public void Battle(Hero good, Monster bad) {
        System.out.println("You are now fighting a " + bad.getMonsterName());
        while (true) {
            if (bad.getMonsterHealth() <= 0) {
                System.out.println("You did it you killed the "+ bad.getMonsterName()+ " you basically won");
                System.out.println("You gained "+bad.getMonsterGold()+" gold!");
                good.addGold(bad.getMonsterGold());
                break;
            }
            if (good.getHealth() <= 0) {
                System.out.println("You died to the "+ bad.getMonsterName()+" GAME OVER");
                stop();
                System.exit(0);
            }
            System.out.println("You have " + good.getHealth() + " health");
            System.out.println("Enter 1 to attack");
            if (good.checkUsable()) {
                System.out.println("Enter 2 to drink your potion");
                usable = 1;
            }
            String CombatChoice = input.nextLine();
            while (!CombatChoice.trim().equals("1") || !CombatChoice.trim().equals("2")) {
                if (CombatChoice.trim().equals("1")) {
                    DamageStep(good, bad);
                    break;

                } else if (CombatChoice.trim().equals("2") && good.checkUsable()) {
                    hero.useItem();
                    hero.TakeDamage(bad.getMonsterDamage());
                    break;
                } else {
                    System.out.println("Invalid input please try again");
                    CombatChoice = input.nextLine();
                }
            }
        }
    }

    private void DamageStep(Hero good, Monster bad) {
        System.out.println("You "+good.getWeaponDescription()+" and deal "+good.getWeaponAttack()+" damage.");
        bad.setMonsterHealth(bad.getMonsterHealth()-good.getWeaponAttack());
        if(bad.getMonsterHealth()>0) {
            System.out.println("The "+bad.getMonsterName()+" "+ bad.getMonsterWeapDescription()+" and deals "+bad.getMonsterDamage());
            good.setHealth(good.getHealth() - bad.getMonsterDamage());
        }

    }
}
