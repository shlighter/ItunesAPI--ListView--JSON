package com.example.shai.sadna;

import android.graphics.Bitmap;
import android.widget.ImageView;

/**
 * Created by Shai on 6/22/2017.
 */

public class Song {

    private String song, collection, price, image, collectionId, trackId, collectionPrice;
    private Bitmap bmp;


    public Song(String song, String collection, String price, String image, String collectionId, String trackId, String collectionPrice) {
        this.song = song;
        this.price = price;
        this.collection = collection;
        this.image = image;
        this.collectionId = collectionId;
        this.trackId = trackId;
        this.collectionPrice = collectionPrice;
    }

    public Bitmap getBmp() {
        return bmp;
    }

    public void setBmp(Bitmap bmp) {
        this.bmp = bmp;
    }

    public String getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(String collectionId) {
        this.collectionId = collectionId;
    }

    public String getTrackId() {
        return trackId;
    }

    public void setTrackId(String trackId) {
        this.trackId = trackId;
    }

    public String getCollectionPrice() {
        return collectionPrice;
    }

    public void setCollectionPrice(String collectionPrice) {
        this.collectionPrice = collectionPrice;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
