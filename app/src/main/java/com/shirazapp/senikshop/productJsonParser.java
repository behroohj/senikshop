package com.shirazapp.senikshop;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
                for(int i=0; i<jsonarray.length(); i++)
                {
                    JSONObject obj         = jsonarray.getJSONObject(i);
                    int id                 = obj.getInt("id");
                    String title           = obj.getString("title");
                    String content         = obj.getString("content");
                    String image           = obj.getString("image");
                    String trash           = obj.getString("trash");
                    int commission         = obj.getInt("commission");
                    int stock              = obj.getInt("stock");
                    int price              = obj.getInt("price");
                    int percent            = obj.getInt("percent");
                    int product_head       = obj.getInt("product_head");
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
