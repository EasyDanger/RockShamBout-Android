package co.easydanger.rockshambout;

public enum Roshambo {

    ROCK, PAPER, SCISSORS;

    public String toString() {
        if (this == ROCK) {
            return "Rock";
        } else if (this == SCISSORS) {
            return "Scissors";
        } else {
            return "Paper";
        }
    }
}
