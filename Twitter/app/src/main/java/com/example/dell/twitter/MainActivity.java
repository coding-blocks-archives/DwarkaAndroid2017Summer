package com.example.dell.twitter;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

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
    String s="";
    ArrayList<Status> dataArrayList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button)findViewById(R.id.button);
        editText=(EditText)findViewById(R.id.editText);
        ListView listView=(ListView)findViewById(R.id.list_view);
        final DataAdapter dataAdapter=new DataAdapter(dataArrayList,this);
        listView.setAdapter(dataAdapter);
        final OkHttpClient okHttpClient = new OkHttpClient();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s=editText.getText().toString();
                editText.setText("");
                Request request=new Request.Builder().url("http://loklak.org/api/search.json?timezoneOffset=-330&q="+s).build();
                okHttpClient.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.e("TAG", "onFailure:" );
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String result=response.body().string();
                        Gson gson=new Gson();
                        final UserList userList=gson.fromJson(result,UserList.class);
                        MainActivity.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                dataArrayList.addAll(userList.getStatuses());
                                Log.e("TAG", "size "+dataArrayList.size() );
                                dataAdapter.notifyDataSetChanged();
                            }
                        });
                    }
                });

            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(dataArrayList.get(position).getLink()));
                startActivity(intent);
            }
        });
    }
}