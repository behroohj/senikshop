package com.abideveloprs.smartmarket.debug.orm;

import com.orm.SugarRecord;

/**
 * Created by imanbahmani on 9/1/16 AD.
 * CREATE TABLE "galleryORM" (
 `id_master`	INTEGER PRIMARY KEY AUTOINCREMENT,
 `id`	INTEGER,
 `name`	TEXT,
 `hex`	TEXT,
 `trash`	TEXT
 )
 */
public class pcolorsORM extends SugarRecord{
    private int idapp;
    private String name;
    private String hex;
    private String trash;

    public pcolorsORM() {
    }

    public pcolorsORM(int idapp, String name, String hex, String trash) {
        this.idapp=idapp;
        this.name = name;
        this.hex = hex;
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
    public String getHex() {
        return hex;
    }

    public void setHex(String hex) {
        this.hex = hex;
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