package co.easydanger.rockshambout;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ChooseActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    private TextView bart;
    private TextView danny;
    private TextView hannah;
    private Button bartOpp;
    private Button dannyOpp;
    private Button hannahOpp;
    private ConstraintLayout cl;



    private TextView playerPlay;
    private TextView oppPlay;
    private TextView result;
    private Button playRock;
    private Button playPaper;
    private Button playSci;
    private TextView rocRecText;
    private TextView papRecText;
    private TextView sciRecText;


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


        playRock = findViewById(R.id.rockPlayButt);
        playPaper = findViewById(R.id.papPlayButt);
        playSci = findViewById(R.id.sciPlayButt);
        playerPlay = findViewById(R.id.playerPlayText);
        oppPlay = findViewById(R.id.oppPlayText);
        result = findViewById(R.id.resultText);
        rocRecText = findViewById(R.id.rocRec);
        papRecText = findViewById(R.id.papRec);
        sciRecText = findViewById(R.id.sciRec);

        oppPlay.setVisibility(View.GONE);
        playRock.setVisibility(View.GONE);
        playPaper.setVisibility(View.GONE);
        playSci.setVisibility(View.GONE);
        playerPlay.setVisibility(View.GONE);
        result.setVisibility(View.GONE);
        rocRecText.setVisibility(View.GONE);
        papRecText.setVisibility(View.GONE);
        sciRecText.setVisibility(View.GONE);


        DrawerLayout drawer = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView =  findViewById(R.id.nav_view);
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

    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            Intent myIntent = new Intent(ChooseActivity.this,
                    BartActivity.class);
            startActivity(myIntent);
        } else if (id == R.id.nav_gallery) {
            Intent myIntent = new Intent(ChooseActivity.this,
                    DannyActivity.class);
            startActivity(myIntent);
        } else if (id == R.id.nav_slideshow) {
            Intent myIntent = new Intent(ChooseActivity.this,
                    HannahActivity.class);
            startActivity(myIntent);
        } else if (id == R.id.nav_manage) {
            Intent myIntent = new Intent(ChooseActivity.this,
                    ChooseActivity.class);
            startActivity(myIntent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
