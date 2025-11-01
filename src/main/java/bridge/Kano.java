package bridge;

public class Kano extends Hero {
    public Kano(HeroType heroType) {
        super("Kano", heroType);
    }
    public void uniqueAbility() {
        System.out.println("Kano: What a bloody mess!!");
        notifyObservers("Kano used knife throw");
    }
}
