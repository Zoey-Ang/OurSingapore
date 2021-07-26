package com.myapplicationdev.android.p05_ndpsongs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {

    Context parent_context;
    int layout_id;
    ArrayList<Song> songList;

    public CustomAdapter(@NonNull Context context, int resource, ArrayList<Song> objects)
    {
        super(context, resource, objects);

        parent_context=context;
        layout_id = resource;
        songList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(layout_id,parent,false);

        TextView tvTitle = rowView.findViewById(R.id.tvTitle);
        TextView tvSinger = rowView.findViewById(R.id.tvSingers);
        TextView tvYOR = rowView.findViewById(R.id.tvYearsReleased);
        TextView tvStars = rowView.findViewById(R.id.tvStars);

        Song songs = songList.get(position);
        tvTitle.setText(songs.getTitle());
        //edittext then can use toString, text view can use Integer.toString
        //Integer.to String because we are converting from integer to string
        tvYOR.setText(Integer.toString(songs.getYearReleased()));
        //we can use toString here because we are displaying the number of stars instead of
        //getting the number of stars.
        tvStars.setText(songs.toString());
        tvSinger.setText(songs.getSingers());
        return rowView;
    }
}
