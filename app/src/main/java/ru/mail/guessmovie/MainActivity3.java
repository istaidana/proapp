package ru.mail.guessmovie;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.*;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity3 extends Activity implements View.OnClickListener{
    Button bt,bt2,bt3,bt4;
    MediaPlayer sound;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity3);
        sound = MediaPlayer.create(this,R.raw.button);
        bt  = (Button)findViewById(R.id.button3);
        bt2  = (Button)findViewById(R.id.button5);
        bt3  = (Button)findViewById(R.id.button4);
        bt4  = (Button)findViewById(R.id.button6);
        bt.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage("Вы уверены?");
        builder.setPositiveButton("Да", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);

            }
        });
        builder.setNegativeButton("Нет",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alert=builder.create();
        alert.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main_activity3, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getApplicationContext(),Videos.class);
        switch (v.getId()){
            case R.id.button3:
                intent = new Intent(getApplicationContext(),Videos.class);
                intent.putExtra("Key","Mults");
                sound.start();
                break;
            case R.id.button5:
                intent = new Intent(getApplicationContext(),Videos.class);
                intent.putExtra("Key","Zarubej");
                sound.start();
                break;
           case R.id.button4:
               intent = new Intent(getApplicationContext(),Videos.class);
                intent.putExtra("Key","Serials");
               sound.start();
               break;
            case R.id.button6:
                intent = new Intent(getApplicationContext(),Videos.class);
                intent.putExtra("Key","Kazakh");
                sound.start();
                break;
        }
        intent.putExtra("ball",0);
        startActivity(intent);
    }
}
