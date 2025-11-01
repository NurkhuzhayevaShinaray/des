package facade;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class StatisticsFacade {
    private List<String> leaderboard;
    private Map<String, Integer> heroWins;

    public StatisticsFacade() {
        this.leaderboard = new ArrayList<>();
        this.heroWins = new HashMap<>();
    }

    public void recordBattleResult(String winner, String loser) {
        leaderboard.add(winner + " defeated " + loser);
        heroWins.put(winner, heroWins.getOrDefault(winner, 0) + 1);
    }

    public void recordTeamBattleResult(String winningTeam) {
        leaderboard.add(winningTeam + " won team battle");
    }

    public void showLeaderboard() {
        System.out.println("LEADERBOARD");
        if (leaderboard.isEmpty()) {
            System.out.println("No battles recorded yet.");
        } else {
            for (int i = 0; i < leaderboard.size(); i++) {
                System.out.println((i + 1) + ". " + leaderboard.get(i));
            }
        }
    }

    public void showHeroStatistics() {
        System.out.println("\n HERO STATISTICS");
        if (heroWins.isEmpty()) {
            System.out.println("No hero statistics available.");
        } else {
            heroWins.entrySet().stream()
                    .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                    .forEach(entry ->
                            System.out.println(entry.getKey() + ": " + entry.getValue() + " wins")
                    );
        }
    }

    public void showGameStatistics() {
        System.out.println("\n GAME STATISTICS");
        System.out.println("Total Battles: " + leaderboard.size());
        System.out.println("Heroes Tracked: " + heroWins.size());

        if (!heroWins.isEmpty()) {
            String topHero = heroWins.entrySet().stream()
                    .max(Map.Entry.comparingByValue())
                    .get()
                    .getKey();
            System.out.println("Top Hero: " + topHero + " (" + heroWins.get(topHero) + " wins)");
        }
    }
}
