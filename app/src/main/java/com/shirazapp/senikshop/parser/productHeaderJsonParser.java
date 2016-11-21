package com.shirazapp.senikshop.parser;

import android.util.Log;

import com.shirazapp.senikshop.orm.pheader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.util.List;

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
                    int idapp              = obj.getInt("id");
                    String title           = obj.getString("title");
                    String color           = obj.getString("color");
                    String image           = obj.getString("image");
                    String trash           = obj.getString("trash");

//                    System.out.println(""+idApp);
//                    System.out.println(title);
//                    System.out.println(color);
//                    System.out.println(image);
//                    System.out.println(trash);

                    if((int) pheader.count(pheader.class, "idapp = "+idapp, null) == 0)
                    {
                        pheader productheader=new pheader();
                        productheader.setidapp(idapp);
                        productheader.setTitle(title);
                        productheader.setColor(color);
                        productheader.setImage(image);
                        productheader.setTrash(trash);
                        productheader.save();
                    }
                    else
                    {
                        List<pheader> notes = pheader.find(pheader.class, "idapp = "+idapp, null);
                        if (notes.size() > 0) {
                            pheader productheader= notes.get(0);
                            productheader.setidapp(idapp);
                            productheader.setTitle(title);
                            productheader.setColor(color);
                            productheader.setImage(image);
                            productheader.setTrash(trash);
                            productheader.save();
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
