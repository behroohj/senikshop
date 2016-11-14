package com.shirazapp.senikshop;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by imanbahmani on 9/1/16 AD.
 */
public class transactionJsonParser {
    public void transactionJsonParserInput(String input)
    {
        try
        {
            try
            {
                JSONArray jsonarray = new JSONArray(input);
                for(int i=0; i<jsonarray.length(); i++)
                {
                    JSONObject obj         = jsonarray.getJSONObject(i);
                    int id_master                 = obj.getInt("id_master");
                    int id                        = obj.getInt("id");
                    String trans                  = obj.getString("trans");
                    String price                  = obj.getString("price");
                    String national_code          = obj.getString("national_code");
                    String data                   = obj.getString("data");
                    String time                   = obj.getString("time");
                    String state                  = obj.getString("state");
                    String json                   = obj.getString("json");
                    String range                  = obj.getString("range");
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
