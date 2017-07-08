package com.saxena.ayushi.twitterapp;

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

    Button button;
    EditText editText;
    RecyclerView recyclerView;
    public static final String BASE_URL="http://loklak.org/api/search.json?q=";
    ArrayList<Statuses> statusesArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText= (EditText) findViewById(R.id.editText);
        recyclerView= (RecyclerView) findViewById(R.id.recyclerView);
        button= (Button) findViewById(R.id.button);

        statusesArrayList = new ArrayList<>();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        final TweetAdapter tweetAdapter = new TweetAdapter(statusesArrayList,this);
        recyclerView.setAdapter(tweetAdapter);

        final OkHttpClient okHttpClient = new OkHttpClient();
        button.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                String userName = editText.getText().toString();
                final Request request = new Request.Builder()
                        .url(BASE_URL + userName + "&maximumRecords=100")
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
                        Log.e("qwe",result);
                        Gson gson = new Gson();
                        final Twitter twitter = gson.fromJson(result,Twitter.class);
                        MainActivity.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                                statusesArrayList.clear();
                                statusesArrayList.addAll(twitter.getStatuses());
                                Log.e("TAG", "run: "+twitter.getStatuses() );
                                tweetAdapter.notifyDataSetChanged();
                            }
                        });
                    }
                });
            }
        });
    }
}
