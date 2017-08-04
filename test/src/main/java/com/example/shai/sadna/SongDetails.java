package com.example.shai.sadna;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class SongDetails extends AppCompatActivity {

    TextView songTXT,collectionTXT,priceTXT,trackIDTXT,collectionIDTXT, collectionPriceTXT;
    String song,collection,price,trackID,collectionID, collectionPrice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        songTXT = (TextView) findViewById(R.id.songJsn);
        collectionTXT = (TextView) findViewById(R.id.collectionJsn);
        priceTXT = (TextView) findViewById(R.id.priceJsn);
        trackIDTXT = (TextView) findViewById(R.id.trackIdJsn);
        collectionIDTXT = (TextView) findViewById(R.id.collectionIdJsn);
        collectionPriceTXT = (TextView) findViewById(R.id.collectionPriceJsn);

        song= getIntent().getStringExtra("song");
        collection= getIntent().getStringExtra("collection");
        price= getIntent().getStringExtra("price");
        trackID= getIntent().getStringExtra("trackID");
        collectionID= getIntent().getStringExtra("collectionID");
        collectionPrice= getIntent().getStringExtra("collectionPrice");

        safeSetText (songTXT ,song);
        safeSetText (collectionTXT,collection);
        safeSetText (  priceTXT,  price);
        safeSetText (trackIDTXT, trackID);
        safeSetText (collectionIDTXT, collectionID);
        safeSetText ( collectionPriceTXT, collectionPrice);

    }

    public void safeSetText (TextView textV, String text)
    {
        if (text!=null)
            textV.setText(text);
    }
}
