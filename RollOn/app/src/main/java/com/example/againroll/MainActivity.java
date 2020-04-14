package com.example.againroll;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ImageView img;
    TextView tv,tv2,tv3,ttv2,ttv3,touch;
     int count=0,count2=10,no,defno=10,defno2=0;
    private Random rng = new Random();

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mainmenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.exit:
                MainActivity.super.onBackPressed();
                return true;
            case R.id.about:
                Intent i =new Intent(MainActivity.this,info.class);
                startActivity(i);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = findViewById(R.id.imageView2);
        tv = findViewById(R.id.tv);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);
        ttv2 = findViewById(R.id.textView4);
        ttv3= findViewById(R.id.textView2);
        touch = findViewById(R.id.touch);

        tv2.setText(defno+"");
        tv3.setText(defno2+"");


        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(count2!=0) {
                    touch.setVisibility(View.GONE);
                    onroll();
                    count2--;
                    tv2.setText(count2 + "");
                    tv3.setText(count + "");
                }
                else
                {
                    Intent intent = new Intent(MainActivity.this,Final.class);
                    String valueNew = Integer.toString(count);
                    intent.putExtra("final_val",valueNew);
                    startActivity(intent);
                    MainActivity.this.finish();
                }
            }
        });


    }

    private void onroll()
    {
        no = rng.nextInt(6)+1;
        switch (no)
        {
            case 1:
                img.setImageResource(R.drawable.img1);
                tv.setText(no+"");
                count+=no;
                break;
            case 2:
                img.setImageResource(R.drawable.img2);
                tv.setText(no+"");
                count+=no;

                break;
            case 3:
                img.setImageResource(R.drawable.img3);
                tv.setText(no+"");
                count+=no;
                break;
            case 4:
                img.setImageResource(R.drawable.img4);
                tv.setText(no+"");
                count+=no;
                break;
            case 5:
                img.setImageResource(R.drawable.img5);
                tv.setText(no+"");
                count+=no;
                break;
            case 6:
                img.setImageResource(R.drawable.img6);
                tv.setText(no+"");
                count+=no;
                break;
        }
    }
}
