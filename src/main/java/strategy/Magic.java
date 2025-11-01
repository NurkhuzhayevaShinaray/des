package strategy;

public class Magic implements AttackStrategy{
    @Override
    public void attack(String attacker, String target) {
      System.out.println(attacker+ " performs magic attack on" + target);
    }
    @Override
    public int getDamage() {
        return 20;
    }
    @Override
    public String getType() {
        return "magic";
    }
}
