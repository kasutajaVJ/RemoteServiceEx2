package com.example.vanessa.remoteserviceex2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static Random rand = new Random();
    private Intent intent = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intent = new Intent(this, TheService.class);
        startService(intent);
    }

    public void onColorChange(View view) {
        getWindow().getDecorView().setBackgroundColor(getColor());
    }

    public void onMessage(View view) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                sendMessage();
            }
        }, 5000);
    }

    private int getColor() {
        return Color.rgb(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
    }

    public void sendMessage() {
        if (intent != null) {
            @SuppressLint("SimpleDateFormat") DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
            Date today = Calendar.getInstance().getTime();
            Toast.makeText(getApplicationContext(), df.format(today), Toast.LENGTH_LONG).show();
        }
    }
}
