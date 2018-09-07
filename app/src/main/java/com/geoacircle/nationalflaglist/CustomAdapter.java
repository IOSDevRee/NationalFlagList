package com.geoacircle.nationalflaglist;

import android.content.Context;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

class CustomAdapter extends ArrayAdapter<RowItem> {

    public CustomAdapter(@NonNull Context context, int resource, @NonNull List<RowItem> objects) {
        super(context, resource, objects);

    }


    @Override
    public View getView(int position,  View convertView, ViewGroup parent) {

        LayoutInflater reeInflater = LayoutInflater.from(getContext());

        View customView = reeInflater.inflate(R.layout.custom_row, parent, false);

        RowItem country = getItem(position);
        TextView reeText = (TextView) customView.findViewById(R.id.name);
        ImageView reeImage = (ImageView) customView.findViewById(R.id.flag);

        reeText.setText(country.getTitle());
        reeImage.setImageResource(country.getImgId());
        return customView;



    }
}
