package com.example.kashishchugh.twitter;

import android.app.ProgressDialog;
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
    ProgressDialog progressDialog;

    ArrayList<Statuses> statusesArrayList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressDialog=new ProgressDialog(this);
        final OkHttpClient okHttpClient = new OkHttpClient();
        final EditText editText= (EditText) findViewById(R.id.editText);
        Button button= (Button) findViewById(R.id.button);
        final RecyclerView recyclerView= (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final RecyclerViewAdapter recyclerViewAdapter=new RecyclerViewAdapter(statusesArrayList,this);
        recyclerView.setAdapter(recyclerViewAdapter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                statusesArrayList.clear();
                progressDialog.setMessage("Please wait");
                progressDialog.setCancelable(false);
                progressDialog.show();
                final String s=editText.getText().toString();
                final Request request = new Request.Builder().url("https://loklak.org/api/search.json?q="+s).build();

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
                        final Tweet tweeter = gson.fromJson(result, Tweet.class);
                        MainActivity.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                progressDialog.hide();
                                statusesArrayList.addAll(tweeter.getStatuses());
                                recyclerViewAdapter.notifyDataSetChanged();
                            }
                        });
                    }
                });
            }
        });
    }
}
