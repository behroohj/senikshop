package com.abideveloprs.smartmarket.debug.orm;

import com.orm.SugarRecord;

/**
 * Created by imanbahmani on 9/1/16 AD.
 * CREATE TABLE "productORM" (
 `id_master`	int PRIMARY KEY AUTOINCREMENT,
 `id`	int,
 `productid`	TEXT,
 `sizeid`	TEXT,
 `colorid`	TEXT,
 `unitid`	int,
 `stock`	int,
 `price`	int,
 `percent`	int,
 `phead`	int,
 `shop`	int,
 `number`	int,
 `trash`	TEXT
 )
 */
public class subproductORM extends SugarRecord{
    private int     idapp;
    private int  productid;
    private int  sizeid;
    private int  colorid;
    private int     unitid;
    private int     price;
    private int     stock;
    private String  trash;


    public subproductORM() {
    }
    public subproductORM(int idapp, int productid, int sizeid, int colorid, int unitid, int stock, int price, String trash) {
        this.idapp        = idapp;
        this.productid    = productid;
        this.sizeid       = sizeid;
        this.colorid      = colorid;
        this.unitid       = unitid;
        this.stock        = stock;
        this.price        = price;
        this.trash        = trash;
    }
    //////////////////////
    public int getIdapp() {
        return idapp;
    }
    public void setIdapp(int idapp) {
        this.idapp = idapp;
    }
    /////////////////////
    public int getProductid() {
        return productid;
    }
    public void setProductid(int productid) {
        this.productid = productid;
    }
    /////////////////////
    public int getSizeid() {
        return sizeid;
    }
    public void setSizeid(int sizeid) {
        this.sizeid = sizeid;
    }
    /////////////////////
    public int getColorid() {
        return colorid;
    }
    public void setColorid(int colorid) {
        this.colorid = colorid;
    }
    /////////////////////
    public int getUnitid() {
        return unitid;
    }
    public void setUnitid(int unitid) {
        this.unitid = unitid;
    }
    //////////////////////
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    //////////////////////
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    //////////////////////
    public String getTrash() {
        return trash;
    }
    public void setTrash(String trash) {
        this.trash = trash;
    }
    //////////////////////

}