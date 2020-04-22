package com.example.cardlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView list;
    ListAdap myAdapter;
    ArrayList<String> data = new ArrayList<>();
    ArrayList<Integer> colors = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = findViewById(R.id.list);
        myAdapter = new ListAdap();

        list.setAdapter(myAdapter);

        data.add("ROHIT SINGH");
        data.add("RITU SINGH");
        data.add("SANJU SINGH");
        data.add("AKASH SINGH");
        data.add("SHIVAM GUGLANI");
        data.add("RAHUL RAJ");
        data.add("ANAND SINGH");
        data.add("ANKIT SINGH");
        data.add("MOHD. RAZA");
        data.add("AMBUJ SINGH");
        data.add("ARSHARAJ CHAUHAN");


        colors.add(R.color.PinkCard);
        colors.add(R.color.OrangeCard);
        colors.add(R.color.greenCard);
        colors.add(R.color.PinkCard);
        colors.add(R.color.OrangeCard);
        colors.add(R.color.greenCard);;
        colors.add(R.color.PinkCard);
        colors.add(R.color.OrangeCard);
        colors.add(R.color.greenCard);
        colors.add(R.color.PinkCard);
        colors.add(R.color.OrangeCard);


    }

    class ListAdap extends BaseAdapter {

        @Override
        //count the list items
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
            View v = LayoutInflater.from(getApplicationContext()).inflate(R.layout.itemlayout, null);
            TextView initial = v.findViewById(R.id.initial);
            TextView name = v.findViewById(R.id.name);
            initial.setBackgroundColor(getResources().getColor(colors.get(position)));
            name.setBackgroundColor(getResources().getColor(colors.get(position)));

            initial.setText(data.get(position).charAt(0) + "");
            name.setText(data.get(position));

            return v;
        }
    }
}
