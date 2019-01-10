package Main;

import Items.Item;
import Items.Usable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

import static Main.MasterStage.hero;

public class Hero extends MasterStage implements Serializable{
    private String Name;
    private String Profession;
    private int Health;
    private int MaxHealth;
    private int Gold;
    private int temp=0;
    private String WeaponName;
    private String WeaponDescription;
    private int WeaponAttack;
    private ArrayList<Item> HeroInventory = new ArrayList<Item>(10);


    public void SetProfession(String name,String profession){
        Name = name;
        if(profession.equals("Warrior")) {
            Profession=profession;
            Health = 20;
            MaxHealth=20;
            WeaponName = "Axe";
            WeaponDescription="swing your axe";
            WeaponAttack=5;
            Gold=15;
        }
        else if(profession.equals("Rogue")){
            Profession=profession;
            Health = 17;
            MaxHealth=17;
            WeaponName = "Dagger";
            WeaponDescription="slice with your dagger";
            WeaponAttack=6;
            Gold=15;

        }


        else if (profession.equals("Mage")){
            Profession=profession;
            Health = 15;
            MaxHealth=15;
            WeaponName = "Wand";
            WeaponDescription="conjure a fireball";
            WeaponAttack=7;
            Gold=15;

        }
    }
    public void addInventory(Item item){
        HeroInventory.add(item);
    }
    public boolean checkUsable(){
        temp=0;
        for (Item e :HeroInventory)
        {    if(e instanceof Usable) {

            return true;
          }
          temp+=1;
        }
        return false;
    }

    public void useItem(){
        HeroInventory.get(temp).ItemEffect(hero);
        HeroInventory.remove(temp);
    }
    public void TakeDamage(int damage) {
        Health-=damage;
    }

    public String getName(){
        return Name;
    }
    public void setName(String Name){
        this.Name = Name;
    }

    public String getProfession(){
        return Profession;
    }
    public int getHealth(){
        return Health;
    }
    public int getMaxHealth(){ return MaxHealth; }
    public void setHealth(int health){
        this.Health = health;
    }

    public String getWeaponName(){
        return WeaponName;
    }
    public String getWeaponDescription(){
        return WeaponDescription;
    }
    public int getWeaponAttack(){
        return WeaponAttack;
    }
    public void setWeaponAttack(int Damage){
        WeaponAttack+=Damage;
    }

    public void AddItem(Item item){
        HeroInventory.add(item);
    }
    public void addGold(int gold){ Gold+=gold;}
    public void loseGold(int gold) {Gold-=gold;}
    public int getGold(){ return Gold;}

    public boolean checkInventory(String s){
        for(Item i:HeroInventory){
            if(i.getItemName().equals(s)){
                return true;
            }
        }
        return false;
    }

    public void healthCheck(){
        if (Health<=0){
            System.out.println("You died!");
            stop();
        }
    }

}
