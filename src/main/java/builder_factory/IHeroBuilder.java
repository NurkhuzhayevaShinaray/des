package builder_factory;
import bridge.Hero;
import bridge.HeroType;
import observer.GameObserver;

public interface IHeroBuilder {
    IHeroBuilder setName(String name);
    IHeroBuilder setType(HeroType heroType);
    IHeroBuilder setHealth(int health);
    IHeroBuilder setMaxHealth(int maxHealth);
    IHeroBuilder setCustomAbility(String ability);
    IHeroBuilder addObserver(GameObserver observer);
    Hero build();

}
