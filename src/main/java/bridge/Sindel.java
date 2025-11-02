package bridge;

public class Sindel extends Hero {
    public Sindel(HeroType heroType) {
        super("Sindel", heroType);
    }
    @Override
    public void uniqueAbility(Hero target) {
        System.out.println("Sindel: Kneel before your Empress!");
        int damage= 30+ heroType.getBonusDamage();
        notifyObservers("Sindel used demon portal "+target.getName()+" for " +damage+ " damage");
        target.takeDamage(damage);
    }
}
