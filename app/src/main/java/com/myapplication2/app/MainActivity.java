package com.myapplication2.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;

import static android.view.View.INVISIBLE;


public class MainActivity extends Activity {

    private TableLayout tableNewPlayer;
    private Button btnNewPlayer;
    private EditText editTextPlayer1;
    private EditText editTextPlayer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tableNewPlayer = (TableLayout)findViewById(R.id.tableNewPlayer);
        btnNewPlayer = (Button)findViewById(R.id.btnNewPlayer);
        editTextPlayer1 = (EditText) findViewById(R.id.editTextPlayer1);
        editTextPlayer2 = (EditText) findViewById(R.id.editTextPlayer2);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void newPlayer(View view){
        if(tableNewPlayer.getVisibility() == INVISIBLE) {
            tableNewPlayer.setVisibility(View.VISIBLE);
            btnNewPlayer.setText("Delete player");
        }else if(tableNewPlayer.getVisibility() == View.VISIBLE){
            tableNewPlayer.setVisibility(INVISIBLE);
            btnNewPlayer.setText("New player");
        }
    }

    public void goToHomeActivity(View view){
        Intent intent = new Intent(this, HomeActivity.class);
        intent.putExtra("NamePlayer1", editTextPlayer1.getText().toString());
        intent.putExtra("NamePlayer2", editTextPlayer2.getText().toString());
        startActivity(intent);
    }

}
