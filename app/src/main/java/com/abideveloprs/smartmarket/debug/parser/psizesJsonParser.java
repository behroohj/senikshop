package com.abideveloprs.smartmarket.debug.parser;

import android.util.Log;

import com.abideveloprs.smartmarket.debug.orm.psizesORM;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by imanbahmani on 9/1/16 AD.
 */
public class psizesJsonParser {
    public Boolean psizesJsonParserInput(String input)
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


                    if ((int) psizesORM.count(psizesORM.class, "idapp = " + idapp, null) == 0) {
                        psizesORM psizes = new psizesORM();
                        psizes.setIdapp(idapp);
                        psizes.setName(name);
                        psizes.setProductheadid(productheadid);
                        psizes.setTrash(trash);
                        psizes.save();
                    } else {
                        List<psizesORM> notes = psizesORM.find(psizesORM.class, "idapp = " + idapp, null);
                        if (notes.size() > 0) {
                            psizesORM psizes = notes.get(0);
                            psizes.setIdapp(idapp);
                            psizes.setName(name);
                            psizes.setProductheadid(productheadid);
                            psizes.setTrash(trash);
                            psizes.save();
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
