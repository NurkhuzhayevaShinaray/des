package bridge;

public class Warrior implements HeroType{
    @Override
    public String getTypeName() {
        return "warrior";
    }
    @Override
    public int getBaseHealth() {
        return 180;
    }
    @Override
    public int getBonusDamage() {
        return 10;
    }
    @Override
    public void specialAbility() {
      System.out.println("warrior performs whirlwind: a spinning attack! ");
    }

}
