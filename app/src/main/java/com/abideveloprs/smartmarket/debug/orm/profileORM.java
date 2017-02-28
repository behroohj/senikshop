package com.abideveloprs.smartmarket.debug.orm;

import com.orm.SugarRecord;

/**
 * Created by imanbahmani on 9/1/16 AD.
 * CREATE TABLE "productORM" (
 `id_master`	int PRIMARY KEY AUTOINCREMENT,
 `id`	int,
 `name`	TEXT,
 `family`	TEXT,
 `mobile`	TEXT,
 `city`	int,
 `pass`	int,
 `hash`	int,
 `devicemodel`	int,
 `date`	int,
 `shop`	int,
 `number`	int,
 `time`	TEXT
 )
 */
public class profileORM extends SugarRecord{
    private int     idapp;
    private String  name;
    private String  family;
    private String  mobile;
    private String  email;
    private String  city;
    private String  pass;
    private String  hash;
    private String  devicemodel;
    private String  date;
    private String  time;
    private String  postalcode;
    private String  tell;
    private String  state;
    private String  reagent;


    public profileORM() {
    }
    public profileORM(int idapp, String name, String family, String mobile, String email, String city, String pass, String hash, String devicemodel, String date, String time, String postalcode, String tell, String state, String reagent) {

        this.idapp       = idapp;
        this.name        = name;
        this.family      = family;
        this.mobile      = mobile;
        this.email       = email;
        this.city        = city;
        this.pass        = pass;
        this.hash        = hash;
        this.devicemodel = devicemodel;
        this.date        = date;
        this.time        = time;
        this.postalcode  = postalcode;
        this.tell        = tell;
        this.state       = state;
        this.reagent     = reagent;
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
    public String getFamily() {
        return family;
    }
    public void setFamily(String family) {
        this.family = family;
    }
    /////////////////////
    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    /////////////////////
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    /////////////////////
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    //////////////////////
    public String getPass() {
        return pass;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }
    //////////////////////
    public String getHash() {
        return hash;
    }
    public void setHash(String hash) {
        this.hash = hash;
    }
    //////////////////////
    public String getDevicemodel() {
        return devicemodel;
    }
    public void setDevicemodel(String devicemodel) {
        this.devicemodel = devicemodel;
    }
    //////////////////////
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    //////////////////////
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    //////////////////////
    public String getPostalcode() {
        return postalcode;
    }
    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }
    //////////////////////
    public String gettell() {
        return tell;
    }
    public void settell(String tell) {
        this.tell = tell;
    }
    //////////////////////
    public String getstate() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    //////////////////////
    public String getReagent() {
        return reagent;
    }
    public void setReagent(String reagent) {
        this.reagent = reagent;
    }

}