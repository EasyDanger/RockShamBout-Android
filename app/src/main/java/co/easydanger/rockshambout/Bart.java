package co.easydanger.rockshambout;

import android.widget.Button;
import android.widget.RelativeLayout;

public final class Bart extends Player {


    String name;
    private static Roshambo fir;
    private static Roshambo sec;
    private static Roshambo thi;
    private static Roshambo fou;
    private static Roshambo fif;
    private static Roshambo six;
    private static Roshambo sev;
    private Button goBartOpp;
    private RelativeLayout rl;

    @Override
    public Roshambo generateRoshambo(Roshambo userPlay) {
        return Roshambo.ROCK;
    }

    public Bart(String name) {
        super(name);
    }

    public Bart() {

    }
}
