package strategy;

public class Ranged implements AttackStrategy{
    @Override
    public void attack(String attacker, String target) {
        System.out.println(attacker + " performs ranged attack on "+ target);
    }

    @Override
    public int getDamage() {
        return 15;
    }

    @Override
    public String getType() {
        return "ranged";
    }
}
