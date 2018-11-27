package co.easydanger.rockshambout;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class BartActivity extends ChooseActivity {

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
    private String opp = "Bart";


    private TextView bart;
    private TextView danny;
    private TextView hannah;
    private Button bartOpp;
    private Button dannyOpp;
    private Button hannahOpp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        cl = findViewById(R.id.chooselayouttt);


        bartOpp = findViewById(R.id.bartOppButt);
        dannyOpp = findViewById(R.id.dannyOppButt);
        hannahOpp = findViewById(R.id.hannahOppButt);
        bart = findViewById(R.id.bartDesc);
        danny = findViewById(R.id.dannyDesc);
        hannah = findViewById(R.id.hannahDesc);

        bartOpp.setVisibility(View.GONE);
        dannyOpp.setVisibility(View.GONE);
        hannahOpp.setVisibility(View.GONE);
        bart.setVisibility(View.GONE);
        danny.setVisibility(View.GONE);
        hannah.setVisibility(View.GONE);



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

        playRock.setBackgroundColor(getResources().getColor(R.color.colorAccent2));
        playPaper.setBackgroundColor(getResources().getColor(R.color.colorAccent2));
        playSci.setBackgroundColor(getResources().getColor(R.color.colorAccent2));
        result.setText("Record vs. " + opp + " so far ... \n Wins: " + w + ". Losses: " + l + ". Draws: " + d);
        rocRecText.setText("You've played Rock " + rockCount + " times against " + opp + ".");
        sciRecText.setText("You've played Scissors " + sciCount + " times against " + opp + ".");
        papRecText.setText("You've played Paper " + papCount + " times against " + opp + ".");

        DrawerLayout drawer = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView =  findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View.OnClickListener listenRock = new View.OnClickListener() {
            Roshambo oppThrow;
            Roshambo youThrow = Roshambo.ROCK;

            @Override
            public void onClick(View view) {
                oppThrow = Bart.generateRoshambo();
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

        View.OnLongClickListener longRock = new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                rockCount = 0;
                rocRecText.setText("You've reset the count of Rock plays!");
                return true;
            }
        };
        playRock.setOnLongClickListener(longRock);

        View.OnLongClickListener longResult = new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                w = 0;
                l = 0;
                d = 0;
                result.setText("You've reset the results for " + opp + "!");
                return true;
            }
        };
        result.setOnLongClickListener(longResult);


        View.OnClickListener listenPaper = new View.OnClickListener() {
            Roshambo oppThrow;
            Roshambo youThrow = Roshambo.PAPER;

            @Override
            public void onClick(View view) {
                oppThrow = Bart.generateRoshambo();
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

        View.OnLongClickListener longPap = new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                papCount = 0;
                papRecText.setText("You've reset the count of Paper plays!");
                return true;
            }
        };
        playPaper.setOnLongClickListener(longPap);

        View.OnClickListener listenSci = new View.OnClickListener() {
            Roshambo oppThrow;
            Roshambo youThrow = Roshambo.SCISSORS;

            @Override
            public void onClick(View view) {
                oppThrow = Bart.generateRoshambo();
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

        View.OnLongClickListener longSci = new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                sciCount = 0;
                sciRecText.setText("You've reset the count of Scissors plays!");
                return true;
            }
        };
        playSci.setOnLongClickListener(longSci);
    }
}
