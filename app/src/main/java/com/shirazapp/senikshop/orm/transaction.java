package com.shirazapp.senikshop.orm;

/**
 * Created by imanbahmani on 9/1/16 AD.
 * CREATE TABLE "trans" (
 `id_master_master`	INTEGER PRIMARY KEY AUTOINCREMENT,
 `id_master`	INTEGER,
 `id`	INTEGER,
 `trans`	TEXT,
 `price`	TEXT,
 `national_code`	TEXT,
 `data`	TEXT,
 `time`	TEXT,
 `state`	TEXT,
 `json`	TEXT,
 `range`	TEXT
 )
 */
public class transaction {
    private Integer idMaster;
    private Integer idCode;
    private String  trans;
    private String  price;
    private String  national_code;
    private String  data;
    private String  time;
    private String  state;
    private String  json;
    private String  range;

    public transaction() {
    }
    public transaction(Integer idMaster,Integer idCode,String trans,String price,String national_code,String data,String time,String state,String json,String range) {
        this.idMaster     = idMaster;
        this.idCode       = idCode;
        this.trans        = trans;
        this.price        = price;
        this.national_code= national_code;
        this.data         = data;
        this.time         = time;
        this.state        = state;
        this.json         = json;
        this.range        = range;
    }
    //////////////////////
    public Integer getIdMaster() {
        return idMaster;
    }
    public void setIdMaster(Integer idMaster) {
        this.idMaster = idMaster;
    }
    //////////////////////
    public Integer getIdCode() {
        return idCode;
    }
    public void setIdCode(Integer idCode) {
        this.idCode = idCode;
    }
    /////////////////////
    public String getTrans() {
        return trans;
    }
    public void setTrans(String trans) {
        this.trans = trans;
    }
    /////////////////////
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    /////////////////////
    public String getNational_code() {
        return national_code;
    }
    public void setNational_code(String national_code) {
        this.national_code = national_code;
    }
    ////////////////////
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    /////////////////////
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    /////////////////////
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    /////////////////////
    public String getJson() {
        return json;
    }
    public void setjson(String json) {
        this.json = json;
    }
    /////////////////////
    public String getRange() {
        return range;
    }
    public void setRange(String range) {
        this.range = range;
    }
    /////////////////////
}