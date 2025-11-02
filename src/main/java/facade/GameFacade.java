package facade;
import java.util.*;

public class GameFacade {
    private BattleManager battleManager;
    private Leaderboard leaderboard;
    private Instructions instructions;
    private PracticeMode practiceMode;
    private Scanner scanner;

    public GameFacade() {
        this.leaderboard = new Leaderboard();
        this.battleManager = new BattleManager(leaderboard);
        this.instructions = new Instructions();
        this.practiceMode = new PracticeMode();
        this.scanner = new Scanner(System.in);
    }

    public void startGame() {
        System.out.println("Welcome to battle! Start the game!");
        while (true) {
            showMainMenu();
            int choice = getIntInput("Enter your choice (1-5): ", 1, 5);
            switch (choice) {
                case 1 -> battleManager.startBattleMode();
                case 2 -> practiceMode.startPractice();
                case 3 -> leaderboard.showLeaderboard();
                case 4 -> instructions.showInstructions();
                case 5 -> {
                    System.out.println("Play again, exitting..");
                    return;
                }
            }
        }
    }

    private void showMainMenu() {
        System.out.println("Main menu");
        System.out.println("1. Start Battle");
        System.out.println("2. Practice Mode");
        System.out.println("3. Leaderboard");
        System.out.println("4. Instructions");
        System.out.println("5. Exit");
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