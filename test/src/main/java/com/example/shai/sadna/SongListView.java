package com.example.shai.sadna;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class SongListView extends AppCompatActivity implements AdapterView.OnItemClickListener {

    Bitmap bitmapFromNet;
    JSONObject JO;
    public String jsonString;
    JSONObject jsn;
    JSONArray jsonArray;
    Adapter adapter;
    ListView listView;;
    final static  String FILE_NAME = "file.png";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new Adapter(SongListView.this, R.layout.row_layout);
        setContentView(R.layout.content_list_view);
        listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        jsonString= getIntent().getStringExtra("json");

        try {
            jsn = new JSONObject(jsonString);
            jsonArray = jsn.getJSONArray("results");

            int count=0;
            String song, collection, price,image, trackID, collectionID, collectionPrice;
            while(count<jsonArray.length())
            { System.out.println("COUNT="+count);
                 JO = jsonArray.getJSONObject(count);
                song = getPropertySafely("trackName");
                collection = getPropertySafely("collectionName");
                price = getPropertySafely("trackPrice");
                image = getPropertySafely("artworkUrl100");
                trackID = getPropertySafely("trackId");
                collectionID = getPropertySafely("collectionId");
                collectionPrice = getPropertySafely("collectionPrice");
                Song songItem = new Song(song,collection,price,image,trackID,collectionID,collectionPrice);
                adapter.add(songItem);
                count++;

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    String getPropertySafely(String key) {
        try {
            return JO.getString(key);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Song song = (Song) adapter.getList().get(position);
        System.out.println("name is="+song.getSong());
        System.out.println("name iscol="+song.getCollection());
        System.out.println("name iscolid="+song.getCollectionId());
        System.out.println("name iscolpri="+song.getCollectionPrice());
        System.out.println("name istrackid="+song.getTrackId());
        System.out.println("name is="+song.getSong());
        Intent intent = new Intent(this, SongDetails.class);
        intent.putExtra("song", song.getSong());
        intent.putExtra("collection", song.getCollection());
        intent.putExtra("price", song.getPrice());
        intent.putExtra("trackID", song.getTrackId());
        intent.putExtra("collectionID", song.getCollectionId());
        intent.putExtra("collectionPrice", song.getCollectionPrice());
       startActivity(intent);
    }




}
