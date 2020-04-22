package com.example.cardlist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class detailsckeck extends AppCompatActivity {
TextView init,details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailsckeck);

        init = findViewById(R.id.init);
        details = findViewById(R.id.details);

        Intent intent = getIntent();
        init.setText(intent.getStringExtra("init"));
        details.setText(intent.getStringExtra("detail"));

    }
}
