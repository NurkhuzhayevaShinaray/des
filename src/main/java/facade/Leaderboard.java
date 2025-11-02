package facade;
import java.util.*;

public class Leaderboard {
    private HashMap<String, Integer> leaderboard;

    public Leaderboard() {
        leaderboard = new HashMap<String, Integer>();
        addDefaultHeroes();
    }

    private void addDefaultHeroes() {
        leaderboard.put("SubZero", 0);
        leaderboard.put("Sindel", 0);
        leaderboard.put("Kano", 0);
        leaderboard.put("Erron Black", 0);
        leaderboard.put("Kitana", 0);
        leaderboard.put("Raiden", 0);
        leaderboard.put("Rambo", 0);
        leaderboard.put("Scorpion", 0);
        leaderboard.put("Shang Tsung", 0);
    }

    public void updateLeaderboard(String heroName) {
        boolean heroExists = leaderboard.containsKey(heroName);
        if (heroExists) {
            int currentWins = leaderboard.get(heroName);
            int newWins = currentWins + 1;
            leaderboard.put(heroName, newWins);
        } else {
            leaderboard.put(heroName, 1);
        }
    }

    public void showLeaderboard() {
        System.out.println("Leaderboard");


        String[] allHeroes = leaderboard.keySet().toArray(new String[0]);
        Integer[] allWins = leaderboard.values().toArray(new Integer[0]);

        for (int i = 0; i < allHeroes.length; i++) {
            for (int j = i + 1; j < allHeroes.length; j++) {
                if (allWins[j] > allWins[i]) {
                    String tempHero = allHeroes[i];
                    allHeroes[i] = allHeroes[j];
                    allHeroes[j] = tempHero;

                    // Swap wins
                    int tempWin = allWins[i];
                    allWins[i] = allWins[j];
                    allWins[j] = tempWin;
                }
            }
        }

        for (int i = 0; i < allHeroes.length; i++) {
            System.out.println(allHeroes[i] + " - " + allWins[i] + " wins");
        }
    }

    public void addCustomHero(String heroName) {
        if (leaderboard.containsKey(heroName)) {
            System.out.println("Hero '" + heroName + "' already exists!");
        } else {
            leaderboard.put(heroName, 0);
            System.out.println("Added new hero: " + heroName);
        }
    }
}