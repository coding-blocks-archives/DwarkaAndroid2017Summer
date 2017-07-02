package com.codingblocks.customasynctask;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button button;
    MyAsyncTask myAsyncTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        button = (Button) findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myAsyncTask = new MyAsyncTask();
                myAsyncTask.execute("https://jsonplaceholder.typicode.com/posts");
            }
        });
    }


    //Create a new AsyncTask
    class MyAsyncTask extends AsyncTask<String, Integer, String> {

        ProgressDialog progressDialog;


        //Runs on a different thread
        @Override
        protected String doInBackground(String... params) {

            //Get the URL from input param
            String url1 = params[0];

            String result = "";
            try {
                URL url = new URL(url1);
                //Create a URL Connection
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                //Set the request method (POST or GET)
                httpURLConnection.setRequestMethod("GET");
                //Set Read timeout
                httpURLConnection.setReadTimeout(3000);
                //Set Connection timeout
                httpURLConnection.setConnectTimeout(5000);
                //Connect
                httpURLConnection.connect();

                //Throw an exception if the response was not 200
                if (httpURLConnection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                    throw new IOException("HTTP error code" + httpURLConnection.getResponseCode());
                }

                //Read the data as InputStread from response
                InputStream inputStream = httpURLConnection.getInputStream();

                //Convert the byteArray into characterStream and stores to the disk
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

                //Create a BufferedReader from the InputStream which stores the result to a memory, resulting in faster I/O
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                //Create a StringBuilder to store the result
                StringBuilder stringBuilder = new StringBuilder();
                String line;

                //Read the input and stroe it to StringBuilder line by line
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line);
                }
                //Save the result to a string
                result = stringBuilder.toString();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


            //Parse the received JSON
            try {
                JSONArray jsonArray = new JSONArray(result);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject currentObject = jsonArray.getJSONObject(i);
                    String userID = currentObject.getString("userId");
                    Log.e("TAG", "onCreate: " + userID);
                }
            } catch (JSONException e) {
                e.printStackTrace();
                Log.e("TAG", "onCreate: JSON is invalid");
            }

            return result;
        }

        //Runs on UI thread
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setMessage("Please wait");
            progressDialog.setCancelable(false);
            progressDialog.show();

        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

        }

        //Runs on UI thread
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            progressDialog.hide();

        }
    }

}
