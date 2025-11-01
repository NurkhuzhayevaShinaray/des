package bridge;

public class Rambo extends Hero{
    public Rambo(HeroType heroType){
        super("Rambo", heroType);
    }
    @Override
    public void uniqueAbility() {
       System.out.println("Rambo:I'm your worst nightmare!");
       notifyObservers("Rambo performing artillery strike ");
    }
}
