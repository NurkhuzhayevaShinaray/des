package builder_factory;

import bridge.*;
import strategy.*;
import java.util.Scanner;

public class Director {

    public Hero constructHero() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Player 1 - Choose hero type:");
        System.out.println("1. Warrior");
        System.out.println("2. Mage");
        System.out.println("3. Archer");
        System.out.print("Enter choice (1-3): ");
        int heroTypeChoice = sc.nextInt();
        sc.nextLine();

        HeroType type;
        switch (heroTypeChoice) {
            case 1 -> type = new Warrior();
            case 2 -> type = new Mage();
            case 3 -> type = new Archer();
            default -> {
                System.out.println("Invalid choice! defaulting to Warrior.");
                type = new Warrior();
            }
        }

        System.out.println("Choose character:");
        System.out.println("1. SubZero");
        System.out.println("2. Sindel");
        System.out.println("3. Kano");
        System.out.println("4. Erron Black");
        System.out.println("5. Kitana");
        System.out.println("6. Raiden");
        System.out.println("7.Rambo");
        System.out.println("8. Scorpion");
        System.out.println("9. Shang Tsung");
        System.out.println("10. Customize");
        System.out.print("Enter choice (1-10): ");
        int characterChoice = sc.nextInt();
        sc.nextLine();

        Hero hero;

        if (characterChoice == 10) {
            Builder builder = new Builder();

            System.out.print("Enter custom hero name: ");
            String name = sc.nextLine();

            System.out.println("Select hero type:");
            System.out.println("1. Warrior");
            System.out.println("2. Mage");
            System.out.println("3. Archer");
            int customTypeChoice = sc.nextInt();
            sc.nextLine();
            HeroType customType = switch (customTypeChoice) {
                case 1 -> new Warrior();
                case 2 -> new Mage();
                case 3 -> new Archer();
                default -> new Warrior();
            };

            System.out.print("Enter hero health (10-200): ");
            int health = sc.nextInt();
            sc.nextLine();

            System.out.println("Choose strategy type:");
            System.out.println("1. Melee Attack");
            System.out.println("2. Magic Attack");
            System.out.println("3. Ranged Attack");
            int attackChoice = sc.nextInt();
            sc.nextLine();
            AttackStrategy attack = switch (attackChoice) {
                case 1 -> new Melee();
                case 2 -> new Magic();
                case 3 -> new Ranged();
                default -> new Melee();
            };

            System.out.print("Enter your hero's unique ability: ");
            String ability = sc.nextLine();
            hero = builder.setName(name)
                    .setType(customType)
                    .setHealth(health)
                    .setCustomAbility(ability)
                    .build();

            hero.setAttackStrategy(attack);
        } else {
            String name = switch (characterChoice) {
                case 1 -> "SubZero";
                case 2 -> "Sindel";
                case 3 -> "Kano";
                case 4 -> "Erron Black";
                case 5 -> "Kitana";
                case 6 -> "Raiden";
                case 7 -> "Rambo";
                case 8 -> "Scorpion";
                case 9 -> "Shang Tsung";
                default -> "Unknown";
            };
            hero = HeroFactory.createHero(name, type);
        }

        System.out.println("Created hero: ");
        System.out.println("Name: " + hero.getName());
        System.out.println("Type: " + hero.getTypeName());
        System.out.println("Health: " + hero.getHealth() + "/" + hero.getMaxHealth());
        return hero;
    }
}
