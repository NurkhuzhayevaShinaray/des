package bridge;

public class Kitana extends Hero {
    public Kitana(HeroType heroType) {
        super("Kitana", heroType);
    }
    @Override
    public void uniqueAbility(Hero target) {
        System.out.println("Kitana:I'll feed you to a tigore!");
        int damage = 30 + heroType.getBonusDamage();
        notifyObservers("Kitana used fan throw on "+ target.getName() + " for "+ damage+ "damage");
        target.takeDamage(damage);
    }
}
