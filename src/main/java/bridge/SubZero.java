package bridge;

public class SubZero extends Hero{
    public SubZero(HeroType heroType){
        super("SubZero", heroType);
    }

    @Override
    public void uniqueAbility(Hero target) {
        System.out.println("SubZero: Freeze!");
        int damage= 30+ heroType.getBonusDamage();
        notifyObservers("SubZero used freeze attack "+ target.getName()+ " for "+ damage+" damage");
        target.takeDamage(damage);
    }
}
