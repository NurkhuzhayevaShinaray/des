package bridge;

public class Archer implements HeroType{
    @Override
    public String getTypeName() {
        return "archer";
    }
    @Override
    public int getBaseHealth() {
        return 85;
    }
    @Override
    public int getBonusDamage() {
        return 5;
    }
    @Override
    public void specialAbility() {
        System.out.println("Archer uses multi-shot:firing multiple arrows at once");
    }

}
