package com.abideveloprs.smartmarket.debug.parser;

import android.util.Log;

import com.abideveloprs.smartmarket.debug.orm.pcolorsORM;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by imanbahmani on 9/1/16 AD.
 */
public class pcolorsJsonParser {
    public Boolean pcolorsJsonParserInput(String input)
    {
        try
        {
            try
            {
                JSONArray jsonarray = new JSONArray(input);
                for(int i=0; i<jsonarray.length(); i++) {
                    JSONObject obj = jsonarray.getJSONObject(i);

                    int     idapp        =   obj.   getInt("id");
                    String  name         =   obj.getString("name");
                    String  hex          =   obj.getString("hex");
                    String  trash        =   obj.getString("trash");


                    if ((int) pcolorsORM.count(pcolorsORM.class, "idapp = " + idapp, null) == 0) {
                        pcolorsORM pcolors = new pcolorsORM();
                        pcolors.setIdapp(idapp);
                        pcolors.setName(name);
                        pcolors.setHex(hex);
                        pcolors.setTrash(trash);
                        pcolors.save();
                    } else {
                        List<pcolorsORM> notes = pcolorsORM.find(pcolorsORM.class, "idapp = " + idapp, null);
                        if (notes.size() > 0) {
                            pcolorsORM pcolors = notes.get(0);
                            pcolors.setIdapp(idapp);
                            pcolors.setName(name);
                            pcolors.setHex(hex);
                            pcolors.setTrash(trash);
                            pcolors.save();
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
