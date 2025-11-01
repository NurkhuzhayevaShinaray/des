package strategy;

public interface AttackStrategy {
    void attack(String attacker, String target);
    int getDamage();
    String getType();
}
