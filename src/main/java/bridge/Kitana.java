package bridge;

public class Kitana extends Hero {
    public Kitana(HeroType heroType) {
        super("Kitana", heroType);
    }
    public void uniqueAbility() {
        System.out.println("Kitana:I'll feed you to a tigore!");
        notifyObservers("Kitana used fan throw");
    }
}
