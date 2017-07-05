package com.codingblocks.githubapi;

import android.content.Intent;
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

    //http://api.github.com/search/users?q=dagger
    public static final String BASE_URL = "http://api.github.com/search/users?q=";
    ArrayList<User> usersArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final OkHttpClient okHttpClient = new OkHttpClient();
        final EditText editText = (EditText) findViewById(R.id.editTextName);
        Button button = (Button) findViewById(R.id.buttonSearch);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerViewUsers);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        /*
        Getting serialized data
         */

//        Intent i = getIntent();
//
//        String receivedUser = i.getStringExtra("USER");
//        Gson gson = new Gson();
//
//
//        User user = gson.fromJson(receivedUser, User.class);

        final RecylerViewAdapter recylerViewAdapter = new RecylerViewAdapter(usersArrayList);
        recyclerView.setAdapter(recylerViewAdapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = editText.getText().toString();


                final Request request = new Request.Builder()
                        .url("http://api.github.com/search/users?q=" + userName)
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

                        Log.e("TAG", "onResponse: " + users.getUserArrayList().size());

                        //Notify the adapter for data changes on the UI thread

                        MainActivity.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                usersArrayList.addAll(users.getUserArrayList());
                                recylerViewAdapter.notifyDataSetChanged();
                            }
                        });
                    }
                });
            }
        });


    }
}
