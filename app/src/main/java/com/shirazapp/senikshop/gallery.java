package com.shirazapp.senikshop;

/**
 * Created by imanbahmani on 9/1/16 AD.
 * CREATE TABLE "gallery" (
 `id_master`	INTEGER PRIMARY KEY AUTOINCREMENT,
 `id`	INTEGER,
 `title`	TEXT,
 `image`	TEXT,
 `trash`	TEXT
 )
 */
public class gallery {
    private Integer idMaster;
    private String title;
    private String image;
    private Boolean trash;

    public gallery() {
    }

    public gallery(Integer idMaster,String title, String image,Boolean trash) {
        this.idMaster=idMaster;
        this.title = title;
        this.image = image;
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
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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