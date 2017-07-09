package com.example.ashishchawla.twitter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
    final String BASE_URL = "http://loklak.org/api/search.json?q=";
   final ArrayList<Status> statusArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final OkHttpClient okHttpClient = new OkHttpClient();

       final EditText editText = (EditText) findViewById(R.id.editText);
        final Button button = (Button) findViewById(R.id.button);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        final RecyclerViewAdapter recyclerViewAdapter=new RecyclerViewAdapter(statusArrayList,this);
        recyclerView.setAdapter(recyclerViewAdapter);

       /* LinearLayout l=(LinearLayout)getLayoutInflater().inflate(R.layout.single_layout,null);

        final AlertDialog alertDialog=new AlertDialog.Builder(this)
                .setTitle("Search")
                .setView(l)
                .setPositiveButton("Submit", new DialogInterface.OnClickListener() { */

                          button.setOnClickListener(new View.OnClickListener() {
                                    @Override
                           public void onClick(View view) {

                        String userName = editText.getText().toString();
                        final Request request = new Request.Builder()
                                .url(BASE_URL + userName)
                                .build();

                        okHttpClient.newCall(request).enqueue(new Callback() {
                            @Override
                            public void onFailure(Call call, IOException e) {
                                Log.e("TAG", "onFailure: " + e.getLocalizedMessage());
                                Log.e("TAG", "onFailure: " + call.request().url());
                             }

                            @Override
                            public void onResponse(Call call, Response response) throws IOException {
                                String result = response.body().string();
                                Gson gson = new Gson();
                                final UserList users = gson.fromJson(result, UserList.class);
                                MainActivity.this.runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        statusArrayList.clear();
                                        statusArrayList.addAll(users.getStatuses());
                                        recyclerViewAdapter.notifyDataSetChanged();
                                        //statusArrayList.get(0).getUser().getName();

                                    }
                            });
                    }

                });

            }
        });
               /* .create();

        FloatingActionButton search=(FloatingActionButton)findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.show();

            }
        });*/


    }
}

