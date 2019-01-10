package Main;


import java.io.Serializable;

public class SaveData implements Serializable {
    Hero hero;
    int tavern;
    WorldTriggers triggers;
    public SaveData(Hero hero,int tavern,WorldTriggers triggers){
        this.hero=hero;
        this.tavern=tavern;
        this.triggers=triggers;
    }

    public Hero getHero(){
        return hero;
    }

    public int getTavern(){
        return tavern;
    }

    public void setTriggers(){
        triggers.updateTriggers();
    }
}
