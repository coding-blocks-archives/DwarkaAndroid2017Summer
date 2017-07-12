package com.codingblocks.file;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";
    File f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText etName = (EditText) findViewById(R.id.etName);
        final EditText etContent = (EditText) findViewById(R.id.etcontent);
        final TextView tvFileContent = (TextView) findViewById(R.id.tvFileContent);
        Button btnRead = (Button) findViewById(R.id.btnRead);
        Button btnExtRead = (Button) findViewById(R.id.btnExtRead);
        Button btnExtWrite = (Button) findViewById(R.id.btnExtWrite);
        Button btnWrite = (Button) findViewById(R.id.btnWrite);

        btnExtRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                try {
                    FileInputStream fis =new FileInputStream(f);
//                    FileInputStream fis = new FileInputStream(f);
                    int read;
                    StringBuilder stringBuilder = new StringBuilder();
                    while ((read = fis.read()) != -1) {
                        stringBuilder.append((char) read);
                    }
                    tvFileContent.setText(stringBuilder.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        btnExtWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                String content = etContent.getText().toString();

                try {
                    f = new File(getExternalFilesDir(null),name);
                    Log.d(TAG, "onClick: " + f.getAbsolutePath());
                    if (!f.exists()){
                        f.createNewFile();
                    }
                    FileOutputStream fos = new FileOutputStream(f,true);
                    fos.write(content.getBytes());
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                String content = etContent.getText().toString();

                try {
                    File f = new File(getFilesDir(),name);
                    FileOutputStream fos = new FileOutputStream(f);
//                    FileOutputStream fos = getBaseContext().openFileOutput(name, MODE_APPEND);
                    fos.write(content.getBytes());
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                try {
                    FileInputStream fileInputStream = getBaseContext().openFileInput(name);
                    int read;
                    StringBuilder stringBuilder = new StringBuilder();
                    while ((read = fileInputStream.read()) != -1) {
                        stringBuilder.append((char) read);
                    }
                    tvFileContent.setText(stringBuilder.toString());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        File filesDir = getFilesDir();
        File externalFilesDir = getExternalFilesDir(null);
        File cacheDir = getCacheDir();
        File externalMusicDir = getExternalFilesDir(Environment.DIRECTORY_MUSIC);

        try {
            Log.d(TAG, "onCreate: filesDir : " + filesDir.getCanonicalPath());
            Log.d(TAG, "onCreate: cacheDir : " + cacheDir.getCanonicalPath());
            Log.d(TAG, "onCreate: externalMusicDir : " + externalMusicDir.getCanonicalPath());
            Log.d(TAG, "onCreate: externalFilesDir : " + externalFilesDir.getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
