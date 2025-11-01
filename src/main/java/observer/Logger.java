package observer;

public class Logger implements GameObserver{
    @Override
    public void notify(String event) {
        System.out.println("Logger: "+ event);
    }
}
