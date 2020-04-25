package com.example.callbeta;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

GridView grid;
MyAdapter myadap;
ArrayList<String> data = new ArrayList<>();
ArrayList<Integer> iconscateg = new ArrayList<>();
ArrayList<Integer> colors = new ArrayList<>();
ArrayList<String> numbers = new ArrayList<>();

private static final int REQUEST_CALL = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        grid = findViewById(R.id.grid);

        myadap = new MyAdapter();


        //data_arraylist data

        data.add("National Emergency Number");
        data.add("Police");
        data.add("Fire");
        data.add("Ambulance");
        data.add("Women Helpline Number");
        data.add("Medical Helpline");
        data.add("Railway Enquiry");
        data.add("Road Accident Emergency");

        numbers.add("112");
        numbers.add("100");
        numbers.add("101");
        numbers.add("102");
        numbers.add("1091");
        numbers.add("108");
        numbers.add("139");
        numbers.add("1073");


        iconscateg.add(R.drawable.nat_emer_no);
        iconscateg.add(R.drawable.police);
        iconscateg.add(R.drawable.fire);
        iconscateg.add(R.drawable.ambulance);
        iconscateg.add(R.drawable.women_helpline_no);
        iconscateg.add(R.drawable.doctor);
        iconscateg.add(R.drawable.railway_enq);
        iconscateg.add(R.drawable.roadaccident);

        colors.add(R.color.colorPrimaryDark);
        colors.add(R.color.oragne);
        colors.add(R.color.pink);

        grid.setAdapter(myadap);

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                makeCall(position);
            }
        });

    }
    class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View v = LayoutInflater.from(getApplicationContext()).inflate(R.layout.categorylayout,null);
            ImageView cateIcon = v.findViewById(R.id.cateIcon);
            TextView cateName = v.findViewById(R.id.cateName);
            int pos = position%colors.size();
            cateIcon.setBackgroundColor(getResources().getColor(colors.get(pos)));
            cateName.setBackgroundColor(getResources().getColor(colors.get(pos)));
            cateName.setText(data.get(position)+"\n"+numbers.get(position));
            cateIcon.setImageResource(iconscateg.get(position));
            return v;
        }
    }


    //Code for making a checking permission and making phone call from the app
    void makeCall(int position)
    {
        String no = numbers.get(position);

        //code for checking permission for making phone calls
        if(no.trim().length() > 0){
            if(ContextCompat.checkSelfPermission(MainActivity.this,
                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){

                //Code for checking manifest permission
                ActivityCompat.requestPermissions(MainActivity.this,
                        new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);

            }else{

                //Code for making call
                String dial =  "tel:" + no;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        }else{
            Toast.makeText(MainActivity.this,"Error!\nNumber no exists",Toast.LENGTH_LONG).show();
        }
    }


    //To check id permission is already granted or not
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == REQUEST_CALL){
            if(grantResults.length > 0 && grantResults[0] ==PackageManager.PERMISSION_GRANTED){
            }else{
                Toast.makeText(MainActivity.this, "Permission Denied", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
