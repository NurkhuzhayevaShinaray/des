package builder;
import bridge.Hero;
import bridge.HeroType;
import bridge.*;
import observer.GameObserver;
import java.util.ArrayList;
import java.util.List;


public class Builder implements IHeroBuilder {
    private String name;
    private HeroType heroType;
    private int health;
    private int maxHealth;
    private final List<GameObserver> observers = new ArrayList<>();

    @Override
    public IHeroBuilder setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public IHeroBuilder setType(HeroType heroType) {
        this.heroType = heroType;
        this.health = heroType.getBaseHealth();
        this.maxHealth = heroType.getBaseHealth();
        return this;
    }

    @Override
    public IHeroBuilder setHealth(int health) {
        this.health = health;
        return this;
    }

    @Override
    public IHeroBuilder setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
        return this;
    }

    @Override
    public IHeroBuilder addObserver(GameObserver observer) {
        this.observers.add(observer);
        return this;
    }

    @Override
    public Hero build() {
        validateBuild();
        Hero hero = createHeroByName(name, heroType);
        applyCustomizations(hero);
        return hero;
    }

    private void validateBuild() {
        if (name == null || heroType == null) {
            throw new IllegalStateException("Hero name and type are required");
        }
    }

    private Hero createHeroByName(String characterName, HeroType heroType) {
        switch(characterName.toLowerCase()) {
            case "scorpion":
                return new Scorpion(heroType);
            case "subzero":
                return new SubZero(heroType);
            case "raiden":
                return new Raiden(heroType);
            case "erron black":
                return new ErronBlack(heroType);
            case "kitana":
                return new Kitana(heroType);
            case "rambo":
                return new Rambo(heroType);
            case "shang tsung":
                return new ShangTsung(heroType);
            case "sindel":
                return new Sindel(heroType);
            case "kano":
                return new Kano(heroType);
            default:
                throw new IllegalArgumentException("Unknown character: " + characterName);
        }
    }

    private void applyCustomizations(Hero hero) {
        hero.health = health;
        hero.maxHealth = maxHealth > 0 ? maxHealth : health;

        for (GameObserver observer : observers) {
            hero.addObserver(observer);
        }
    }
}