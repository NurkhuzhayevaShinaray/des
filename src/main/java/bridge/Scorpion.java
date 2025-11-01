package bridge;

public class Scorpion extends Hero {
    public Scorpion(HeroType heroType) {
        super("Scorpion", heroType);
    }
    public void uniqueAbility() {
        System.out.println("Scorpion: get over here!");
        notifyObservers("Scorpion used spear pull");
    }
}