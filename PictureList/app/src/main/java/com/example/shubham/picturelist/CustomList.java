package com.example.shubham.picturelist;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

public class CustomList extends ArrayAdapter<String> {
    private final Activity context;
    private final Integer[] imageId;

    public CustomList(Activity context, Integer[] imageId) {
        super(context, R.layout.list_single);
        this.context = context;
        this.imageId = imageId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.list_single, null, true);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.img);
        imageView.setImageResource(imageId[0]);
        return rowView;
    }

    public void addImage(String id){
        //super.add(id);
        this.insert(id, 0);
    }
//    @Override
//    public String getItem(int position) {
//        return super.getItem(getCount() - 1 - position);
//    }
}
