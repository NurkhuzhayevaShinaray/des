package facade;
import bridge.*;
import builder_factory.*;
import observer.*;
import strategy.*;
import java.util.*;

public class PracticeMode {
    private Scanner scanner;
    private Random random;
    private Instructions instructions;

    public PracticeMode() {
        this.scanner = new Scanner(System.in);
        this.random = new Random();
        this.instructions = new Instructions();
    }

    public void startPractice() {
        System.out.println("Practice mode");
        System.out.println("Practice against bot with advices!");
        Hero player = createPlayerHero();
        Hero aiOpponent = createRandomAIHero();
        System.out.println("Your opponent: " + aiOpponent.getName() + " (" + aiOpponent.getTypeName() + ")");
        addPracticeObservers(player);
        addPracticeObservers(aiOpponent);
        startPracticeBattle(player, aiOpponent);
    }

    private Hero createPlayerHero() {
        Director director = new Director();
        Hero hero = director.constructHero();
        if (hero instanceof CustomizedHero) {
            instructions.addCustomizedHero(hero.getName());
        }
        return hero;
    }

    private Hero createRandomAIHero() {
        String[] heroNames = {"SubZero", "Sindel", "Kano", "Erron Black", "Kitana",
                "Raiden", "Rambo", "Scorpion", "Shang Tsung"};
        HeroType[] heroTypes = {new Warrior(), new Mage(), new Archer()};
        String randomName = heroNames[random.nextInt(heroNames.length)];
        HeroType randomType = heroTypes[random.nextInt(heroTypes.length)];
        return HeroFactory.createHero(randomName, randomType);
    }

    private void addPracticeObservers(Hero hero) {
        hero.addObserver(new PracticeAnnouncer());
    }

    private void startPracticeBattle(Hero player, Hero aiOpponent) {
        System.out.println("Practice battle start:");
        Hero currentAttacker = player;
        Hero currentDefender = aiOpponent;

        for (int round = 1; round <= 5; round++) {
            System.out.println("Round " + round);
            if (!currentAttacker.isAlive() || !currentDefender.isAlive()) {
                break;
            }
            showBattleStatus(currentAttacker, currentDefender);
            if (currentAttacker == player) {
                playerPracticeTurn(currentAttacker, currentDefender);
            } else {
                aiPracticeTurn(currentAttacker, currentDefender);
            }

            Hero temp = currentAttacker;
            currentAttacker = currentDefender;
            currentDefender = temp;
        }

        showPracticeResults(player, aiOpponent);
    }

    private void playerPracticeTurn(Hero attacker, Hero defender) {
        System.out.println(attacker.getName() + "'s turn!");
        System.out.println("1. Basic Attack");
        System.out.println("2. Use Special Ability");
        System.out.println("3. Use Unique Ability");
        System.out.println("4. Change Attack Strategy");

        int choice = getIntInput("Choose action (1-4): ", 1, 4);
        switch (choice) {
            case 1 -> {
                attacker.attack(defender);
                giveRecommendation(attacker, defender);
            }
            case 2 -> {
                attacker.useSpecialAbility(defender);
                giveRecommendation(attacker, defender);
            }
            case 3 -> {
                attacker.uniqueAbility(defender);
                giveRecommendation(attacker, defender);
            }
            case 4 -> changeAttackStrategy(attacker);
        }
    }

    private void aiPracticeTurn(Hero attacker, Hero defender) {
        System.out.println(attacker.getName() + "'s turn (AI-bot)!");
        int action = random.nextInt(3) + 1;
        switch (action) {
            case 1 -> attacker.attack(defender);
            case 2 -> attacker.useSpecialAbility(defender);
            case 3 -> attacker.uniqueAbility(defender);
        }
    }

    private void giveRecommendation(Hero attacker, Hero defender) {
        System.out.println("Practice tips:");
        if (defender.getHealth() <= 20) {
            System.out.println("Opponent is weak! Finish them with your unique ability!");
        } else if (attacker.getHealth() < 50) {
            System.out.println("You're low on health! Consider using ranged attacks to maintain distance.");
        } else {
            System.out.println("Other strategy attacks work well against " + defender.getTypeName() + " types!");
        }
    }

    private void changeAttackStrategy(Hero hero) {
        System.out.println("Choose Attack Strategy:");
        System.out.println("1. Melee (+20 damage)");
        System.out.println("2. Magic (+20 damage)");
        System.out.println("3. Ranged (+15 damage)");
        int choice = getIntInput("Enter choice (1-3): ", 1, 3);
        AttackStrategy strategy = switch (choice) {
            case 1 -> new Melee();
            case 2 -> new Magic();
            case 3 -> new Ranged();
            default -> new Melee();
        };
        hero.setAttackStrategy(strategy);
        System.out.println("Strategy changed to " + strategy.getType());
    }

    private void showBattleStatus(Hero hero1, Hero hero2) {
        System.out.println(hero1.getName() + " Health: " + hero1.getHealth());
        System.out.println(hero2.getName() + " Health: " + hero2.getHealth());
    }

    private void showPracticeResults(Hero player, Hero aiOpponent) {
        System.out.println("Results: ");
        System.out.println("Final Health:");
        System.out.println(player.getName() + ": " + player.getHealth());
        System.out.println(aiOpponent.getName() + ": " + aiOpponent.getHealth());

        if (player.getHealth() > aiOpponent.getHealth()) {
            System.out.println("Great job! You won over the AI!");
        } else if (aiOpponent.getHealth() > player.getHealth()) {
            System.out.println("Good effort! Try different strategies next time.");
        } else {
            System.out.println("Even match! Well played.");
        }

        System.out.println("Practice makes perfect! Keep training!");
    }

    private int getIntInput(String prompt, int min, int max) {
        while (true) {
            try {
                System.out.print(prompt);
                int input = scanner.nextInt();
                scanner.nextLine();
                if (input >= min && input <= max) {
                    return input;
                }
                System.out.println("Please enter a number between " + min + " and " + max);
            } catch (InputMismatchException e) {
                System.out.println("Invalid input!");
                scanner.nextLine();
            }
        }
    }
}