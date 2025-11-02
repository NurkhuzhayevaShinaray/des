package facade;
import java.util.*;

public class Leaderboard {
    private Map<String, Integer> leaderboard;

    public Leaderboard() {
        this.leaderboard = new HashMap<>();
        initializeLeaderboard();
    }

    private void initializeLeaderboard() {
        String[] defaultHeroes = {"SubZero", "Sindel", "Kano", "Erron Black", "Kitana",
                "Raiden", "Rambo", "Scorpion", "Shang Tsung"};
        for (String hero : defaultHeroes) {
            leaderboard.put(hero, 0);
        }
    }

    public void updateLeaderboard(String heroName) {
        leaderboard.put(heroName, leaderboard.getOrDefault(heroName, 0) + 1);
    }

    public void showLeaderboard() {
        System.out.println("Leaderboard");
        System.out.println("Hero | Wins");

        leaderboard.entrySet().stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .forEach(entry -> {
                    System.out.printf( entry.getKey(), entry.getValue());
                });
    }

    public void addCustomHero(String heroName) {
        if (!leaderboard.containsKey(heroName)) {
            leaderboard.put(heroName, 0);
        }
    }
}