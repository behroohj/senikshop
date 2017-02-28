package com.abideveloprs.smartmarket.debug.orm;

import com.orm.SugarRecord;

/**
 * Created by imanbahmani on 9/1/16 AD.
 * CREATE TABLE "galleryORM" (
 `id_master`	INTEGER PRIMARY KEY AUTOINCREMENT,
 `id`	INTEGER,
 `name`	TEXT,
 `productheadid`	TEXT,
 `trash`	TEXT
 )
 */
public class psizesORM extends SugarRecord {
    private int idapp;
    private String name;
    private int productheadid;
    private String trash;

    public psizesORM() {
    }

    public psizesORM(int idapp, String name, int productheadid, String trash) {
        this.idapp=idapp;
        this.name = name;
        this.productheadid = productheadid;
        this.trash = trash;
    }
    //////////////////////
    public int getIdapp() {
        return idapp;
    }
    public void setIdapp(int idapp) {
        this.idapp = idapp;
    }
    /////////////////////
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    /////////////////////
    public int getProductheadid() {
        return productheadid;
    }
    public void setProductheadid(int productheadid) {
        this.productheadid = productheadid;
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