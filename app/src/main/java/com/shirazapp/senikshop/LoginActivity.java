package com.shirazapp.senikshop;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import at.markushi.ui.CircleButton;
import cz.msebera.android.httpclient.Header;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        GlobalClass.overrideFont(getApplicationContext(), "SERIF", "Yekan.ttf");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_master);

        GlobalClass.context=this;
        ViewGroup group = (ViewGroup) getWindow().getDecorView().findViewById(android.R.id.content);
        GlobalClass.setAllTextView(group);


        CircleButton login = (CircleButton)findViewById(R.id.login);
        login.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                Calendar c = Calendar.getInstance();
                SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss aa");
                String datetime = dateformat.format(c.getTime());
                System.out.println(datetime);

                String encrypted="";
                MCrypt mcrypt = new MCrypt();
                try {
                    encrypted = MCrypt.bytesToHex(mcrypt.encrypt("09179168433,"+datetime));
                } catch (Exception e) {
                    e.printStackTrace();
                }


                RequestParams params = new RequestParams();
                params.put("string", encrypted);

                AsyncHttpClient client = new AsyncHttpClient();
                client.post("http://abi-developers.com/shopadmin/rest/login", params,new AsyncHttpResponseHandler() {

                    @Override
                    public void onStart() {
                        // called before request is started
                    }

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, byte[] response) {
                        // called when response HTTP status is "200 OK"
                        String s = new String(response);
                        System.out.println("***************   Text Decryted : " + s);
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, byte[] errorResponse, Throwable e) {
                        // called when response HTTP status is "4XX" (eg. 401, 403, 404)
                        System.out.println("***************   Text Error : " + errorResponse);
                    }

                    @Override
                    public void onRetry(int retryNo) {
                        // called when request is retried
                    }
                });

//
//                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
//                startActivity(intent);
            }
        });

    }
}

