package Items;
import Main.Hero;

import java.io.Serializable;


public class Item implements Serializable {

protected String ItemName;
 String ItemDescription;

    public Item(String name) {
        ItemName=name;
    }
    public String getItemName(){
        return ItemName;
    }
    public void ItemEffect(Hero hero) {
    }
}
