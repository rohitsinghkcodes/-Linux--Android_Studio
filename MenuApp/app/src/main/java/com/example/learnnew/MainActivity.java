package com.example.learnnew;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater =getMenuInflater();
        inflater.inflate(R.menu.example_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
//            case R.id.setting:
//                Toast.makeText(this, "Setting selected", Toast.LENGTH_SHORT).show();
//                return true;
            case R.id.contact:
//                Toast.makeText(this, "Contact Us option selected", Toast.LENGTH_LONG).show();
                Intent i =new Intent(MainActivity.this,Contact.class);
                startActivity(i);
                return true;
            case R.id.Exit:
                //Toast.makeText(this, "Exit option selected", Toast.LENGTH_LONG).show();
                MainActivity.super.onBackPressed();
            default:
            return super.onOptionsItemSelected(item);
        }
    }
}
