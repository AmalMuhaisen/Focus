package com.example.focus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Chronometer chronometer;
    private long stopOffset;
    private Boolean running = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chronometer = findViewById(R.id.chronometer);
        //chronometer.setFormat("Time = %s");
        chronometer.setBase(SystemClock.elapsedRealtime());
        //chronometer.setCountDown();
        /*chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                if ((SystemClock.elapsedRealtime() - chronometer.getBase()) >=1000){
                    chronometer.setBase(SystemClock.elapsedRealtime());
                    Toast.makeText(MainActivity.this, "Bing!", Toast.LENGTH_SHORT).show();
                }
            }
        }); */

    }

    public void startChronometer(View v) {

       // Toast.makeText(MainActivity.this,running+"",Toast.LENGTH_LONG).show();
        if( ! running ){
           chronometer.setBase(SystemClock.elapsedRealtime() - stopOffset);
           chronometer.start();
           running = true;
        }

    }

    public void stopChronometer(View v) {
        if(!running){
            chronometer.stop();
            stopOffset = SystemClock.elapsedRealtime() - chronometer.getBase();
            running = false;
        }

    }

    public void resetChronometer(View v) {
        chronometer.setBase(SystemClock.elapsedRealtime());
        stopOffset = 0;

    }
}