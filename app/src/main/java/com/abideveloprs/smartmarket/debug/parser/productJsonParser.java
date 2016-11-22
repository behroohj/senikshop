package com.abideveloprs.smartmarket.debug.parser;

import android.util.Log;
import com.abideveloprs.smartmarket.debug.orm.productORM;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.List;

/**
 * Created by imanbahmani on 9/1/16 AD.
 */
public class productJsonParser {
    public void productJsonParserInput(String input)
    {
        try
        {
            try
            {
                JSONArray jsonarray = new JSONArray(input);
                for(int i=0; i<jsonarray.length(); i++) {
                    JSONObject obj = jsonarray.getJSONObject(i);

                    int idapp =             obj.getInt("id");
                    String title =          obj.getString("title");
                    String content =        obj.getString("content");
                    String image =          obj.getString("image");
                    int commission =        obj.getInt("commission");
                    int stock =             obj.getInt("stock");
                    int price =             obj.getInt("price");
                    int percent =           obj.getInt("percent");
                    int phead =      obj.getInt("product_head");
                    String trash =          obj.getString("trash");
                    String isnew =          obj.getString("new");
                    String slider =         obj.getString("slider");
                    String sliderupdate =   obj.getString("sliderUpdate");


                    if ((int) productORM.count(productORM.class, "idapp = " + idapp, null) == 0) {
                        productORM product = new productORM();
                        product.setidapp(idapp);
                        product.setTitle(title);
                        product.setImage(image);
                        product.setCommission(commission);
                        product.setStock(stock);
                        product.setImage(image);
                        product.setPercent(price);
                        product.setPercent(percent);
                        product.setPhead(phead);
                        product.setTrash(trash);
                        product.setIsnew(isnew);
                        product.setSlider(slider);
                        product.setSliderupdate(sliderupdate);
                        product.save();
                    } else {
                        List<productORM> notes = productORM.find(productORM.class, "idapp = " + idapp, null);
                        if (notes.size() > 0) {
                            productORM product = notes.get(0);
                            product.setidapp(idapp);
                            product.setTitle(title);
                            product.setImage(image);
                            product.setCommission(commission);
                            product.setStock(stock);
                            product.setImage(image);
                            product.setPercent(price);
                            product.setPercent(percent);
                            product.setPhead(phead);
                            product.setTrash(trash);
                            product.setIsnew(isnew);
                            product.setSlider(slider);
                            product.setSliderupdate(sliderupdate);
                            product.save();
                        }
                    }


                }
            }
            catch (JSONException e)
            {
                e.printStackTrace();
            }
        } catch (Exception e)
        {
            Log.e("Error: ", e.getMessage());
        }
    }
}
