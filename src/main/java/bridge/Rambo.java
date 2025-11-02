package bridge;

public class Rambo extends Hero{
    public Rambo(HeroType heroType){
        super("Rambo", heroType);
    }
    @Override
    public void uniqueAbility(Hero target) {
       System.out.println("Rambo:I'm your worst nightmare!");
       int damage= 30+ heroType.getBonusDamage();
       notifyObservers("Rambo performing artillery strike " + target.getName() + " for "+damage+ " damage");
       target.takeDamage(damage);
    }
}
