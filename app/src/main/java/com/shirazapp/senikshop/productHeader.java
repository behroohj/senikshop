package com.shirazapp.senikshop;

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
public class productHeader {
    private Integer idMaster;
    private String title;
    private String color;
    private Boolean trash;

    public productHeader() {
    }
    public productHeader(Integer idMaster,String title, String color,Boolean trash) {
        this.idMaster=idMaster;
        this.title = title;
        this.color = color;
        this.trash = trash;
    }
    //////////////////////
    public Integer getIdMaster() {
        return idMaster;
    }
    public void setIdMaster(Integer idMaster) {
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
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    /////////////////////
    public Boolean getTrash() {
        return trash;
    }
    public void setTrash(Boolean trash) {
        this.trash = trash;
    }
////////////////////
}