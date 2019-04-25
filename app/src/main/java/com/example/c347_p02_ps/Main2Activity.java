package com.example.c347_p02_ps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    ListView lvHolidays;
    TextView tv;
    ArrayAdapter aaHoliday;
    ArrayList<Holiday> alHoliday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tv = findViewById(R.id.textViewHoliday);
        lvHolidays = findViewById(R.id.lvHoliday);

        Intent i = getIntent();
        String category = i.getStringExtra("category");
        tv.setText(category);

        // Create a few food objects in Food array
        alHoliday = new ArrayList<Holiday>();

        if (category.equals("Secular")){
            alHoliday.add(new Holiday("New Year's Day", "1 Jan 2019"));
            alHoliday.add(new Holiday("Labour Day", "1 May 2019"));
        }else {
            alHoliday.add(new Holiday("Chinese New Year", "5-6 Feb 2019"));
            alHoliday.add(new Holiday("Good Friday", "19 April 2019"));
            alHoliday.add(new Holiday("Hari Raya Puasa", "5 June 2019"));
            alHoliday.add(new Holiday("Deepavali", "27 October 2019"));
        }


        lvHolidays.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Holiday selected = alHoliday.get(position);

                Toast.makeText(Main2Activity.this, selected.getTitle()
                                + " Date: " + selected.getDate(),
                        Toast.LENGTH_LONG).show();
            }
        });


        // Link this Activity object, the row.xml layout for
        //  each row and the food String array together
        aaHoliday = new HolidayAdapter(this, R.layout.row, alHoliday);
        lvHolidays.setAdapter(aaHoliday);
    }
}
