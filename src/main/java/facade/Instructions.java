package facade;
import java.util.*;

public class Instructions {
    private List<String> customizedHeroes;
    private Leaderboard leaderboard;

    public Instructions() {
        this.customizedHeroes = new ArrayList<>();
        this.leaderboard = new Leaderboard();
    }

    public void showInstructions() {
        System.out.println("Game instructions:");
        System.out.println("Character types:");
        System.out.println("1. Warrior - High health, medium damage");
        System.out.println("-Base Health: 180, Bonus Damage: 10");
        System.out.println("-Special: Whirlwind attack");

        System.out.println("2. Mage - Medium health, high damage");
        System.out.println("-Base Health: 95, Bonus Damage: 15");
        System.out.println("-Special: Powerful spells");

        System.out.println("3. Archer - Low health, versatile damage");
        System.out.println("-Base Health: 85, Bonus Damage: 5");
        System.out.println("-Special: Multi-shot arrows");

        System.out.println("Attack strategies:");
        System.out.println("-Melee: Close combat (20 damage)");
        System.out.println("-Magic: Spell casting (20 damage)");
        System.out.println("-Ranged: Distance attacks (15 damage)");

        System.out.println("Battle rules:");
        System.out.println("- Maximum 3 rounds per battle");
        System.out.println("- Heroes take turns attacking");
        System.out.println("- Use special abilities for extra effects");
        System.out.println("- Winner is last hero standing or with most health");

        showCustomizedHeroes();
    }

    public void addCustomizedHero(String heroName) {
        if (!customizedHeroes.contains(heroName)) {
            customizedHeroes.add(heroName);
            leaderboard.addCustomHero(heroName);
        }
    }

    private void showCustomizedHeroes() {
        if (!customizedHeroes.isEmpty()) {
            System.out.println("customized characters:");
            for (String hero : customizedHeroes) {
                System.out.println("- " + hero);
            }
        }
    }
}