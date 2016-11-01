package com.bridge.gcmapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;

/**
 * Created by sec on 2016-09-02.
 */
public class MyPageActivity extends Activity{


    TextView txt_keyword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mypage);

        Intent intent = getIntent();

        Button AddKeyword = (Button)findViewById(R.id.addKeyword);

            AddKeyword.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String url = "http://52.78.7.192:3001/api/keywords";

                    HttpClient http = new DefaultHttpClient();
                    try {

                        ArrayList<NameValuePair> nameValuePairs =
                                new ArrayList<NameValuePair>();
                        nameValuePairs.add(new BasicNameValuePair("keyword", "졸업위원회"));


                        Log.d("mesage", String.valueOf(nameValuePairs));

                        HttpParams params = http.getParams();
                        HttpConnectionParams.setConnectionTimeout(params, 5000);
                        HttpConnectionParams.setSoTimeout(params, 5000);

                        HttpPost httpPost = new HttpPost(url);
                        UrlEncodedFormEntity entityRequest =
                                new UrlEncodedFormEntity(nameValuePairs, "utf-8");

                        httpPost.setEntity(entityRequest);

                        HttpResponse responsePost = http.execute(httpPost);
                        HttpEntity resEntity = responsePost.getEntity();

                        Log.d("message2", String.valueOf(resEntity));



                        txt_keyword.setText(EntityUtils.toString(resEntity));
                    }catch(Exception e){e.printStackTrace();}
                }
            });


    }
}
