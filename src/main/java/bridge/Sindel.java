package bridge;

public class Sindel extends Hero {
    public Sindel(HeroType heroType) {
        super("Sindel", heroType);
    }
    public void uniqueAbility() {
        System.out.println("Sindel: Kneel before your Empress!");
        notifyObservers("Sindel used demon portal");
    }
}
