package com.myapplication2.app;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class HomeActivity extends Activity {

    private ProgressBar progressBarPlayer1;
    private ProgressBar progressBarPlayer2;
    private Button btnStart;

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


    class play extends AsyncTask<Void, Integer, Void>{

        private int progress1 = 0;
        private int progress2 = 0;

        @Override
        protected Void doInBackground(Void... params) {
            while (true) {
                if (progress1 < 100 && progress2 < 100) {
                    progress1++;
                    progress2++;
                    publishProgress(progress1);
                    publishProgress(progress2);
                    SystemClock.sleep(1000);
                } else {
                    break;
                }
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(HomeActivity.this, "Run", Toast.LENGTH_LONG);
            System.out.println("0000000000000000000000000000000000000000000000000000000000000000000000000000000");

        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Toast.makeText(HomeActivity.this, "END", Toast.LENGTH_SHORT);
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressBarPlayer1.setProgress(values[0]);
            progressBarPlayer2.setProgress(progress2);
        }
    }

    public void start(View view){
       new play().execute();
        }
    }
