package com.example.timertest_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

public class timer extends AppCompatActivity {

    TextView startCount,finalmsg;
    private CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        //remove action bar
        getSupportActionBar().hide();

        //initialisation
        startCount = findViewById(R.id.startCount);
        finalmsg = findViewById(R.id.finalmsg);

        int val = 4000;
        count(val);
 }

    public void count(final int val)
    {
        countDownTimer = new CountDownTimer(val, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                String currentTime = "" + (millisUntilFinished / 1000);
                startCount.setText(currentTime);
            }

            @Override
            public void onFinish() {
                startCount.setVisibility(View.GONE);
                finalmsg.setVisibility(View.VISIBLE);
            }
        }.start();
    }
}
