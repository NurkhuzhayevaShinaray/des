package facade;

import bridge.Hero;
import java.util.List;

public class BattleFacade {
    private GameManager gameManager;

    public BattleFacade(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    public void startPlayerVsAI(Hero player, Hero ai) {
        System.out.println("\n=== PLAYER vs AI BATTLE ===");
        gameManager.startBattle(player, ai);
    }

    public void startPlayerVsPlayer(Hero player1, Hero player2) {
        System.out.println("\n=== PLAYER vs PLAYER BATTLE ===");
        gameManager.startBattle(player1, player2);
    }

    public void startTeamBattle(List<Hero> team1, List<Hero> team2) {
        System.out.println("\n=== TEAM BATTLE ===");
        gameManager.startTeamBattle(team1, team2);
    }

    public void startPractice(Hero player) {
        System.out.println("\n=== PRACTICE MODE ===");
        gameManager.startPractice(player);
    }

    public void quickBattle() {
        System.out.println("\n=== QUICK BATTLE ===");
        HeroCreationFacade heroFacade = new HeroCreationFacade();
        Hero player = heroFacade.createPlayerHero("Quick Player");
        Hero ai = heroFacade.createAIHero();
        startPlayerVsAI(player, ai);
    }
}