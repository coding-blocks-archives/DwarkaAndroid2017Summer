package org.deepanshu.jakhar.tweetsearchapp;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    public static final String BASE_URL = "http://loklak.org/api/search.json?q=";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final OkHttpClient okHttpClient = new OkHttpClient();

        final ArrayList<Status> statusArrayLists = new ArrayList<>();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        final RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(statusArrayLists,this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerViewAdapter);


        LinearLayout l = (LinearLayout) getLayoutInflater().inflate(R.layout.dialog_view,null);
        final EditText editText = (EditText) l.findViewById(R.id.editText);

        final AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle("Search Dialog")
                .setView(l)
                .setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Request request = new Request.Builder().url(BASE_URL+editText.getText().toString()).build();

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

                                final Result r = gson.fromJson(result,Result.class);
                                MainActivity.this.runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        statusArrayLists.clear();
                                        statusArrayLists.addAll(r.getStatuses());
                                        recyclerViewAdapter.notifyDataSetChanged();
                                    }
                                });
                            }
                        });

                    }
                })
                .create();
        FloatingActionButton search = (FloatingActionButton) findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.show();
            }
        });


    }
}
