package com.example.android.courtcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int scoreTeamA = 0;
    private int scoreTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Increase the score for Team A by 1 point.
     */
    public void addForTeamA(View v) {
        this.scoreTeamA += Integer.parseInt(v.getTag().toString());
        displayForTeamA();
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA() {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(this.scoreTeamA));
    }

    /**
     * Increase the score for Team B by 1 point.
     */
    public void addForTeamB(View v) {
        this.scoreTeamA += Integer.parseInt(v.getTag().toString());
        displayForTeamB();
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB() {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(this.scoreTeamA));
    }

    public void resetScore(View v) {
        this.scoreTeamA = 0;
        this.scoreTeamB = 0;
        this.displayForTeamA();
        this.displayForTeamB();
    }
}