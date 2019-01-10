package Monsters;

public class Monster {
    int MonsterHealth;
    int MonsterDamage;
    int MonsterGold;
    String MonsterDescription;
    String MonsterName;

    public void setMonsterHealth(int monsterHealth){
        MonsterHealth=monsterHealth;

    }

    public int getMonsterHealth() {
        return MonsterHealth;
    }
    public void TakeDamage(int damage) {
        MonsterHealth-=damage;
    }

    public int getMonsterDamage() {
        return MonsterDamage;
    }

    public void setMonsterDamage(int monsterDamage) {
        MonsterDamage = monsterDamage;
    }

    public String getMonsterDescription() {
        return MonsterDescription;
    }

    public void setMonsterDescription(String monsterDescription) {
        MonsterDescription = monsterDescription;
    }

    public String getMonsterWeapDescription() {
        return MonsterDescription;
    }

    public void setMonsterWeapDescription(String monsterDescription) {
        MonsterDescription = monsterDescription;
    }

    public String getMonsterName() {
        return MonsterName;
    }

    public void setMonsterName(String monsterName) {
        MonsterName = monsterName;
    }

    public int getMonsterGold(){
        return MonsterGold;
    }
    public void setMonsterGold(int gold){
       MonsterGold=gold;
    }

}
