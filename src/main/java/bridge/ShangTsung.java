package bridge;

public class ShangTsung extends Hero {
    public ShangTsung(HeroType heroType) {
        super("Shang Tsung", heroType);
    }
    public void uniqueAbility() {
        System.out.println("Shang Tsung: Your soul is mine!");
        notifyObservers("Shang Tsung used soul steal");
    }
}