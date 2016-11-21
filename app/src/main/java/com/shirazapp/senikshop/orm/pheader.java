package com.shirazapp.senikshop.orm;

import com.orm.SugarRecord;
/**
 * Created by imanbahmani on 9/1/16 AD.
 * CREATE TABLE "product_head" (
 `id_master`	INTEGER PRIMARY KEY AUTOINCREMENT,
 `id`	INTEGER,
 `title`	TEXT,
 `color`	TEXT,
 `trash`	TEXT
 )
 */
public class pheader extends SugarRecord {
    private int    idapp;
    private String title;
    private String color;
    private String image;
    private String trash;

    public pheader() {
    }
    public pheader(int idapp, String title, String color, String image, String trash) {
        this.idapp =idapp;
        this.title = title;
        this.color = color;
        this.image = image;
        this.trash = trash;
    }
    //////////////////////
    public int getidapp() {
        return idapp;
    }
    public void setidapp(int idapp) {
        this.idapp = idapp;
    }
    /////////////////////
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    /////////////////////
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    /////////////////////
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    /////////////////////
    public String getTrash() {
        return trash;
    }
    public void setTrash(String trash) {
        this.trash = trash;
    }
////////////////////
}