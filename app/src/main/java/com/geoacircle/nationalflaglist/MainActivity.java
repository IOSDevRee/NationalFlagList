package com.geoacircle.nationalflaglist;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView reeListView;
    String [] fillist;
    int [] img;
    List<RowItem> rowItems;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = new int[]{R.mipmap.france, R.mipmap.germany, R.mipmap.india,
                R.mipmap.indonesia, R.mipmap.italy, R.mipmap.japan,
                R.mipmap.pakistan, R.mipmap.russia, R.mipmap.thaiwan, R.mipmap.usa};

        fillist = getResources().getStringArray(R.array.countries);

        rowItems = new ArrayList<RowItem>();

        for(int i = 0; i < img.length; i++){

            RowItem item = new RowItem(img[i], fillist[i]);
            rowItems.add(item);
        }


        ListAdapter reeadapter = new CustomAdapter(this, R.layout.custom_row ,rowItems);
        reeListView =findViewById(R.id.lvdata);
        reeListView.setAdapter(reeadapter);



        reeListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                        String city = String.valueOf(adapterView.getItemAtPosition(position));

                        Toast.makeText(MainActivity.this, ""+ city, Toast.LENGTH_LONG).show();
                    }
                });

    }
}
