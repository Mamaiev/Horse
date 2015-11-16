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

    public void start(View view){
        Toast toast1 = Toast.makeText(getApplicationContext(), "Player 1 win!", Toast.LENGTH_LONG);
        Toast toast = Toast.makeText(getApplicationContext(), "wtf", Toast.LENGTH_LONG);
        toast.show();
        int progress = 0;
        int a;
        progressBarPlayer1.setMax(100);
        progressBarPlayer1.setProgress(20);

        while (progress < 100 ){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            a = (int) Math.random()*10;
            progress += progress + a;
            if(progressBarPlayer1.getProgress() < 100 && a < 100 - progressBarPlayer1.getProgress()){
            progressBarPlayer1.setProgress(progress);
            } else
            toast1.show();
              break;

        }
    }
}