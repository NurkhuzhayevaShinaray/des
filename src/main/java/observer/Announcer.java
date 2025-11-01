package observer;

public class Announcer implements GameObserver{
    @Override
    public void notify(String event) {
        System.out.println("Announcer: " + event);
    }
}
