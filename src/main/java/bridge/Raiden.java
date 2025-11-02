package bridge;

public class Raiden extends Hero {
    public Raiden(HeroType heroType) {
        super("Raiden", heroType);
    }
    @Override
    public void uniqueAbility(Hero target) {
        System.out.println("Raiden: I am Raiden, God of Thunder!");
        int damage = 30+ heroType.getBonusDamage();
        notifyObservers("Raiden used lightning attack " + target.getName()+" for "+ damage + " damage");
        target.takeDamage(damage);
    }
}
