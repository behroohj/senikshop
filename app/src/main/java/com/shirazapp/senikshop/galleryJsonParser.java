package com.shirazapp.senikshop;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by imanbahmani on 9/1/16 AD.
 */
public class galleryJsonParser {
    public void galleryJsonParserInput(String input)
    {
        try
        {
            try
            {
                JSONArray jsonarray = new JSONArray(input);
                for(int i=0; i<jsonarray.length(); i++)
                {
                    JSONObject obj        = jsonarray.getJSONObject(i);
                    int id                = obj.getInt("id");
                    String title          = obj.getString("title");
                    String image          = obj.getString("image");
                    Boolean trash         = obj.getBoolean("trash");
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
