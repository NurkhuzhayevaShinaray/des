package bridge;

import observer.GameObserver;

public class Mage implements HeroType {
    @Override
    public String getTypeName() {
        return "mage";
    }
    @Override
    public int getBaseHealth() {
        return 95;
    }
    @Override
    public int getBonusDamage() {
        return 15;
    }
    @Override
    public void specialAbility() {
        System.out.println("Mage casts specific powerful spell!");
    }

}
