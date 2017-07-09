package com.bac.nikuson.twitter_api;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.BaseTransientBottomBar;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
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
    OkHttpClient okhttpclient = new OkHttpClient();
     String s;
    UserList userList;
    ArrayList<Statuses> statuses = new ArrayList<>();
    RecyclerVIewAdapter recyclerVIewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerVIewAdapter = new RecyclerVIewAdapter(statuses,MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerVIewAdapter);
        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.FAB);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                View mv = getLayoutInflater().inflate(R.layout.dialog,null);
                final EditText editText = (EditText) mv.findViewById(R.id.editText1);
                alertDialog.setTitle("Searchbox");
                alertDialog.setMessage("Enter User Id :");
                alertDialog.setIcon(R.drawable.twitter);
                alertDialog.setPositiveButton("Search", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (!editText.getText().toString().isEmpty())
                        {
                            s = editText.getText().toString();
                            editText.setText("");
                            RequestCall(s);
                        }

                    }
                });
                alertDialog.setView(mv);
                AlertDialog Dialog = alertDialog.create();
                Dialog.setCancelable(true);
                Dialog.hide();
                Dialog.show();


            }
        });
    }
    public void RequestCall(String s1)
    {
        s1 = s;
        Request request = new Request.Builder().url("http://loklak.org/api/search.json?q="+s1).build();
        okhttpclient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Snackbar.make(findViewById(android.R.id.content),"Failed Response", BaseTransientBottomBar.LENGTH_SHORT).show();
                Log.e("TAG", "onFailure: "+call.request().url() );
                Log.e("TAG", "onFailure: " );
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = "";
                result = response.body().string();
                Gson gson = new Gson();

                Log.e("TAG", "onResponse: " +call.request().url());

                 userList =  gson.fromJson(result,UserList.class);
                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        statuses.addAll(userList.getStatuses());
                        Log.e("TAG", "size "+statuses.size() );
                        recyclerVIewAdapter.notifyDataSetChanged();
                    }
        });

    }
});
    }}