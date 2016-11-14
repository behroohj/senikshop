package com.shirazapp.senikshop;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by imanbahmani on 9/1/16 AD.
 */
public class productHeaderJsonParser {
    public void productHeaderJsonParserInput(String input)
    {
        try
        {
            try
            {
                JSONArray jsonarray = new JSONArray(input);
                for(int i=0; i<jsonarray.length(); i++)
                {
                    JSONObject obj         = jsonarray.getJSONObject(i);
                    String title           = obj.getString("title");
                    String color           = obj.getString("color");
                    Boolean trash          = obj.getBoolean("trash");
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
