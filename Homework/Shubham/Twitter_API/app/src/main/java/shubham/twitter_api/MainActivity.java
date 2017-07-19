package shubham.twitter_api;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
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

import static shubham.twitter_api.R.id.editText;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton floatingActionButton;
    ArrayList<Statuses> dataArrayList = new ArrayList<>();
    OkHttpClient okHttpClient = new OkHttpClient();
    public static final String BASE_URL = "http://loklak.org/api/search.json?q=";
    DataAdapter dataAdapter;
    AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        floatingActionButton = (FloatingActionButton) findViewById(R.id.floatingActionButton);

        final LinearLayout l = (LinearLayout) getLayoutInflater().inflate(R.layout.custom_dialog, null);
//        Snackbar.make(findViewById(android.R.id.content), "Please Wait", BaseTransientBottomBar.LENGTH_SHORT).show();
        dialog = new AlertDialog.Builder(this)
                //.setTitle("Enter your Text!")
                .setView(l)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Do Something!!
                        EditText edit = (EditText) l.findViewById(editText);
                        if (TextUtils.isEmpty(edit.getText())) {
                            Toast.makeText(MainActivity.this, "No Input", Toast.LENGTH_LONG).show();
                        } else {
                            String user = edit.getText().toString();
                            fun(user);
                            edit.getText().clear();
                        }
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Do not do Something!!
                        dialog.cancel();
                    }
                })
                .create();

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
            }
        });

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        dataAdapter = new DataAdapter(this, dataArrayList);
        recyclerView.setAdapter(dataAdapter);

    }

    public void fun(String userId) {
        Request request = new Request.Builder().
                url(BASE_URL + userId).
                build();

        final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Please Wait!");
        progressDialog.setCancelable(false);
        progressDialog.show();

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

                final Data data = gson.fromJson(result, Data.class);
//                dataArrayList.addAll(data.getStatuses());
                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        dataArrayList.clear();
                        dataArrayList.addAll(data.getStatuses());
                        progressDialog.hide();
                        dataAdapter.notifyDataSetChanged();
                    }
                });
            }
        });
    }
}
