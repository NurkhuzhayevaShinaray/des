package facade;

import bridge.Hero;
import builder.*;
import java.util.ArrayList;
import java.util.List;


class HeroCreationFacade {
    private HeroCreator heroCreator;

    public HeroCreationFacade() {
        this.heroCreator = new HeroCreator();
    }

    public Hero createPlayerHero(String playerName) {
        System.out.println("\n " + playerName + " Hero Choice");
        return heroCreator.createHero(playerName);
    }

    public Hero createAIHero() {
        System.out.println("\n AI Hero choice");
        return heroCreator.createAIHero();
    }

    public List<Hero> createTeam(String teamName, int teamSize) {
        System.out.println("\n Creating " + teamName + " with " + teamSize + " heroes");
        List<Hero> team = new ArrayList<>();
        for (int i = 1; i <= teamSize; i++) {
            team.add(heroCreator.createHero(teamName + " Player " + i));
        }
        return team;
    }

    public Hero createPracticeDummy() {
        IHeroBuilder builder = new Builder();
        Director director = new Director(builder);
        return director.buildTank("Training Dummy");
    }
}
