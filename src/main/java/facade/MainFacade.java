package facade;
import bridge.Hero;
import java.util.List;
import java.util.Scanner;

public class MainFacade {
    private HeroCreationFacade heroFacade;
    private BattleFacade battleFacade;
    private StatisticsFacade statsFacade;
    private InstructionsFacade instructionsFacade;
    private Scanner scanner;
    private GameManager gameManager;

    public MainFacade(GameManager gameManager) {
        this.gameManager = gameManager;
        this.heroFacade = new HeroCreationFacade();
        this.battleFacade = new BattleFacade(gameManager);
        this.statsFacade = new StatisticsFacade();
        this.instructionsFacade = new InstructionsFacade();
        this.scanner = new Scanner(System.in);
    }

    public void startSinglePlayerGame() {
        System.out.println("Starting Single Player Game...");
        Hero player = heroFacade.createPlayerHero("Player");
        Hero ai = heroFacade.createAIHero();

        battleFacade.startPlayerVsAI(player, ai);

        recordBattleResult(player, ai);
    }

    public void startTwoPlayerGame() {
        System.out.println("Starting Two Player Game...");
        Hero player1 = heroFacade.createPlayerHero("Player 1");
        Hero player2 = heroFacade.createPlayerHero("Player 2");

        battleFacade.startPlayerVsPlayer(player1, player2);

        recordBattleResult(player1, player2);
    }

    public void startTeamBattleGame() {
        System.out.println("Starting Team Battle...");
        List<Hero> team1 = heroFacade.createTeam("Team 1", 2);
        List<Hero> team2 = heroFacade.createTeam("Team 2", 2);

        battleFacade.startTeamBattle(team1, team2);

        statsFacade.recordTeamBattleResult("Team Battle Completed");
    }

    public void startPracticeSession() {
        System.out.println("Starting Practice Session...");
        Hero player = heroFacade.createPlayerHero("Player");

        battleFacade.startPractice(player);
    }

    public void startQuickPlay() {
        System.out.println("Quick Play Mode...");
        battleFacade.quickBattle();
    }

    public void showGameStats() {
        statsFacade.showGameStatistics();
        statsFacade.showHeroStatistics();
        statsFacade.showLeaderboard();
    }

    public void showHelp() {
        instructionsFacade.showCompleteInstructions();
    }

    public int getIntInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.print("Please enter a number: ");
            scanner.next();
        }
        int input = scanner.nextInt();
        scanner.nextLine();
        return input;
    }

    private void recordBattleResult(Hero hero1, Hero hero2) {
        if (hero1.isAlive()) {
            statsFacade.recordBattleResult(hero1.getName(), hero2.getName());
        } else {
            statsFacade.recordBattleResult(hero2.getName(), hero1.getName());
        }
    }
}