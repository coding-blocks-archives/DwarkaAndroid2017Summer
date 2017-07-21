package com.example.chato.twitter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    TextView name,screen_name, link,text;
    public static final String BASE_URL = "https://loklak.org/api/search.json?q=";
    ArrayList<Status> statusArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final OkHttpClient okHttpClient = new OkHttpClient();
        final EditText editText = (EditText) findViewById(R.id.editTextName);
        Button button = (Button) findViewById(R.id.buttonSearch);
         name = (TextView) findViewById(R.id.name);
         screen_name = (TextView) findViewById(R.id.screen_name);
         link = (TextView) findViewById(R.id.link);
         text = (TextView) findViewById(R.id.text);
       final ImageView profile_image_url_https=(ImageView)findViewById(R.id.profile_image_url_https);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerViewUsers);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        final RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(statusArrayList);
        recyclerView.setAdapter(recyclerViewAdapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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

                        Log.e("TAG", "onResponse: " + users.getStatusArrayList().size());

                        //Notify the adapter for data changes on the UI thread


                        MainActivity.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                                statusArrayList.addAll(users.getStatusArrayList());
                                recyclerViewAdapter.notifyDataSetChanged();




                            }
                        });
                    }
                });
            }
        });


    }
}