package co.easydanger.rockshambout;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView playerPlay;
    private TextView oppPlay;
    private TextView result;
    private Button playRock;
    private Button playPaper;
    private Button playSci;
    private ConstraintLayout rl;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.danny_activity_main);

        rl = findViewById(R.id.dannylayouttt);

        playRock = findViewById(R.id.rockPlayButt);
        playPaper = findViewById(R.id.papPlayButt);
        playSci = findViewById(R.id.sciPlayButt);
        playerPlay = findViewById(R.id.playerPlayText);
        oppPlay = findViewById(R.id.oppPlayText);
        result = findViewById(R.id.resultText);
        rocRecText = findViewById(R.id.rocRec);
        papRecText = findViewById(R.id.papRec);
        sciRecText = findViewById(R.id.sciRec);



        View.OnClickListener listenRock = new View.OnClickListener() {
            Roshambo dannyThrow;
            Roshambo youThrow = Roshambo.ROCK;

            @Override
            public void onClick(View view) {
                dannyThrow = Danny.generateRoshambo();
                playerPlay.setText("You played " + youThrow + ".");
                oppPlay.setText("Danny played " + dannyThrow + ".");
                rockCount++;
                rocRecText.setText("You've played Rock " + rockCount + " times.");


                if (dannyThrow == youThrow) {
                    d++;
                    result.setText("You tied. Record so far ... \n Wins: " + w + ". Losses: " + l + ". Draws: " + d);
                }
                // this renders each element of the Roshambo Enum to a number in the array.
                // since they are sequential, a user winning play will always have an index that
                // is one more than the opponent's or -2 if the user chooses the 0 index item,
                // since there are three options. Pretty proud of this one.
                else if (((Vali.enumInArray(roshambo, youThrow) - Vali.enumInArray(roshambo, dannyThrow)) == 1)
                        || ((Vali.enumInArray(roshambo, youThrow) - Vali.enumInArray(roshambo, dannyThrow)) == (-2))) {
                    w++;
                    result.setText("You WON! Record so far ... \n Wins: " + w + ". Losses: " + l + ". Draws: " + d);
                } else {
                    l++;
                    result.setText("You loss! Record so far ... \n Wins: " + w + ". Losses: " + l + ". Draws: " + d);
                }
            }
        };
        playRock.setOnClickListener(listenRock);


        View.OnClickListener listenPaper = new View.OnClickListener() {
            Roshambo dannyThrow;
            Roshambo youThrow = Roshambo.PAPER;

            @Override
            public void onClick(View view) {
                dannyThrow = Danny.generateRoshambo();
                playerPlay.setText("You played " + youThrow + ".");
                oppPlay.setText("Danny played " + dannyThrow + ".");
                papCount++;
                papRecText.setText("You've played Paper " + papCount + " times.");

                if (dannyThrow == youThrow) {
                    d++;
                    result.setText("You tied. Record so far ... \n Wins: " + w + ". Losses: " + l + ". Draws: " + d);
                }
                // this renders each element of the Roshambo Enum to a number in the array.
                // since they are sequential, a user winning play will always have an index that
                // is one more than the opponent's or -2 if the user chooses the 0 index item,
                // since there are three options. Pretty proud of this one.
                else if (((Vali.enumInArray(roshambo, youThrow) - Vali.enumInArray(roshambo, dannyThrow)) == 1)
                        || ((Vali.enumInArray(roshambo, youThrow) - Vali.enumInArray(roshambo, dannyThrow)) == (-2))) {
                    w++;
                    result.setText("You WON! Record so far ... \n Wins: " + w + ". Losses: " + l + ". Draws: " + d);
                } else {
                    l++;
                    result.setText("You loss! Record so far ... \n Wins: " + w + ". Losses: " + l + ". Draws: " + d);
                }
            }
        };
        playPaper.setOnClickListener(listenPaper);

        View.OnClickListener listenSci = new View.OnClickListener() {
            Roshambo dannyThrow;
            Roshambo youThrow = Roshambo.SCISSORS;

            @Override
            public void onClick(View view) {
                dannyThrow = Danny.generateRoshambo();
                playerPlay.setText("You played " + youThrow + ".");
                oppPlay.setText("Danny played " + dannyThrow + ".");
                sciCount++;
                sciRecText.setText("You've played Scissors " + sciCount + " times.");

                if (dannyThrow == youThrow) {
                    d++;
                    result.setText("You tied. Record so far ... \n Wins: " + w + ". Losses: " + l + ". Draws: " + d);
                }
                // this renders each element of the Roshambo Enum to a number in the array.
                // since they are sequential, a user winning play will always have an index that
                // is one more than the opponent's or -2 if the user chooses the 0 index item,
                // since there are three options. Pretty proud of this one.
                else if (((Vali.enumInArray(roshambo, youThrow) - Vali.enumInArray(roshambo, dannyThrow)) == 1)
                        || ((Vali.enumInArray(roshambo, youThrow) - Vali.enumInArray(roshambo, dannyThrow)) == (-2))) {
                    w++;
                    result.setText("You WON! Record so far ... \n Wins: " + w + ". Losses: " + l + ". Draws: " + d);
                } else {
                    l++;
                    result.setText("You loss! Record so far ... \n Wins: " + w + ". Losses: " + l + ". Draws: " + d);
                }
            }
        };
        playSci.setOnClickListener(listenSci);
    }
}
