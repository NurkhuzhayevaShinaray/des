package facade;

import bridge.Hero;
import java.util.List;
import java.util.Scanner;

public class GameManager {
    private Scanner scanner;
    private MainFacade mainFacade;

    public GameManager() {
        this.scanner = new Scanner(System.in);
        this.mainFacade = new MainFacade(this); // Pass 'this' to avoid circular dependency
    }

    public void startGame() {
        System.out.println("🎮 MORTAL KOMBAT - Starting Game...");
        System.out.println("=====================================");

        while (true) {
            showMainMenu();
            int choice = getIntInput("Choose an option: ");

            switch (choice) {
                case 1:
                    startBattleMode();
                    break;
                case 2:
                    mainFacade.startPracticeSession();
                    break;
                case 3:
                    mainFacade.showGameStats();
                    break;
                case 4:
                    mainFacade.showHelp();
                    break;
                case 5:
                    mainFacade.startQuickPlay();
                    break;
                case 6:
                    System.out.println("Thanks for playing! Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }

            System.out.println("\nPress Enter to continue...");
            scanner.nextLine();
        }
    }

    private void showMainMenu() {
        System.out.println("\n=== MAIN MENU ===");
        System.out.println("1. Battle Modes");
        System.out.println("2. Practice Mode");
        System.out.println("3. Statistics");
        System.out.println("4. Instructions");
        System.out.println("5. Quick Play");
        System.out.println("6. Exit Game");
    }

    private void startBattleMode() {
        System.out.println("\n=== BATTLE MODES ===");
        System.out.println("1. Player vs AI");
        System.out.println("2. Player vs Player");
        System.out.println("3. Team Battle");
        System.out.println("4. Back to Main Menu");

        int choice = getIntInput("Choose battle type: ");

        switch (choice) {
            case 1:
                mainFacade.startSinglePlayerGame();
                break;
            case 2:
                mainFacade.startTwoPlayerGame();
                break;
            case 3:
                mainFacade.startTeamBattleGame();
                break;
            case 4:
                return;
            default:
                System.out.println("Invalid choice!");
        }
    }

    // Battle methods
    public void startBattle(Hero player1, Hero player2) {
        System.out.println("⚔️ Battle: " + player1.getName() + " vs " + player2.getName());
        System.out.println("Fight!");
        // Simple battle simulation
        if (Math.random() > 0.5) {
            System.out.println("🎉 " + player1.getName() + " wins!");
        } else {
            System.out.println("🎉 " + player2.getName() + " wins!");
        }
    }

    public void startTeamBattle(List<Hero> team1, List<Hero> team2) {
        System.out.println("👥 Team Battle: " + team1.size() + " vs " + team2.size());
        System.out.println("Team fight!");
        if (Math.random() > 0.5) {
            System.out.println("🏆 Team 1 wins!");
        } else {
            System.out.println("🏆 Team 2 wins!");
        }
    }

    public void startPractice(Hero player) {
        System.out.println("🏋️ Practice session for: " + player.getName());
        System.out.println("Training completed!");
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
}