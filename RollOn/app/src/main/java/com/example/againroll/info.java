package com.example.againroll;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class info extends AppCompatActivity {
TextView tv7;
String copyright;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        tv7 = findViewById(R.id.textView7);

        copyright = "\u00a9 ROHIT KUMAR SINGH";
        tv7.setText(copyright);
    }
}
