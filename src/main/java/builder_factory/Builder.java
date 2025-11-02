package builder_factory;
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
    private String customAbility;



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
    public IHeroBuilder setCustomAbility(String ability) {
        this.customAbility = ability;
        return this;
    }

    @Override
    public Hero build() {
        validateBuild();
        CustomizedHero hero = new CustomizedHero(name, heroType);
        hero.setCustomAbility(customAbility);
        applyCustomizations(hero);
        return hero;
    }

    private void validateBuild() {
        if (name == null || heroType == null) {
            throw new IllegalStateException("Hero name and type are required");
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