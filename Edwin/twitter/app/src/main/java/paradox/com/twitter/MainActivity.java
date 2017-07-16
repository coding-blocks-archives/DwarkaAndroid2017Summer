package paradox.com.twitter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    Person person;
    String name;
    ImageButton button;
    EditText editText;
    RecyclerView personList;
    StatusAdapter statusAdapter;
    ArrayList<Status> statuses = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.search);
        personList = (RecyclerView) findViewById(R.id.recyclerView);
    }

    public void load(View view) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        personList.setLayoutManager(layoutManager);
        name = editText.getText().toString();
        OkHttpClient client = new OkHttpClient();
        final Request request = new Request.Builder()
                .url("http://loklak.org/api/search.json?q="+name)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("TAG", "onFailure: " + e.getLocalizedMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String res = response.body().string();
                Log.e("TAG", "onResponse: " + res);
                Gson gson = new Gson();
                person = gson.fromJson(res,Person.class);
                statuses = person.getStatuses();
                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        for(int i=0;i<person.getStatuses().size();i++)
                            Log.e("Status", "name: "+person.getStatuses().get(i).getUser().getName() );
                        statusAdapter = new StatusAdapter(statuses);
                        personList.setAdapter(statusAdapter);
                        statusAdapter.notifyDataSetChanged();
                    }
                });
            }
        });

    }
}
