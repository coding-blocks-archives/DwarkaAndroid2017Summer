package com.example.karanbalani.twittersearchl12;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    String BASE_URL = "http://loklak.org/api/search.json?q=";
    String TAG = "Logging";
    InitialResult initialResult;
    FloatingActionButton floatingActionButton;
    String userQuery;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //NetworkingAndParsing("google");

        recyclerView = (RecyclerView) findViewById(R.id.statusesRecyclerViewId);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        floatingActionButton = (FloatingActionButton) findViewById(R.id.floatingActionButton);


        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder customSearch = new AlertDialog.Builder(MainActivity.this);
                View customDialogLayout = (LinearLayout) getLayoutInflater().inflate(R.layout.dialog_layout, null);
                final EditText searchEditText = (EditText) customDialogLayout.findViewById(R.id.searchEditTextId);
                customSearch.setView(customDialogLayout).setTitle("Custom Search").setPositiveButton("SUBMIT", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if(TextUtils.isEmpty(searchEditText.getText())){
                            Toast.makeText(MainActivity.this, "No Input", Toast.LENGTH_LONG).show();
                        }
                        else{
                            userQuery = searchEditText.getText().toString();
                            NetworkingAndParsing(userQuery);
                        }
                    }
                }).setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                }).create();

                customSearch.show();
            }
        });

    }

    public void NetworkingAndParsing(String query){
        OkHttpClient okHttpClient = new OkHttpClient();

        final Request request = new Request.Builder()
                .url(BASE_URL + query)
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e(TAG, "onFailure: " + e.getLocalizedMessage());
                Log.e(TAG, "onFailure: " + call.request().url() );
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();

                Gson gson = new Gson();

                initialResult = gson.fromJson(result, InitialResult.class);

                Log.e(TAG, "onResponse: " + result );
                Log.e(TAG, "onResponse: " + initialResult.statuses.get(0).getText() );

                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        RecyclerStatusAdapter adapter = new RecyclerStatusAdapter(initialResult.statuses, MainActivity.this);
                        recyclerView.setAdapter(adapter);
                    }
                });
            }
        });
    }
}
