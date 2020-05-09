package com.example.timertest_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private long backPressedTime;
    Button startbtn;
    EditText input;
    private Toast backToast;
    @Override
    public void onBackPressed() {
        if(backPressedTime + 2000 > System.currentTimeMillis() )
        {
            backToast.cancel();
            super.onBackPressed();
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
        setContentView(R.layout.activity_main);

        //remove action bar
        getSupportActionBar().hide();

        //initialisation
        startbtn = findViewById(R.id.startbtn);
        input = findViewById(R.id.input);



        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,timer.class);

                //To get the value of input time
                String i= input.getText().toString();
                if(i.length()==0 || i.equals("0"))
                {
                    Toast.makeText(MainActivity.this, "give some input", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    //long millisInput = Long.parseLong(i)*60000;
                    intent.putExtra("time",i);
                    startActivity(intent);
                    finish();
                }

            }
        });
    }
}
