package com.example.shai.sadna;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shai on 6/22/2017.
 */

public class Adapter extends ArrayAdapter {

    List list = new ArrayList();
    ImageLoader ig;


    public Adapter(Context context, int resource) {
        super(context, resource);
        ig = new ImageLoader(context);
    }


    public void add(Song object) {
        super.add(object);
        list.add(object);System.out.println("now");
    }

    public List getList() {
        return list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row;System.out.println("now");
        row = convertView;
        SongHolder holder;

        if (row==null)
        {
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.row_layout, parent,false);
            holder = new SongHolder();
            holder.songTXT = (TextView) row.findViewById(R.id.songJsn);
            holder.collectionTXT = (TextView) row.findViewById(R.id.collectionJsn);
            holder.priceTXT = (TextView) row.findViewById(R.id.priceJsn);
            holder.iV = (ImageView) row.findViewById(R.id.pic);
            row.setTag(holder);
        }

        else
        {
            holder = (SongHolder) row.getTag();
        }

        holder.iV.setImageBitmap(null);
        Song song = (Song) this.getItem(position);
        holder.songTXT.setText(song.getSong());
        holder.collectionTXT.setText(song.getCollection());
        holder.priceTXT.setText(song.getPrice());
        ig.DisplayImage(song.getImage(), holder);
        return row;
    }





}
