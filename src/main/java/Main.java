import facade.GameManager;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting Mortal Kombat Game...");

        GameManager gameManager = new GameManager();
        gameManager.startGame();
    }
}