package com.codingblocks.gurleen.twittergo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    Request request;
    EditText ed;
    Button b;
    String username;
    String api;
    Callback callback;
    RecyclerView rv;
    results resultobj;
    OkHttpClient okHttpClient;
    MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed = (EditText)findViewById(R.id.textv);
        b=(Button)findViewById(R.id.searchb);
        api= "https://loklak.org/api/search.json?q=";
        okHttpClient = new OkHttpClient();
        rv=(RecyclerView)findViewById(R.id.rv);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(layoutManager);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                username = ed.getText().toString();
                request = new Request.Builder()
                        .url(api+username)
                        .build();
                okHttpClient.newCall(request).enqueue(callback);


            }
        });



        callback = new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("TAG", "onFailure: " + e.getLocalizedMessage());
                Log.e("TAG", "onFailure: " + call.request().url());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
                Log.e("TAG", "" + result);
                Gson gson = new Gson();

                resultobj  = gson.fromJson(result,results.class);


                //Notify the adapter for data changes on the UI thread

                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                       myAdapter = new MyAdapter(resultobj,MainActivity.this);
                        rv.setAdapter(myAdapter);





                    }
                });
            }
        };


























    }














}