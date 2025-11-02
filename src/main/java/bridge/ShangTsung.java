package bridge;

public class ShangTsung extends Hero {
    public ShangTsung(HeroType heroType) {
        super("Shang Tsung", heroType);
    }
    @Override
    public void uniqueAbility(Hero target) {
        System.out.println("Shang Tsung: Your soul is mine!");
        int damage = 30+ heroType.getBonusDamage();
        notifyObservers("Shang Tsung used soul steal "+ target.getName()+" for " +damage+" damage");
        target.takeDamage(damage);
    }
}