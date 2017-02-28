package com.abideveloprs.smartmarket.debug.parser;

import android.util.Log;

import com.abideveloprs.smartmarket.debug.orm.subproductORM;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by imanbahmani on 9/1/16 AD.
 */
public class subproductJsonParser {
    public Boolean subproductJsonParserInput(String input)
    {
        try
        {
            try
            {
                JSONArray jsonarray = new JSONArray(input);
                for(int i=0; i<jsonarray.length(); i++) {
                    JSONObject obj = jsonarray.getJSONObject(i);

                    int     idapp        =   obj.   getInt("id");
                    int     productid    =   obj.   getInt("product_id");
                    int     sizeid       =   obj.   getInt("size_id");
                    int     colorid      =   obj.   getInt("color_id");
                    int     unitid       =   obj.   getInt("unit_id");
                    int     price        =   obj.   getInt("price");
                    int     stock        =   obj.   getInt("stock");
                    String  trash        =   obj.getString("trash");


                    if ((int) subproductORM.count(subproductORM.class, "idapp = " + idapp, null) == 0) {
                        subproductORM subproduct = new subproductORM();
                        subproduct.setIdapp(idapp);
                        subproduct.setProductid(productid);
                        subproduct.setSizeid(sizeid);
                        subproduct.setColorid(colorid);
                        subproduct.setUnitid(unitid);
                        subproduct.setPrice(price);
                        subproduct.setStock(stock);
                        subproduct.setTrash(trash);
                        subproduct.save();
                    } else {
                        List<subproductORM> notes = subproductORM.find(subproductORM.class, "idapp = " + idapp, null);
                        if (notes.size() > 0) {
                            subproductORM subproduct = notes.get(0);
                            subproduct.setIdapp(idapp);
                            subproduct.setProductid(productid);
                            subproduct.setSizeid(sizeid);
                            subproduct.setColorid(colorid);
                            subproduct.setUnitid(unitid);
                            subproduct.setPrice(price);
                            subproduct.setStock(stock);
                            subproduct.setTrash(trash);
                            subproduct.save();
                        }
                    }


                }
                return true;
            }
            catch (JSONException e)
            {
                e.printStackTrace();
                return false;
            }
        } catch (Exception e)
        {
            Log.e("Error: ", e.getMessage());
            return false;
        }
    }
}
