package com.codingblocks.customasynctask;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpActivity extends AppCompatActivity {

    private static final String TAG = "OkHTTPActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp);
        OkHttpClient client = new OkHttpClient();

        final Request request = new Request.Builder()
                .url("https://jsonplaceholder.typicode.com/posts")
                .build();

        /*
        Starts a request on the main thread, so call this inside an AsyncTask instead
        try {
            client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        */


        //Starts a request on the background thread alongwith callbacks for the call completion
        //and failure

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e(TAG, "onFailure: " + e.getLocalizedMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.e(TAG, "onResponse: " + response.body().toString());
            }
        });
    }

}
