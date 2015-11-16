package com.myapplication2.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class HomeActivity extends Activity {

    ProgressBar progressBarPlayer1;
    ProgressBar progressBarPlayer2;
    Button btnStart;

    private TextView txtViewPlayer1ActivityHome;
    private TextView txtViewPlayer2ActivityHome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        txtViewPlayer1ActivityHome = (TextView)findViewById(R.id.txtViewPlayer1ActivityHome);
        txtViewPlayer2ActivityHome = (TextView)findViewById(R.id.txtViewPlayer2ActivityHome);

        txtViewPlayer1ActivityHome.setText(getIntent().getStringExtra("NamePlayer1"));
        txtViewPlayer2ActivityHome.setText(getIntent().getStringExtra("NamePlayer2"));

        progressBarPlayer1 = (ProgressBar) findViewById(R.id.progressBarPlayer1);
        progressBarPlayer2 = (ProgressBar) findViewById(R.id.progressBarPlayer2);
    }

    public void startPlayer1(View view){
        Toast toast1 = Toast.makeText(getApplicationContext(), "Player 1 win!", Toast.LENGTH_LONG);
        Toast toast2 = Toast.makeText(getApplicationContext(), "Player 2 win!", Toast.LENGTH_LONG);
        int progress = 0;
        int progress2 = 0;
        int a, b;
        while (progress < 100 || progress2 < 100){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            a = (int) Math.random()*10;
            b = (int) Math.random()*10;
            progress += progress + a;
            progress2 += progress2 + b;

            if(progressBarPlayer1.getProgress() < 100 && a < 100 - progressBarPlayer1.getProgress()){
            progressBarPlayer1.setProgress(progress);
            } else
            toast1.show();
//              break;

            if(progressBarPlayer2.getProgress() < 100 && a < 100 - progressBarPlayer2.getProgress()) {
                progressBarPlayer2.setProgress(progress2);
            }
            else
            toast2.show();
                break;

        }
    }
}