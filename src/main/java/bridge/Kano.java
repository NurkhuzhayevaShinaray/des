package bridge;

public class Kano extends Hero {
    public Kano(HeroType heroType) {
        super("Kano", heroType);
    }
    @Override
    public void uniqueAbility(Hero target) {
        System.out.println("Kano: What a bloody mess!!");
        int damage = 30 + heroType.getBonusDamage();
        notifyObservers("Kano used knife throw on "+target.getName()+ " for "+damage+ " damage");
        target.takeDamage(damage);
    }
}
