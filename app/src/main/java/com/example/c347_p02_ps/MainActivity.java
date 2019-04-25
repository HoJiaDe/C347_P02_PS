package com.example.c347_p02_ps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvCat;
    ArrayList<String> alCat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvCat = this.findViewById(R.id.lvCat);

        alCat = new ArrayList<String>();
        alCat.add("Secular");
        alCat.add("Ethnic & Religion");

        ArrayAdapter<String> aaCat;
        aaCat = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,alCat);

        lvCat.setAdapter(aaCat);

        lvCat.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String category = alCat.get(position);

                Intent i = new Intent(MainActivity.this,Main2Activity.class);
                i.putExtra("category",category);

                startActivity(i);
            }
        });


    }
}
