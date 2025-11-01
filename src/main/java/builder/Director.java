package builder;
import bridge.*;
import bridge.Hero;
import bridge.Warrior;
import observer.Announcer;
import observer.Logger;


public class Director {
    private IHeroBuilder builder;

    public Director(IHeroBuilder builder) {
        this.builder = builder;
    }

    public Hero buildStandardWarrior(String name) {
        return builder
                .setName(name)
                .setType(new Warrior())
                .addObserver(new Logger())
                .addObserver(new Announcer())
                .build();
    }

    public Hero buildStandardMage(String name) {
        return builder
                .setName(name)
                .setType(new Mage())
                .addObserver(new Logger())
                .addObserver(new Announcer())
                .build();
    }

    public Hero buildStandardArcher(String name) {
        return builder
                .setName(name)
                .setType(new Archer())
                .addObserver(new Logger())
                .addObserver(new Announcer())
                .build();
    }

    public Hero buildTank(String name) {
        return builder
                .setName(name)
                .setType(new Warrior())
                .setHealth(200)
                .setMaxHealth(200)
                .addObserver(new Logger())
                .addObserver(new Announcer())
                .build();
    }

    public Hero buildGlassCannon(String name) {
        return builder
                .setName(name)
                .setType(new Mage())
                .setHealth(50)
                .setMaxHealth(50)
                .addObserver(new Logger())
                .addObserver(new Announcer())
                .build();
    }

    public Hero buildCustomHero(String name, HeroType heroType, int health, int maxHealth) {
        return builder
                .setName(name)
                .setType(heroType)
                .setHealth(health)
                .setMaxHealth(maxHealth)
                .addObserver(new Logger())
                .addObserver(new Announcer())
                .build();
    }
}
