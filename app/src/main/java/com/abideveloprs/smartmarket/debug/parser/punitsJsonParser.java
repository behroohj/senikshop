package com.abideveloprs.smartmarket.debug.parser;

import android.util.Log;

import com.abideveloprs.smartmarket.debug.orm.punitsORM;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by imanbahmani on 9/1/16 AD.
 */
public class punitsJsonParser {
    public Boolean punitsJsonParserInput(String input)
    {
        try
        {
            try
            {
                JSONArray jsonarray = new JSONArray(input);
                for(int i=0; i<jsonarray.length(); i++) {
                    JSONObject obj = jsonarray.getJSONObject(i);

                    int     idapp           =   obj.   getInt("id");
                    String  name            =   obj.getString("name");
                    int     productheadid   =   obj.   getInt("product_head_id");
                    String  trash           =   obj.getString("trash");


                    if ((int) punitsORM.count(punitsORM.class, "idapp = " + idapp, null) == 0) {
                        punitsORM punits = new punitsORM();
                        punits.setIdapp(idapp);
                        punits.setName(name);
                        punits.setProductheadid(productheadid);
                        punits.setTrash(trash);
                        punits.save();
                    } else {
                        List<punitsORM> notes = punitsORM.find(punitsORM.class, "idapp = " + idapp, null);
                        if (notes.size() > 0) {
                            punitsORM punits = notes.get(0);
                            punits.setIdapp(idapp);
                            punits.setName(name);
                            punits.setProductheadid(productheadid);
                            punits.setTrash(trash);
                            punits.save();
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
