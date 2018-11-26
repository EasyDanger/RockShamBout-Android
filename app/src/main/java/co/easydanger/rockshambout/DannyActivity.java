package co.easydanger.rockshambout;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DannyActivity extends AppCompatActivity {

    private TextView playerPlay;
    private TextView oppPlay;
    private TextView result;
    private Button playRock;
    private Button playPaper;
    private Button playSci;
    private ConstraintLayout cl;
    static Roshambo[] roshambo = Roshambo.values();
    static int d = 0;
    static int w = 0;
    static int l = 0;
    static int rockCount = 0;
    static int sciCount = 0;
    static int papCount = 0;
    private TextView rocRecText;
    private TextView papRecText;
    private TextView sciRecText;
    private String opp = "Danny";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_activity_main);

        cl = findViewById(R.id.pLayout);

        playRock = findViewById(R.id.rockPlayButt);
        playPaper = findViewById(R.id.papPlayButt);
        playSci = findViewById(R.id.sciPlayButt);
        playerPlay = findViewById(R.id.playerPlayText);
        oppPlay = findViewById(R.id.oppPlayText);
        oppPlay.setText(opp + "'s play will appear here!");

        result = findViewById(R.id.resultText);
        rocRecText = findViewById(R.id.rocRec);
        papRecText = findViewById(R.id.papRec);
        sciRecText = findViewById(R.id.sciRec);
        result.setText("Record vs. " + opp + " so far ... \n Wins: " + w + ". Losses: " + l + ". Draws: " + d);
        rocRecText.setText("You've played Rock " + rockCount + " times against " + opp + ".");
        sciRecText.setText("You've played Scissors " + sciCount + " times against " + opp + ".");
        papRecText.setText("You've played Paper " + papCount + " times against " + opp + ".");


        View.OnClickListener listenRock = new View.OnClickListener() {
            Roshambo oppThrow;
            Roshambo youThrow = Roshambo.ROCK;

            @Override
            public void onClick(View view) {
                oppThrow = Danny.generateRoshambo();
                playerPlay.setText("You played " + youThrow + ".");
                oppPlay.setText(opp + " played " + oppThrow + ".");
                rockCount++;
                rocRecText.setText("You've played " + youThrow + " " + rockCount + " times against " + opp + ".");

                if (oppThrow == youThrow) {
                    d++;
                    result.setText("You tied. Record against " + opp + " so far ... \n Wins: " + w + ". Losses: " + l + ". Draws: " + d);
                }
                else if (((Vali.enumInArray(roshambo, youThrow) - Vali.enumInArray(roshambo, oppThrow)) == 1)
                        || ((Vali.enumInArray(roshambo, youThrow) - Vali.enumInArray(roshambo, oppThrow)) == (-2))) {
                    w++;
                    result.setText("You WON! Record vs. " + opp + " so far ... \n Wins: " + w + ". Losses: " + l + ". Draws: " + d);
                } else {
                    l++;
                    result.setText("You loss! Record vs. " + opp + " so far ... \n Wins: " + w + ". Losses: " + l + ". Draws: " + d);
                }
            }
        };
        playRock.setOnClickListener(listenRock);


        View.OnClickListener listenPaper = new View.OnClickListener() {
            Roshambo oppThrow;
            Roshambo youThrow = Roshambo.PAPER;

            @Override
            public void onClick(View view) {
                oppThrow = Danny.generateRoshambo();
                playerPlay.setText("You played " + youThrow + ".");
                oppPlay.setText(opp + " played " + oppThrow + ".");
                papCount++;
                papRecText.setText("You've played " + youThrow + " " + papCount + " times against " + opp + ".");

                if (oppThrow == youThrow) {
                    d++;
                    result.setText("You tied. Record against " + opp + " so far ... \n Wins: " + w + ". Losses: " + l + ". Draws: " + d);
                }
                else if (((Vali.enumInArray(roshambo, youThrow) - Vali.enumInArray(roshambo, oppThrow)) == 1)
                        || ((Vali.enumInArray(roshambo, youThrow) - Vali.enumInArray(roshambo, oppThrow)) == (-2))) {
                    w++;
                    result.setText("You WON! Record vs. " + opp + " so far ... \n Wins: " + w + ". Losses: " + l + ". Draws: " + d);
                } else {
                    l++;
                    result.setText("You loss! Record vs. " + opp + " so far ... \n Wins: " + w + ". Losses: " + l + ". Draws: " + d);
                }
            }
        };
        playPaper.setOnClickListener(listenPaper);

        View.OnClickListener listenSci = new View.OnClickListener() {
            Roshambo oppThrow;
            Roshambo youThrow = Roshambo.SCISSORS;

            @Override
            public void onClick(View view) {
                oppThrow = Danny.generateRoshambo();
                playerPlay.setText("You played " + youThrow + ".");
                oppPlay.setText(opp + " played " + oppThrow + ".");
                sciCount++;
                sciRecText.setText("You've played " + youThrow + " " + sciCount + " times against " + opp + ".");

                if (oppThrow == youThrow) {
                    d++;
                    result.setText("You tied. Record against " + opp + " so far ... \n Wins: " + w + ". Losses: " + l + ". Draws: " + d);
                }
                else if (((Vali.enumInArray(roshambo, youThrow) - Vali.enumInArray(roshambo, oppThrow)) == 1)
                        || ((Vali.enumInArray(roshambo, youThrow) - Vali.enumInArray(roshambo, oppThrow)) == (-2))) {
                    w++;
                    result.setText("You WON! Record vs. " + opp + " so far ... \n Wins: " + w + ". Losses: " + l + ". Draws: " + d);
                } else {
                    l++;
                    result.setText("You loss! Record vs. " + opp + " so far ... \n Wins: " + w + ". Losses: " + l + ". Draws: " + d);
                }
            }
        };
        playSci.setOnClickListener(listenSci);
    }
}
