package bridge;

public class Scorpion extends Hero {
    public Scorpion(HeroType heroType) {
        super("Scorpion", heroType);
    }
    @Override
    public void uniqueAbility(Hero target) {
        System.out.println("Scorpion: get over here!");
        int damage = 30+ heroType.getBonusDamage();
        notifyObservers("Scorpion used spear pull " + target.getName() + " for "+damage+ " damage");
        target.takeDamage(damage);
    }
}