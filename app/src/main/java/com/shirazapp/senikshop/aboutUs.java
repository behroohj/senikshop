package com.shirazapp.senikshop;

import com.orm.SugarRecord;

/**
 * Created by imanbahmani on 9/1/16 AD.
 * CREATE TABLE `aboutus` (
 `id_master`	INTEGER PRIMARY KEY AUTOINCREMENT,
 `id`	INTEGER,
 `title`	TEXT,
 `content`	TEXT
 )
 */
public class aboutUs extends SugarRecord {
    private int idMaster;
    private String title;
    private String content;

    public aboutUs() {
    }

    public aboutUs(int idMaster,String title, String content) {
        this.idMaster=idMaster;
        this.title = title;
        this.content = content;
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
    public String getContent() {
         return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
////////////////////
}