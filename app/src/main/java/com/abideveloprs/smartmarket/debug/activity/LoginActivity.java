package com.abideveloprs.smartmarket.debug.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;

import com.abideveloprs.smartmarket.debug.parser.profileJsonParser;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.abideveloprs.smartmarket.debug.GlobalClass;
import com.abideveloprs.smartmarket.debug.R;

import at.markushi.ui.CircleButton;
import cz.msebera.android.httpclient.Header;


public class LoginActivity extends AppCompatActivity{

    EditText fullnameET,mobileET,passwordET;
    SharedPreferences prefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        GlobalClass.overrideFont(getApplicationContext(), "SERIF", "Yekan.ttf");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_master);
        GlobalClass.context=this;

        prefs= getSharedPreferences(GlobalClass.PREFS_NAME, MODE_PRIVATE);
        if(prefs.getString("login", "").equalsIgnoreCase("success")){

            Intent intent=new Intent(GlobalClass.context,MainActivity.class);
            startActivity(intent);
            finish();

        }



        fullnameET = (EditText) findViewById(R.id.fullname);
        mobileET= (EditText) findViewById(R.id.mobile);
        passwordET= (EditText) findViewById(R.id.password);


        ViewGroup group = (ViewGroup) getWindow().getDecorView().findViewById(android.R.id.content);
        GlobalClass.setAllTextView(group);


        CircleButton login = (CircleButton)findViewById(R.id.login);
        login.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(final View view) {

//                Calendar c = Calendar.getInstance();
//                SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss aa");
//                String datetime = dateformat.format(c.getTime());
//                System.out.println(datetime);
//
//                String encrypted="";
//                MCrypt mcrypt = new MCrypt();
//                try {
//                    encrypted = MCrypt.bytesToHex(mcrypt.encrypt("09179168433,"+datetime));
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }

                final String mobile   =mobileET.getText().toString();
                final String password =passwordET.getText().toString();
                RequestParams params = new RequestParams();
                params.put("mobile", mobile);
                params.put("password", password);

                AsyncHttpClient client = new AsyncHttpClient();
                client.get(GlobalClass.apiaddress+"login", params,new AsyncHttpResponseHandler() {

                    @Override
                    public void onStart() {
                        // called before request is started
                    }

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, byte[] response) {
                        // called when response HTTP status is "200 OK"
                        //String s = new String(response);
                        //System.out.println("***************   Text Decryted : " + s);

                        SharedPreferences.Editor editor = getSharedPreferences(GlobalClass.PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putString("login", "success");
                        editor.putString("mobile", mobile);
                        editor.putString("password", password);
                        editor.apply();

                        profileJsonParser pjp=new profileJsonParser();

                        if(pjp.profileJsonParserInput(new String (response))){

                        Intent intent=new Intent(GlobalClass.context,MainActivity.class);
                        startActivity(intent);
                        finish();



                        }
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, byte[] errorResponse, Throwable e) {
                        // called when response HTTP status is "4XX" (eg. 401, 403, 404)
                        String s = new String(errorResponse);
                        System.out.println("***************   Text Error : " + s);

                        GlobalClass.SnackbarShow(findViewById(android.R.id.content),"شماره موبایل یا رمز ورود اشتباه می باشد!");
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

