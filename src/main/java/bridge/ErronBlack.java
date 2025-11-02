package bridge;

public class ErronBlack extends Hero{
    public ErronBlack(HeroType heroType){
        super("Erron Black", heroType);
    }
    @Override
    public void uniqueAbility(Hero target) {
     System.out.println("Erron Black: I've got a bullet for every last one!");
     int damage = 30 + heroType.getBonusDamage();
     notifyObservers("Erron Black shooting.." + target.getName() + " for "+ damage+ " damage");
     target.takeDamage(damage);
    }
}
