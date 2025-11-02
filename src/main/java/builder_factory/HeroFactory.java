package builder_factory;
import bridge.*;

public class HeroFactory{
    public static Hero createHero(String heroName, HeroType heroType){
        switch (heroName.toLowerCase()) {
            case "subzero":
                return new SubZero(heroType);
            case "scorpion":
                return new Scorpion(heroType);
            case "sindel":
                return new Sindel(heroType);
            case "erron black":
                return new ErronBlack(heroType);
            case "kano":
                return new Kano(heroType);
            case "kitana":
                return new Kitana(heroType);
            case "raiden":
                return new Raiden(heroType);
            case "rambo":
                return new Rambo(heroType);
            case "shang tsung":
                return new ShangTsung(heroType);
            default: return new CustomizedHero(heroName, heroType);
        }
    }
}