package Items;

import Main.Hero;

public class HealthPotion extends Item implements Usable {
    public HealthPotion() {
        super("Health Potion");

    }


    @Override
    public void ItemEffect(Hero heroeff) {
        heroeff.setHealth(heroeff.getHealth()+10);
        System.out.println(heroeff.getHealth());

    }


}
