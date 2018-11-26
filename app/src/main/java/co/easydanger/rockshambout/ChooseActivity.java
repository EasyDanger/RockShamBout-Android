package co.easydanger.rockshambout;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.support.design.widget.NavigationView;
import android.widget.TextView;

public class ChooseActivity extends AppCompatActivity {

    private TextView playerPlay;
    private TextView oppPlay;
    private TextView result;
    private Button bartOpp;
    private Button dannyOpp;
    private Button hannahOpp;
    private ConstraintLayout cl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_opp);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        cl = findViewById(R.id.chooselayouttt);
        bartOpp = findViewById(R.id.bartOppButt);
        dannyOpp = findViewById(R.id.dannyOppButt);
        hannahOpp = findViewById(R.id.hannahOppButt);

        playerPlay = findViewById(R.id.playerPlayText);
        oppPlay = findViewById(R.id.oppPlayText);
        result = findViewById(R.id.resultText);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);










        View.OnClickListener listenBart = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(ChooseActivity.this,
                        BartActivity.class);
                startActivity(myIntent);
            }
        };
        bartOpp.setOnClickListener(listenBart);

        View.OnClickListener listenDanny = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(ChooseActivity.this,
                        DannyActivity.class);
                startActivity(myIntent);
            }
        };
        dannyOpp.setOnClickListener(listenDanny);

        View.OnClickListener listenHannah = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(ChooseActivity.this,
                        HannahActivity.class);
                startActivity(myIntent);
            }
        };
        hannahOpp.setOnClickListener(listenHannah);
    }


}
