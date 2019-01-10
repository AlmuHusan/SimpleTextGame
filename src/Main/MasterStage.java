package Main;

import Items.HealthPotion;
import Items.Item;
import Monsters.MonsterList;
import Stage1.*;

import java.util.Scanner;

public class MasterStage {
    Scanner input = new Scanner(System.in);
    public static Hero hero = new Hero();
    public static Stage1 stage1= new Stage1();
    public static S1Town s1town = new S1Town();
    public static S1Well s1well = new S1Well();
    public static S1Cave s1cave = new S1Cave();
    public static MonsterList mL =new MonsterList();
    public static Combat combat = new Combat();
    public static Item rope = new Item("Rope");
    public static Item torch = new Item("Torch");
    public static HealthPotion hpot=new HealthPotion();

    public void stop(){
        System.out.println("Press enter to continue....");
        String l =input.nextLine();
    }
}
