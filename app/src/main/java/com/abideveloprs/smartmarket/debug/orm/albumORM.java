package com.abideveloprs.smartmarket.debug.orm;

/**
 * Created by imanbahmani on 10/5/16 AD.
 */
public class albumORM {
    private String name;
    private int numOfSongs;
    private int thumbnail;

    public albumORM() {
    }

    public albumORM(String name, int numOfSongs, int thumbnail) {
        this.name = name;
        this.numOfSongs = numOfSongs;
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumOfSongs() {
        return numOfSongs;
    }

    public void setNumOfSongs(int numOfSongs) {
        this.numOfSongs = numOfSongs;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}