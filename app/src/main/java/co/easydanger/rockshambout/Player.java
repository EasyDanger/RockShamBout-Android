package co.easydanger.rockshambout;

//abstract class player will extend into the actual players.
public abstract class Player {

        final String name;

        public Player() {
            name = "player";
        }
        public Player(String name2) {
            name = name2;
        }

        public String getName() {
            return name;
        }

        //Allows the player to select what they will play
        public abstract Roshambo generateRoshambo(Roshambo userPlay);

}
