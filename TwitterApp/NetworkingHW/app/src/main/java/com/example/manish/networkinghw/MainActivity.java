package com.example.manish.networkinghw;

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




    EditText editText;
    Button button;
    RecyclerView recyclerView;

    ArrayList<User> arrayList1 = new ArrayList<>();

    OkHttpClient okHttpClient = new OkHttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final OkHttpClient okHttpClient=new OkHttpClient();

        editText= (EditText) findViewById(R.id.editText);
        button = (Button)findViewById(R.id.button);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);


        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        final CAdapter adapter = new CAdapter(arrayList1,this);
        recyclerView.setAdapter(adapter);





        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username=editText.getText().toString();
                final Request request = new Request.Builder()
                        .url("http://loklak.org/api/search.json?q="+username)
                        .build();



                okHttpClient.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.e("TAG", "onFailure: " + e.getLocalizedMessage());
                        Log.e("TAG", "onFailure: " + call.request().url());
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        arrayList1.clear();
                        String result = response.body().string();

                        Gson gson = new Gson();

                        final Status status = gson.fromJson(result, Status.class);


//                        Log.e("TAG", "onResponse: " + users.getarrayList().size());

                        //Notify the adapter for data changes on the UI thread

                        MainActivity.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                                arrayList1.addAll(status.getStatuses());
                                adapter.notifyDataSetChanged();


                            }
                        });
                    }
                });
            }

        });




    }

}