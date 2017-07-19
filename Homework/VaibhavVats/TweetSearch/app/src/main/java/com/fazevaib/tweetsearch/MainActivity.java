package com.fazevaib.tweetsearch;

import android.content.DialogInterface;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton b1;
    public static final String BASE_URL = "https://loklak.org/api/search.json?q=";
    String text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1= (FloatingActionButton)findViewById(R.id.floatingActionButton);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView1);

        final ArrayList<Status> statusArrayList = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(this,statusArrayList);
        recyclerView.setAdapter(recyclerViewAdapter);

        final OkHttpClient okHttpClient = new OkHttpClient();

        final LinearLayout l = (LinearLayout)getLayoutInflater().inflate(R.layout.dialog_layout, null);


        final AlertDialog dialog = new AlertDialog.Builder(MainActivity.this)
                .setTitle("Search")
                .setView(l)
                .setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        statusArrayList.clear();
                        final EditText editText = (EditText)l.findViewById(R.id.editText1);
                        text = editText.getText().toString();
                        final Request request = new Request.Builder()
                                .url(BASE_URL + text).build();

                        okHttpClient.newCall(request).enqueue(new Callback() {
                            @Override
                            public void onFailure(Call call, IOException e) {
                                Log.e("TAG", "onFailure: "+e.getLocalizedMessage());
                                Log.e("TAG", "onFailure: " + call.request().url());
                            }

                            @Override
                            public void onResponse(Call call, Response response) throws IOException {
                                String result = response.body().string();

                                Gson gson = new Gson();

                                final Tweets tweets = gson.fromJson(result, Tweets.class);

                                MainActivity.this.runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {

                                        statusArrayList.addAll(tweets.getStatuses());
                                        recyclerViewAdapter.notifyDataSetChanged();
                                        editText.setText("");
                                    }
                                });

                            }
                        });
                    }
                }).create();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                dialog.show();

            }
        });

    }
}
