package bridge;
import observer.GameObserver;
import strategy.AttackStrategy;
import strategy.Magic;
import java.util.ArrayList;
import java.util.List;

public abstract class Hero {
    protected HeroType heroType;
    protected String name;
    public int health;
    public int maxHealth;
    protected AttackStrategy attackStrategy;
    protected List<GameObserver> observers;

    public Hero(String name, HeroType heroType){
        this.name=name;
        this.heroType=heroType;
        this.maxHealth=heroType.getBaseHealth();
        this.health= maxHealth;
        this.attackStrategy = new Magic();
        this.observers= new ArrayList<>();
    }
    public String getName() {
        return name;
    }
    public String getTypeName() {
        return heroType.getTypeName();
    }
    public int getHealth() {
        return health;
    }
    public int getMaxHealth() {
        return maxHealth;
    }
    public boolean isAlive() {
        return health > 0;
    }


    public void addObserver(GameObserver observer) {
        observers.add(observer);
    }
    protected void notifyObservers(String event) {
        for (GameObserver observer : observers) {
            observer.notify(event);
        }
    }
    public void setAttackStrategy(AttackStrategy strategy) {
        this.attackStrategy = strategy;
        notifyObservers(name + " changed to " + strategy.getType() + " strategy");
    }

    public void attack(Hero target) {
        attackStrategy.attack(name, target.getName());
        int damage = attackStrategy.getDamage() + heroType.getBonusDamage();
        notifyObservers(name + " attacks " + target.getName() + " for " + damage + " damage");
        target.takeDamage(damage);
    }

    public void takeDamage(int damage) {
        health -= damage;
        notifyObservers(name + " took " + damage + " damage. Health: " + health);
        if (health <= 0) {
            notifyObservers(name + " has been defeated!");
        }
    }

    public void useSpecialAbility() {
        heroType.specialAbility();
        notifyObservers(name + " used special ability");
    }

    public abstract void uniqueAbility();
}
