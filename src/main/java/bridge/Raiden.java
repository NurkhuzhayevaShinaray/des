package bridge;

public class Raiden extends Hero {
    public Raiden(HeroType heroType) {
        super("Raiden", heroType);
    }
    public void uniqueAbility() {
        System.out.println("Raiden: I am Raiden, God of Thunder!");
        notifyObservers("Raiden used lightning attack");
    }
}
