package com.example.againroll;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Final extends AppCompatActivity {
    TextView ans;
    Button resetbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        resetbtn = findViewById(R.id.resetbtn);

        Intent intent = getIntent();
        String sname = intent.getStringExtra("final_val");
        //int sname =intent.getIntExtra("final_val",0);
        ans =findViewById(R.id.ans);
        ans.setText(sname);

        resetbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent m = new Intent(Final.this,MainActivity.class);
                startActivity(m);
            }
        });

    }
}
