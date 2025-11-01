package bridge;

public class SubZero extends Hero{
    public SubZero(HeroType heroType){
        super("SubZero", heroType);
    }

    @Override
    public void uniqueAbility() {
        System.out.println("SubZero: Freeze!");
        notifyObservers("SubZero used freeze attack");
    }
}
