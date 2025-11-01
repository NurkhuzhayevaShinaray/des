package builder;

import bridge.*;
import java.util.Random;
import java.util.Scanner;


public class HeroCreator {
    private Scanner scanner = new Scanner(System.in);
    private Director director;


    private final String[] all_characters = {
            "Scorpion", "SubZero", "Raiden", "Kitana", "Erron Black",
            "Shang Tsung", "Rambo", "Sindel", "Kano"
    };

    private final String[] hero_types = {"Warrior", "Mage", "Archer"};

    public HeroCreator() {
        IHeroBuilder builder = new Builder();
        this.director = new Director(builder);
    }

    public Hero createHero(String playerName) {
        System.out.println(playerName + " - Choose hero build type:");
        System.out.println("1.Warrior");
        System.out.println("2.Mage");
        System.out.println("3.Archer");
        System.out.println("4.Tank Build (High Health)");
        System.out.println("5.Glass Cannon (High Risk)");
        System.out.println("6.Custom Build");
        System.out.print("Enter choice (1-6): ");

        int buildChoice = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Choose character:");
        for (int i = 0; i < all_characters.length; i++) {
            System.out.println((i + 1) + ". " + all_characters[i]);
        }
        System.out.print("Enter choice (1-" + all_characters.length + "): ");
        int charChoice = scanner.nextInt();
        scanner.nextLine();

        String characterName = all_characters[charChoice - 1];

        Hero hero = createHeroWithDirector(characterName, buildChoice);

        System.out.println("Hero chosen: " + characterName);
        return hero;
    }

    private Hero createHeroWithDirector(String characterName, int buildChoice) {
        switch(buildChoice) {
            case 1:
                return director.buildStandardWarrior(characterName);
            case 2:
                return director.buildStandardMage(characterName);
            case 3:
                return director.buildStandardArcher(characterName);
            case 4:
                return director.buildTank(characterName);
            case 5:
                return director.buildGlassCannon(characterName);
            case 6:
                return createCustomHero(characterName);
            default:
                return director.buildStandardWarrior(characterName);
        }
    }

    private Hero createCustomHero(String characterName) {
        System.out.println("Choose hero type for custom build:");
        for (int i = 0; i < hero_types.length; i++) {
            System.out.println((i + 1) + ". " + hero_types[i]);
        }
        System.out.print("Enter choice (1-" + hero_types.length + "): ");
        int typeChoice = scanner.nextInt();
        scanner.nextLine();

        HeroType type = createHeroType(hero_types[typeChoice - 1]);

        System.out.print("Enter custom health: ");
        int health = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter custom max health: ");
        int maxHealth = scanner.nextInt();
        scanner.nextLine();

        return director.buildCustomHero(characterName, type, health, maxHealth);
    }

    private HeroType createHeroType(String typeName) {
        switch(typeName.toLowerCase()) {
            case "warrior": return new Warrior();
            case "mage": return new Mage();
            case "archer": return new Archer();
            default: return new Warrior();
        }
    }

    public Hero createAIHero() {
        Random random = new Random();
        String aiCharacter = all_characters[random.nextInt(all_characters.length)];

        int aiBuild = random.nextInt();
        aiBuild = random.nextInt(5) + 1;

        System.out.println("AI is choosing a hero...");

        Hero aiHero = createHeroWithDirector("AI " + aiCharacter, aiBuild);

        String[] buildNames = {"Standard Warrior", "Standard Mage", "Standard Archer", "Tank", "Glass Cannon"};
        System.out.println("AI chooses: " + aiCharacter + " as " + buildNames[aiBuild - 1]);

        return aiHero;
    }
}
