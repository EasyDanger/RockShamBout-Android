package co.easydanger.rockshambout;

import java.util.Random;

public final class Danny extends Player {

    String name;
    private static Roshambo strat;
    static Random rand = new Random();

    public static Roshambo generateRoshambo() {
        int x = rand.nextInt(3);
        switch (x) {
            case 1:
                strat = Roshambo.ROCK;
                break;
            case 2:
                strat = Roshambo.PAPER;
                break;
            case 0:
                strat = Roshambo.SCISSORS;
                break;
            default:
                strat = Roshambo.PAPER;
        }
        return strat;
    }

    public Danny(String name) {
        super(name);
    }

    public Roshambo generateRoshambo(Roshambo userPlay) {
        return Roshambo.PAPER;
    };

    public Danny() {

    }
}
