package bridge;

public class ErronBlack extends Hero{
    public ErronBlack(HeroType heroType){
        super("Erron Black", heroType);
    }
    @Override
    public void uniqueAbility() {
     System.out.println("Erron Black: I've got a bullet for every last one!");
     notifyObservers("Erron Black shooting..");
    }
}
