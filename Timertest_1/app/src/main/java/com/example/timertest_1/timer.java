package com.example.timertest_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Thread.sleep;

public class timer extends AppCompatActivity {

    TextView startCount,countDown;
    private CountDownTimer countDownTimer;
    private long timeLeftInMillis ,backPressedTime;
    private boolean timeRunning;
    private SoundPool soundPool;
    private int tickSound,finalSound;
    Button finalBtn;
    private Toast backToast;


    @Override
    public void onBackPressed() {
        if(backPressedTime + 2000 > System.currentTimeMillis() )
        {
            backToast.cancel();
            timer.super.onBackPressed();
            return;
        }
        else
        {
           backToast = Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT);
           backToast.show();
        }
        backPressedTime = System.currentTimeMillis();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        //remove action bar
        getSupportActionBar().hide();

        //initialisation
        startCount = findViewById(R.id.startCount);
        countDown = findViewById(R.id.countDown);
        finalBtn = findViewById(R.id.finalbtn);

        //fetching input time
        Intent intent = getIntent();
        String newVal = intent.getStringExtra("time");
        timeLeftInMillis = Long.parseLong(newVal)*60000;



        //For tick sound on time change
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {
            AudioAttributes audioAttributes = new AudioAttributes.Builder().setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION).build();

            soundPool = new SoundPool.Builder().setAudioAttributes(audioAttributes).build();
        }
        else
        {
            soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC,0);
        }

        tickSound = soundPool.load(this,R.raw.tick,1);
        finalSound = soundPool.load(this,R.raw.final_sound,1);




        //For start timer
            countDownTimer = new CountDownTimer(4000, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    String currentTime = "" + (millisUntilFinished / 1000);
                    startCount.setText(currentTime);
                }

                @Override
                public void onFinish() {
                    startCount.setVisibility(View.GONE);
                    countDown.setVisibility(View.VISIBLE);

                    //CountDown timer
                    startTimer();
                }
            }.start();

            updateTimer();

        finalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onStopSound();
                Intent m = new Intent(timer.this,MainActivity.class);
                startActivity(m);
            }
        });

        }



        public void startTimer()
        {
            countDownTimer = new CountDownTimer(timeLeftInMillis+1000,1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    timeLeftInMillis = millisUntilFinished;
                    updateTimer();
                }

                @Override
                public void onFinish() {
                    soundPool.play(finalSound,1,1,1,-1,0);
                    countDown.setVisibility(View.GONE);
                    finalBtn.setVisibility(View.VISIBLE);
                }
            }.start();

        }

        public void updateTimer()
        {
            soundPool.play(tickSound,1,1,0,0,1);
            int minutes = (int)timeLeftInMillis/60000;
            int seconds = (int)(timeLeftInMillis%60000)/1000;

            String LeftTime = "";

            if(minutes<10)
            {
                LeftTime+="0";
            }
            LeftTime += minutes;
            LeftTime += ":";
            if(seconds<10)
            {
                LeftTime += "0";
            }
            LeftTime += seconds;

            countDown.setText(LeftTime);
        }

        public void onStopSound()
        {
            soundPool.release();
            soundPool= null;
        }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        soundPool.release();
        soundPool= null;
    }

}
