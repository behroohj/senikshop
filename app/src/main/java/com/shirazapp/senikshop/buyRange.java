package com.shirazapp.senikshop;

/**
 * Created by imanbahmani on 9/1/16 AD.
 * CREATE TABLE `buy_range` (
 `id_master`	INTEGER PRIMARY KEY AUTOINCREMENT,
 `id`	INTEGER,
 `title`	TEXT,
 `price`	INTEGER,
 `min`	INTEGER,
 `max`	INTEGER
 )
 */
public class buyRange {
    private int idMaster;
    private String title;
    private String price;
    private int min;
    private int max;

    public buyRange() {
    }

    public buyRange(int idMaster, String title, String price, int max, int min) {
        this.idMaster = idMaster;
        this.title = title;
        this.price = price;
        this.min = min;
        this.max = max;
    }
    //////////////////////
    public int getIdMaster() {
        return idMaster;
    }

    public void setIdMaster(int idMaster) {
        this.idMaster = idMaster;
    }
    /////////////////////
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    /////////////////////
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    //////////////////////
    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }
    //////////////////////
    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }
    /////////////////////
}