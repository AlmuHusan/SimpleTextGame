package Main;

import Stage1.S1Well;

import java.io.Serializable;

public class WorldTriggers extends MasterStage implements Serializable {
    public boolean[] arr;
    public WorldTriggers() {
        arr = new boolean[]
        {
                    s1well.WellPotion,
                    s1town.gank,
                    s1town.item1Bought,
                    s1town.item2Bought,
                    s1town.item3Bought,
                    s1town.caveUnlocked
                };

    }

    public void updateTriggers(){
        s1well.WellPotion=arr[0];
        s1town.gank=arr[1];
        s1town.item1Bought=arr[2];
        s1town.item2Bought=arr[3];
        s1town.item3Bought=arr[4];
        s1town.caveUnlocked=arr[5];
    }

}
