package com.example.shubham.picturelist;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;


public class MainActivity extends Activity {

    ListView list;
    String str = "img1";

    Integer[] imageId = {
            R.drawable.image7
    };

    private TextView mTitle;
    private ImageButton mAdd;
    CustomList adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Resources resources = getResources();
        adapter = new CustomList(MainActivity.this, imageId);

        list = (ListView)findViewById(R.id.list);
        list.setAdapter(adapter);

        LayoutInflater inflater = this.getLayoutInflater();
        View view = inflater.inflate(R.layout.titleview, null);

        mTitle = (TextView)view.findViewById(R.id.title);
        mTitle.setText(resources.getString(R.string.app_name));

        mAdd = (ImageButton)view.findViewById(R.id.bAdd);
        mAdd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                adapter.addImage(str);
            }
        });
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setCustomView(view);
    }
}
