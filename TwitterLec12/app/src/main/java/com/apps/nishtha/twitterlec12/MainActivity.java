package com.apps.nishtha.twitterlec12;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
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

    ProgressDialog progressDialog;
    RecyclerView recyclerView;
    //    Button btnGo;
    FloatingActionButton floatingButton;
    //    EditText editText;
    OkHttpClient okHttpClient;
    String userName;
    String baseUrl = "http://loklak.org/api/search.json?q=";
    ArrayList<Statuses> statusesArrayList = new ArrayList<>();
    EditText editTextDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recView);
        final TweetAdapter tweetAdapter = new TweetAdapter(statusesArrayList, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerView.setAdapter(tweetAdapter);
//        btnGo = (Button) findViewById(R.id.btnGo);
        okHttpClient = new OkHttpClient();
//        editText = (EditText) findViewById(R.id.editText);
        floatingButton = (FloatingActionButton) findViewById(R.id.floatingButton);


//        statusesArrayList=new ArrayList<>();  //NOT AGAIN! now pointing to a new location other than where Adapter is pointing

        floatingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final View v = ((LayoutInflater.from(MainActivity.this))).inflate(R.layout.alert_dialog, null, false);
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog
                        .setView(v)
                        .setTitle("Search tweets")
                        .setIcon(R.drawable.twitter_icon)
                        .setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                editTextDialog = v.findViewById(R.id.editTextDialog);
                                userName = editTextDialog.getText().toString();
                                Request request = new Request.Builder()
                                        .url(baseUrl + userName)
                                        .build();
                                okHttpClient.newCall(request).enqueue(new Callback() {
                                    @Override
                                    public void onFailure(Call call, IOException e) {
                                        Log.e("TAG", "onFailure: " + e.getLocalizedMessage());
                                    }

                                    @Override
                                    public void onResponse(Call call, Response response) throws IOException {

                                        MainActivity.this.runOnUiThread(new Runnable() {    //TODO
                                            @Override
                                            public void run() {
                                                progressDialog = new ProgressDialog(MainActivity.this);
                                                progressDialog.show();
                                            }
                                        });

                                        String result = response.body().string();
                                        Gson gson = new Gson();
                                        final Tweet tweet = gson.fromJson(result, Tweet.class);

                                        MainActivity.this.runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                progressDialog.hide();
//                                                Log.d("TAG text : ", "run: " + tweet.getStatuses());
//                                                Log.d("TAG user screen name ", "run: " + tweet.getStatuses().size());
                                                Log.d("TAG size AL ", "run: " + statusesArrayList.size());
                                                if (statusesArrayList.size() != 0) {
                                                    statusesArrayList.clear();
                                                    tweetAdapter.notifyDataSetChanged();

                                                    //All this didnt work!!
//                                                    for(int i=0;i<statusesArrayList.size();i++){
//                                                        statusesArrayList.remove(i);   //why?
//                                                    }
//                                                    statusesArrayList=new ArrayList<Statuses>();//new lcation in mmemory
//                                                    statusesArrayList.removeAll(tweet.getStatuses());


//

                                                }
                                                statusesArrayList.addAll(tweet.getStatuses());
                                                if (statusesArrayList.size() == 0) {  //TODO

                                                    Toast.makeText(MainActivity.this, "No results found", Toast.LENGTH_SHORT).show();

                                                    final Snackbar snackbar = Snackbar.make(new CoordinatorLayout(MainActivity.this), "No results found", Snackbar.LENGTH_SHORT);
                                                    snackbar.setAction("Ok", new View.OnClickListener() {
                                                        @Override
                                                        public void onClick(View view) {
                                                            snackbar.dismiss();
                                                        }
                                                    });
                                                    TextView textSnackbar = snackbar.getView().findViewById(android.support.design.R.id.snackbar_text);
                                                    textSnackbar.setTextColor(Color.CYAN);
                                                    snackbar.setActionTextColor(Color.RED);
                                                    snackbar.show();
//                                                }
                                                    tweetAdapter.notifyDataSetChanged();
                                                }
                                            }
                                        });
                                    }


                                });
                                dialogInterface.dismiss();
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {   //TODO
                                Log.d("TAG", "onClick: cancelled");
                                final Snackbar snackbar = Snackbar.make(new CoordinatorLayout(MainActivity.this), "Cancelled", Snackbar.LENGTH_SHORT);
                                snackbar.setAction("Ok", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        snackbar.dismiss();
                                    }
                                });
                                snackbar.setActionTextColor(Color.RED);
                                TextView textViewSnackbar = snackbar.getView().findViewById(android.support.design.R.id.snackbar_text);
                                textViewSnackbar.setTextColor(Color.CYAN);
                                snackbar.show();
                                dialogInterface.dismiss();
                            }
                        })
                        .show();
            }
        });

//        btnGo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                userName = editText.getText().toString();
//                Request request = new Request.Builder()
//                        .url(baseUrl + userName)
//                        .build();
//                okHttpClient.newCall(request).enqueue(new Callback() {
//                    @Override
//                    public void onFailure(Call call, IOException e) {
//                        Log.e("TAG", "onFailure: " + e.getLocalizedMessage());
//                    }
//
//                    @Override
//                    public void onResponse(Call call, Response response) throws IOException {
//                        String result = response.body().string();
//                        Gson gson = new Gson();
//                        final Tweet tweet = gson.fromJson(result, Tweet.class);
//
//                        MainActivity.this.runOnUiThread(new Runnable() {
//                            @Override
//                            public void run() {
//                                Log.d("TAG text : ", "run: " + tweet.getStatuses());
//                                Log.d("TAG user screen name ", "run: " + tweet.getStatuses().size());
//                                statusesArrayList.addAll(tweet.getStatuses());
//                                tweetAdapter.notifyDataSetChanged();
//                            }
//                        });
//                    }
//                });
//            }
//        });

    }
}
