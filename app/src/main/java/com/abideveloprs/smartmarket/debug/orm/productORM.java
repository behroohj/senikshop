package com.abideveloprs.smartmarket.debug.orm;

import com.google.common.primitives.Booleans;
import com.orm.SugarRecord;

/**
 * Created by imanbahmani on 9/1/16 AD.
 * CREATE TABLE "productORM" (
 `id_master`	int PRIMARY KEY AUTOINCREMENT,
 `id`	int,
 `title`	TEXT,
 `content`	TEXT,
 `image`	TEXT,
 `commission`	int,
 `stock`	int,
 `price`	int,
 `percent`	int,
 `phead`	int,
 `shop`	int,
 `number`	int,
 `trash`	TEXT
 )
 */
public class productORM extends SugarRecord{
    private int     idapp;
    private String  title;
    private String  content;
    private String  image;
    private int     commission;
    private int     stock;
    private int     price;
    private int     percent;
    private int     phead;
    private String  trash;
    private String  isnew;
    private String  slider;
    private String  sliderupdate;


    public productORM() {
    }
    public productORM(int idapp, String title, String content, String image, int commission, int stock, int price, int percent, int phead, String trash,String isnew,String slider,String sliderupdate) {
        this.idapp        =idapp;
        this.title        = title;
        this.content      = content;
        this.image        = image;
        this.commission   = commission;
        this.stock        = stock;
        this.price        = price;
        this.percent      = percent;
        this.phead = phead;
        this.trash        = trash;
        this.isnew        = isnew;
        this.slider       = slider;
        this.sliderupdate = sliderupdate;
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
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    /////////////////////
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    /////////////////////
    public int getCommission() {
        return commission;
    }
    public void setCommission(int commission) {
        this.commission = commission;
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
    public int getPercent() {
        return percent;
    }
    public void setPercent(int percent) {
        this.percent = percent;
    }
    //////////////////////
    public int getPhead() {
        return phead;
    }
    public void setPhead(int phead) {
        this.phead = phead;
    }
    //////////////////////
    public String getTrash() {
        return trash;
    }
    public void setTrash(String trash) {
        this.trash = trash;
    }
    //////////////////////
    public String getIsnew() {
        return isnew;
    }
    public void setIsnew(String isnew) {
        this.isnew = isnew;
    }
    //////////////////////
    public String getSlider() {
        return slider;
    }
    public void setSlider(String slider) {
        this.slider = slider;
    }
    //////////////////////
    public String getSliderupdate() {
        return sliderupdate;
    }
    public void setSliderupdate(String sliderupdate) {
        this.sliderupdate = sliderupdate;
    }
    //////////////////////

}