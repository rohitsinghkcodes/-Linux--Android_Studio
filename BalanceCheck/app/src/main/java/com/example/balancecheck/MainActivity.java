package com.example.balancecheck;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView name,AccNo,Bal,tv1,tv2,tv3;
    Button detailsBtn,balBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (TextView)findViewById(R.id.name);
        AccNo = (TextView)findViewById(R.id.AccNo);
        Bal = (TextView)findViewById(R.id.Bal);
        tv1 = (TextView)findViewById(R.id.tv1);
        tv2 = (TextView)findViewById(R.id.tv2);
        tv3 = (TextView)findViewById(R.id.tv3);

        detailsBtn = (Button) findViewById(R.id.detailsBtn);
        balBtn = (Button)findViewById(R.id.balBtn);

        name.setVisibility(View.GONE);
        AccNo.setVisibility(View.GONE);
        tv1.setVisibility(View.GONE);
        tv2.setVisibility(View.GONE);
        tv3.setVisibility(View.GONE);



        detailsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name.setText("Rohit Singh");
                AccNo.setText("5836XXXXXX");
                tv1.setVisibility(View.VISIBLE);
                tv2.setVisibility(View.VISIBLE);
                name.setVisibility(View.VISIBLE);
                AccNo.setVisibility(View.VISIBLE);
            }
        });


       balBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.activity_log_in,null);

               final EditText email = (EditText) view.findViewById(R.id.email) ;
               final EditText password = (EditText) view.findViewById(R.id.password);

               AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

               builder.setMessage("Login Here")
                       .setView(view)
                       .setPositiveButton("Login", new DialogInterface.OnClickListener() {
                           @Override
                           public void onClick(DialogInterface dialog, int which) {
                               String u = email.getText().toString();
                               String p = password.getText().toString();

                               if(u.equals("rohitkmails@gmail.com") && p.equals("123456"))
                               {
                                   Bal.setText("5000");
                                   tv3.setVisibility(View.VISIBLE);
                               }
                               else
                               {
                                   Bal.setText(null);
                                   tv3.setVisibility(View.GONE);
                                   Toast.makeText(MainActivity.this, "Error!\nWrong email or password", Toast.LENGTH_SHORT).show();
                               }
                           }
                       }).setNegativeButton("Cancel",null).setCancelable(false);

               AlertDialog alert = builder.create();
               alert.show();
           }
       });

    }

    @Override
    public void onBackPressed() {


        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        builder.setTitle("Exit!")
                .setMessage("Are you sure you want to exit?\nPress Ok to exit")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MainActivity.super.onBackPressed();
                    }
                }).setNegativeButton("Cancel",null).setCancelable(false);

        AlertDialog alert = builder.create();
        alert.show();
    }

    {
    }

}
