package strategy;

class Melee implements AttackStrategy {
   @Override
    public void attack(String attacker, String target) {
        System.out.println(attacker + " performs melee attack on " + target);
    }
    @Override
    public int getDamage() {
       return 20;
   }
   @Override
    public String getType() {
       return "melee";
   }
}
