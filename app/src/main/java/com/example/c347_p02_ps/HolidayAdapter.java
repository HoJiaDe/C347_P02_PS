package com.example.c347_p02_ps;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class HolidayAdapter extends ArrayAdapter {

    private ArrayList<Holiday> alHoliday;
    private Context context;
    private TextView tvTitle;
    private TextView tvDate;
    private ImageView iv;

    public HolidayAdapter(Context context, int resource, ArrayList<Holiday> objects){
        super(context, resource, objects);
        // Store the food that is passed to this adapter
        alHoliday = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }

    // getView() is the method ListView will call to get the
    //  View object every time ListView needs a row
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.row, parent, false);

        // Get the TextView object
        tvTitle =         rowView.findViewById(R.id.tvTitle);
        tvDate =         rowView.findViewById(R.id.tvDate);
        // Get the ImageView object
        iv =             rowView.findViewById(R.id.imageView);


        // The parameter "position" is the index of the
        //  row ListView is requesting.
        //  We get back the food at the same index.
        Holiday current = alHoliday.get(position);
        // Set the TextView to show the food

        tvTitle.setText(current.getTitle());
        tvDate.setText(current.getDate());
        // Set the image to star or nostar accordingly
        if(current.getTitle().equals("New Year's Day")){
            iv.setImageResource(R.drawable.new_year);
        }
        else if(current.getTitle().equals("Labour Day")){
            iv.setImageResource(R.drawable.labour_day);
        }
        else if(current.getTitle().equals("Chinese New Year")){
            iv.setImageResource(R.drawable.cny);
        }
        else if(current.getTitle().equals("Good Friday")){
            iv.setImageResource(R.drawable.good_friday);
        }
        else if(current.getTitle().equals("Hari Raya Puasa")){
            iv.setImageResource(R.drawable.hari_raya_puasa);
        }
        else if(current.getTitle().equals("Deepavali")){
            iv.setImageResource(R.drawable.deepavali);
        }
        // Return the nicely done up View to the ListView
        return rowView;
    }

}
