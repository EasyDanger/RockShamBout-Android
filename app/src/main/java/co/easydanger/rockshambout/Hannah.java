package co.easydanger.rockshambout;

public class Hannah extends Player {

    String name;
    private static Roshambo last;
    private static Roshambo strat;
    private static int wins = 0;
    private static int draw = 0;

    @Override
    public Roshambo generateRoshambo(Roshambo userPlay) {
        return null;
    }

    public static Roshambo generateRoshambo(Roshambo userPlay, int playerWin, int draws) {

        if (last == null) {
            strat = Danny.generateRoshambo();
        } else {
            if (draws > draw) {
                last = null;
                draw = draws;
                wins = playerWin;
                return Danny.generateRoshambo();
            } else if (playerWin > wins) {
                if (last == Roshambo.ROCK) {
                    strat = Roshambo.PAPER;
                } else if (last == Roshambo.PAPER) {
                    strat = Roshambo.SCISSORS;
                } else {
                    strat = Roshambo.ROCK;
                }
            } else {
                strat = last;
            }
        }
        draw = draws;
        wins = playerWin;
        last = userPlay;
        return strat;
    }
}
