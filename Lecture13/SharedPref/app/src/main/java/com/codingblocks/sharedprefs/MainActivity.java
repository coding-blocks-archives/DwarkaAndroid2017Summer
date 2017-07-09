package com.codingblocks.sharedprefs;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;
    Button button;

    public static final String INPUT = "input";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.etInput);
        textView = (TextView) findViewById(R.id.tvInput);
        button = (Button) findViewById(R.id.buttonSave);

        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);

        String retrievedValue = sharedPreferences.getString(INPUT,"0");

        textView.setText(retrievedValue);

        final SharedPreferences.Editor editor = sharedPreferences.edit();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = editText.getText().toString();

                editor.putString(INPUT,inputText);

                editor.apply();

                textView.setText(inputText);
            }
        });
    }
}
