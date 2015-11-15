package com.myapplication2.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

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

    }


    public void start(View view){
        int progress = 0;
        Random random = new Random();
        while (progress < 100){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (progressBarPlayer1.getProgress() <= 100) {
                progressBarPlayer1.setProgress((int) Math.random() * 44);
            }else
                break;
        }
    }



}
