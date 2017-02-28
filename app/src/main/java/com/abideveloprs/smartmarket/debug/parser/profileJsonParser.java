package com.abideveloprs.smartmarket.debug.parser;

import android.util.Log;

import com.abideveloprs.smartmarket.debug.orm.profileORM;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by imanbahmani on 9/1/16 AD.
 */
public class profileJsonParser {
    public Boolean profileJsonParserInput(String input)
    {
        try
        {
            try
            {
                JSONArray jsonarray = new JSONArray(input);
                for(int i=0; i<jsonarray.length(); i++) {
                    JSONObject obj = jsonarray.getJSONObject(i);

                    int    idapp        =   obj.   getInt("id");
                    String name         =   obj.getString("name");
                    String family       =   obj.getString("family");
                    String mobile       =   obj.getString("mobile");
                    String email        =   obj.getString("email");
                    String city         =   obj.getString("city");
                    String pass         =   obj.getString("pass");
                    String hash         =   obj.getString("hash");
                    String devicemodel  =   obj.getString("device_model");
                    String date         =   obj.getString("date");
                    String time         =   obj.getString("time");
                    String postalcode   =   obj.getString("postal_code");
                    String tell         =   obj.getString("tell");
                    String state        =   obj.getString("state");
                    String reagent      =   obj.getString("reagent");


                    if ((int) profileORM.count(profileORM.class, "idapp = " + idapp, null) == 0) {
                        profileORM profile = new profileORM();
                        profile.setIdapp(idapp);
                        profile.setName(name);
                        profile.setFamily(family);
                        profile.setMobile(mobile);
                        profile.setEmail(email);
                        profile.setCity(city);
                        profile.setPass(pass);
                        profile.setHash(hash);
                        profile.setDevicemodel(devicemodel);
                        profile.setDate(date);
                        profile.setTime(time);
                        profile.setPostalcode(postalcode);
                        profile.settell(tell);
                        profile.setState(state);
                        profile.setReagent(reagent);
                        profile.save();
                    } else {
                        List<profileORM> notes = profileORM.find(profileORM.class, "idapp = " + idapp, null);
                        if (notes.size() > 0) {
                            profileORM profile = notes.get(0);
                            profile.setIdapp(idapp);
                            profile.setName(name);
                            profile.setFamily(family);
                            profile.setMobile(mobile);
                            profile.setEmail(email);
                            profile.setCity(city);
                            profile.setPass(pass);
                            profile.setHash(hash);
                            profile.setDevicemodel(devicemodel);
                            profile.setDate(date);
                            profile.setTime(time);
                            profile.setPostalcode(postalcode);
                            profile.settell(tell);
                            profile.setState(state);
                            profile.setReagent(reagent);
                            profile.save();
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
