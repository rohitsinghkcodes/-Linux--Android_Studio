package com.example.bottomnavigatonview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav);
      bottomNav.setOnNavigationItemSelectedListener((navListener));

      getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new homeFragment()).commit();

    }

   private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
       @Override
       public boolean onNavigationItemSelected(@NonNull MenuItem item) {

           Fragment selectedFragment =null;
           switch(item.getItemId())
           {
               case R.id.home:
                   selectedFragment = new homeFragment();
                   break;
               case R.id.fav:
                   selectedFragment = new favFragment();
                   break;
               case R.id.search:
                   selectedFragment = new searchFragment();
                   break;
               default:
                   Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
           }

           getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();
           return true;
       }
   };
}
