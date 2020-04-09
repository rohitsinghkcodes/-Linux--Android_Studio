package com.example.againroll;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ImageView img,e;
    TextView tv;
    private Random rng = new Random();

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = findViewById(R.id.imageView2);
        e = findViewById(R.id.e);
        tv = findViewById(R.id.tv);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e.setVisibility(View.GONE);
                onroll();
            }
        });


    }

    private void onroll()
    {
        int no = rng.nextInt(6)+1;
        switch (no)
        {
            case 1:
                img.setImageResource(R.drawable.img1);
                tv.setText(no+"");

                break;
            case 2:
                img.setImageResource(R.drawable.img2);
                tv.setText(no+"");
                break;
            case 3:
                img.setImageResource(R.drawable.img3);
                tv.setText(no+"");
                break;
            case 4:
                img.setImageResource(R.drawable.img4);
                tv.setText(no+"");
                break;
            case 5:
                img.setImageResource(R.drawable.img5);
                tv.setText(no+"");
                break;
            case 6:
                img.setImageResource(R.drawable.img6);
                tv.setText(no+"");
                break;
        }
    }
}
