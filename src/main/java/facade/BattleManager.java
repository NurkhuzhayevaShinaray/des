package facade;
import bridge.*;
import builder_factory.*;
import observer.*;
import strategy.*;
import java.util.*;

public class BattleManager {
    private Scanner scanner;
    private Random random;
    private Leaderboard leaderboard;

    public BattleManager(Leaderboard leaderboard) {
        this.scanner = new Scanner(System.in);
        this.random = new Random();
        this.leaderboard = leaderboard;
    }

    public void startBattleMode() {
        System.out.println("Battle modes:");
        System.out.println("1. Player vs AI");
        System.out.println("2. Player vs Player");
        System.out.println("3. Back to Main Menu");

        int choice = getIntInput("Enter your choice (1-3): ", 1, 3);
        switch (choice) {
            case 1 -> startPlayerVsAI();
            case 2 -> startPlayerVsPlayer();
            case 3 -> { return; }
        }
    }

    private void startPlayerVsAI() {
        System.out.println("Player vs ai-bot:");
        Hero player1 = createPlayerHero("Player 1");
        Hero aiPlayer = createRandomAIHero();
        System.out.println("AI has chosen: " + aiPlayer.getName() + " (" + aiPlayer.getTypeName() + ")");
        addObservers(player1);
        addObservers(aiPlayer);
        startBattle(player1, aiPlayer, true);
    }

    private void startPlayerVsPlayer() {
        System.out.println("Player vs Player");
        System.out.println("Player 1:");
        Hero player1 = createPlayerHero("Player 1");
        System.out.println("Player 2:");
        Hero player2 = createPlayerHero("Player 2");
        addObservers(player1);
        addObservers(player2);
        startBattle(player1, player2, false);
    }

    private Hero createPlayerHero(String playerName) {
        Director director = new Director();
        return director.constructHero();
    }

    private Hero createRandomAIHero() {
        String[] heroNames = {"SubZero", "Sindel", "Kano", "Erron Black", "Kitana",
                "Raiden", "Rambo", "Scorpion", "Shang Tsung"};
        HeroType[] heroTypes = {new Warrior(), new Mage(), new Archer()};
        String randomName = heroNames[random.nextInt(heroNames.length)];
        HeroType randomType = heroTypes[random.nextInt(heroTypes.length)];
        return HeroFactory.createHero(randomName, randomType);
    }

    private void addObservers(Hero hero) {
        hero.addObserver(new Announcer());
        hero.addObserver(new Logger());
    }

    private void startBattle(Hero hero1, Hero hero2, boolean isVsAI) {
        System.out.println("Battle starts..");
        System.out.println(hero1.getName() + " (" + hero1.getTypeName() + ") vs " + hero2.getName() + " (" + hero2.getTypeName() + ")");
        Hero currentAttacker = hero1;
        Hero currentDefender = hero2;
        int round = 1;
        while (hero1.isAlive() && hero2.isAlive()){
            System.out.println("Round" + round);
            showBattleStatus(hero1,hero2);
            if (currentAttacker==hero1 || !isVsAI){
                playerTurn(currentAttacker, currentDefender);
            } else {
                aiTurn(currentAttacker,currentDefender);
            }
            if (!hero1.isAlive() || !hero2.isAlive()){
                break;
            }

            Hero temp = currentAttacker;
            currentAttacker = currentDefender;
            currentDefender = temp;

            round++;

        }

        determineWinner(hero1, hero2);
    }

    private void showBattleStatus(Hero hero1, Hero hero2) {
        System.out.println(hero1.getName() + " Health: " + hero1.getHealth());
        System.out.println(hero2.getName() + " Health: " + hero2.getHealth());
    }

    private void playerTurn(Hero attacker, Hero defender) {
        System.out.println(attacker.getName() + "'s turn!");
        System.out.println("1. Basic Attack");
        System.out.println("2. Use Special Ability");
        System.out.println("3. Use Unique Ability");
        System.out.println("4. Change Attack Strategy");
        int choice = getIntInput("Choose action (1-4): ", 1, 4);

        switch (choice) {
            case 1 -> attacker.attack(defender);
            case 2 -> attacker.useSpecialAbility(defender);
            case 3 -> attacker.uniqueAbility(defender);
            case 4 -> changeAttackStrategy(attacker);
        }
    }

    private void aiTurn(Hero attacker, Hero defender) {
        System.out.println(attacker.getName() + "'s turn (bot)!");
        int action = random.nextInt(3) + 1;
        switch (action) {
            case 1 -> attacker.attack(defender);
            case 2 -> attacker.useSpecialAbility(defender);
            case 3 -> attacker.uniqueAbility(defender);
        }
    }

    private void changeAttackStrategy(Hero hero) {
        System.out.println("Choose Attack Strategy:");
        System.out.println("1. Melee");
        System.out.println("2. Magic");
        System.out.println("3. Ranged");
        int choice = getIntInput("Enter choice (1-3): ", 1, 3);

        AttackStrategy strategy = switch (choice) {
            case 1 -> new Melee();
            case 2 -> new Magic();
            case 3 -> new Ranged();
            default -> new Melee();
        };
        hero.setAttackStrategy(strategy);
    }

    private void determineWinner(Hero hero1, Hero hero2) {
        System.out.println("Battle results:");
        if (!hero1.isAlive() && !hero2.isAlive()) {
            System.out.println("It's a draw! Both heroes were defeated.");
        } else if (!hero1.isAlive()) {
            System.out.println(hero2.getName() + " wins!");
            leaderboard.updateLeaderboard(hero2.getName());
        } else if (!hero2.isAlive()) {
            System.out.println(hero1.getName() + " wins!");
            leaderboard.updateLeaderboard(hero1.getName());
        } else {
            if (hero1.getHealth() > hero2.getHealth()) {
                System.out.println(hero1.getName() + " wins by having more health!");
                leaderboard.updateLeaderboard(hero1.getName());
            } else if (hero2.getHealth() > hero1.getHealth()) {
                System.out.println(hero2.getName() + " wins by having more health!");
                leaderboard.updateLeaderboard(hero2.getName());
            } else {
                System.out.println("It's a draw! Both heroes have equal health.");
            }
        }
        leaderboard.showLeaderboard();
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
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine();
            }
        }
    }
}
