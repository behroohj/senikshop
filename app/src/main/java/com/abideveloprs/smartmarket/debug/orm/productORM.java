package com.abideveloprs.smartmarket.debug.orm;

/**
 * Created by imanbahmani on 9/1/16 AD.
 * CREATE TABLE "productORM" (
 `id_master`	INTEGER PRIMARY KEY AUTOINCREMENT,
 `id`	INTEGER,
 `title`	TEXT,
 `content`	TEXT,
 `image`	TEXT,
 `commission`	INTEGER,
 `stock`	INTEGER,
 `price`	INTEGER,
 `percent`	INTEGER,
 `product_head`	INTEGER,
 `shop`	INTEGER,
 `number`	INTEGER,
 `trash`	TEXT
 )
 */
public class productORM {
    private Integer idMaster;
    private String  title;
    private String  content;
    private String  image;
    private Integer commission;
    private Integer stock;
    private Integer price;
    private Integer percent;
    private Integer product_head;
    private Integer shop;
    private Integer number;
    private Boolean trash;

    public productORM() {
    }
    public productORM(Integer idMaster, String title, String content, String image, Integer commission, Integer stock, Integer price, Integer percent, Integer product_head, Integer shop, Integer number, Boolean trash) {
        this.idMaster=idMaster;
        this.title        = title;
        this.content      = content;
        this.image        = image;
        this.commission   = commission;
        this.stock        = stock;
        this.price        = price;
        this.percent      = percent;
        this.product_head = product_head;
        this.shop         = shop;
        this.number       = number;
        this.trash        = trash;
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
    public Integer getCommission() {
        return commission;
    }
    public void setCommission(Integer commission) {
        this.commission = commission;
    }
    //////////////////////
    public Integer getStock() {
        return stock;
    }
    public void setStock(Integer stock) {
        this.stock = stock;
    }
    //////////////////////
    public Integer getPrice() {
        return price;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }
    //////////////////////
    public Integer getPercent() {
        return percent;
    }
    public void setPercent(Integer percent) {
        this.percent = percent;
    }
    //////////////////////
    public Integer getProduct_head() {
        return product_head;
    }
    public void setProduct_head(Integer product_head) {
        this.product_head = product_head;
    }
    //////////////////////
    public Integer getShop() {
        return shop;
    }
    public void setShop(Integer shop) {
        this.shop = shop;
    }
    //////////////////////
    public Integer getNumber() {
        return number;
    }
    public void setNumber(Integer number) {
        this.number = number;
    }
    //////////////////////
    public Boolean getTrash() {
        return trash;
    }
    public void setTrash(Boolean trash) {
        this.trash = trash;
    }
    //////////////////////

}