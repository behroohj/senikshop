package com.abideveloprs.smartmarket.debug;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;

import java.lang.reflect.Field;

/**
 * Created by imanbahmani on 10/5/16 AD.
 */
public class GlobalClass {
    public static Context context;
    public static String PREFS_NAME = "MyShp"; //shared pref name
    public static String apiaddress="http://farspars.ir/newshop/rest/";
    public static String imagesaddress="http://farspars.ir/newshop/upimg/";



    public static void ImageCatch(Context con,ImageView imageView, String URL)
    {
        Glide
                .with(con)
                .load(URL)
                .placeholder(R.drawable.loadingplace)
                .into(imageView);
    }

    public static void SnackbarShow(View AndroidRIdContent,String msg){
        Snackbar.make(AndroidRIdContent, msg, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    public static Context getContext() {
        return context;
    }

    public static boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }


    public static void overrideFont(Context context, String defaultFontNameToOverride, String customFontFileNameInAssets) {
        try {
            final Typeface customFontTypeface = Typeface.createFromAsset(context.getAssets(), customFontFileNameInAssets);

            final Field defaultFontTypefaceField = Typeface.class.getDeclaredField(defaultFontNameToOverride);
            defaultFontTypefaceField.setAccessible(true);
            defaultFontTypefaceField.set(null, customFontTypeface);
        } catch (Exception e) {
            Log.e("TypefaceUtil", "Can not set custom font " + customFontFileNameInAssets + " instead of " + defaultFontNameToOverride);
        }
    }

    public static void setAllTextView(ViewGroup parent) {
        for (int i = parent.getChildCount() - 1; i >= 0; i--) {
            final View child = parent.getChildAt(i);
            if (child instanceof ViewGroup) {
                setAllTextView((ViewGroup) child);
            } else if (child instanceof TextView) {
                ((TextView) child).setTypeface(getFont());
            }
        }
    }

    public static Typeface getFont() {
        return Typeface.createFromAsset(context.getAssets(), "Yekan.ttf");
    }
}
