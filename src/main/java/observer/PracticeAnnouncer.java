package observer;

public class PracticeAnnouncer implements GameObserver{
    @Override
    public void notify(String event) {
        System.out.println("Practice announcer: "+ event);
        if (event.contains("damage")){
            System.out.println("You should change your attack strategy!");
        }
        else if (event.contains("defeated")){
            System.out.println("Keep trying and practice again!");
        };
    }
}
