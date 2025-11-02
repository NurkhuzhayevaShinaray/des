package bridge;

public class CustomizedHero extends Hero{
    private String customAbility;

    public CustomizedHero(String name, HeroType heroType){
        super(name, heroType);
    }
    public void setCustomAbility(String customAbility){
        this.customAbility = customAbility;
    }

    @Override
    public void uniqueAbility(Hero target) {
        if (customAbility == null || customAbility.isEmpty()){
            System.out.println(name + " uses a mysterious power!");
            notifyObservers(name + " uses a mysterious power!");
        } else {
            System.out.println(name + " uses " + customAbility + "!");
            notifyObservers(name + " used " + customAbility + "!");
        }

    }
}
