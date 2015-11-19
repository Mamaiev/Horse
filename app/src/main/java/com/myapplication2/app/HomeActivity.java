package com.myapplication2.app;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends Activity {

    private ProgressBar progressBarPlayer1;
    private ProgressBar progressBarPlayer2;
    private TextView txtViewPlayer1ActivityHome;
    private TextView txtViewPlayer2ActivityHome;
    private Button btnRestart;

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
        Toast toastPlayer1Win = Toast.makeText(HomeActivity.this, txtViewPlayer1ActivityHome.getText(), Toast.LENGTH_SHORT);  //  maybe  txtViewPlayer1ActivityHome.toString()
        Toast toastPlayer2Win = Toast.makeText(HomeActivity.this, txtViewPlayer2ActivityHome.getText(), Toast.LENGTH_SHORT);  //  maybe  txtViewPlayer2ActivityHome.toString()

        @Override
        protected Void doInBackground(Void... params) {
            while (true) {
                SystemClock.sleep(500);
                if (progress1 < 100 && progress2 < 100) {
                    progress1++;                            // progress += progress1 + (int)Math.random()*20;
                    progress1++;
                    progress2++;
                    publishProgress(progress1);
                    if(progress1 >= 100){
                        toastPlayer1Win.show();
                        break;
                    }else {
                        publishProgress(progress2);
                        if(progress2 >= 100)
                            toastPlayer2Win.show();
                        break;
                    }
                }
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast toast = Toast.makeText(HomeActivity.this, "GO !!!", Toast.LENGTH_SHORT);
            toast.show();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressBarPlayer1.setProgress(progress1);                 //  maybe  (progress1 or value[0])
            progressBarPlayer2.setProgress(progress2);
        }
    }

    public void start(View view){
       new play().execute();
        }

    public void restart(View view){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("NamePlayer1", txtViewPlayer1ActivityHome.getText().toString());        //  ак передать в MainActivity и записать их, но не сбить то что есть на MainActivity(≈сли переход от сюда, то изменить имена пользвователей так как они сто€т в HomeActivity, если первых вход в  MainActivity то имена по умолчанию)
        intent.putExtra("NamePlayer2", txtViewPlayer2ActivityHome.getText().toString());
        startActivity(intent);
    }
    }
