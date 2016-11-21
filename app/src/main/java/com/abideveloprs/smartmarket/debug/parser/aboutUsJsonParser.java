package com.abideveloprs.smartmarket.debug.parser;

import android.util.Log;

import com.abideveloprs.smartmarket.debug.ormquery.aboutUsQuery;
import com.abideveloprs.smartmarket.debug.orm.aboutusORM;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by imanbahmani on 9/1/16 AD.
 */
public class aboutUsJsonParser {
    public void aboutUsJsonParserInput(String input)
    {
        try
        {
            try
            {
                JSONArray jsonarray = new JSONArray(input);
                for(int i=0; i<jsonarray.length(); i++)
                {
                    JSONObject obj         = jsonarray.getJSONObject(i);
                    int id                 = obj.getInt("id");
                    String title           = obj.getString("title");
                    String content         = obj.getString("content");

                    aboutUsQuery aboutUsQuery = new aboutUsQuery();
                    Boolean isInsert=aboutUsQuery.aboutUsQueryInput(id);


                    if(isInsert)
                    {
                        aboutusORM about = new aboutusORM();
                        about.setIdMaster(id);
                        about.setTitle(title);
                        about.setContent(content);
                        about.save();
                    }
                    else
                    {

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
