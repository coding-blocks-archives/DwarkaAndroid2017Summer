package com.example.karanbalani.sharedprefrencesl13;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText input;
    Button okButton;
    TextView showSavedInput;
    String inputData;
    String TAG = "LOGGING";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = (EditText) findViewById(R.id.inputEditTextId);
        okButton = (Button) findViewById(R.id.buttonSaveId);
        showSavedInput = (TextView) findViewById(R.id.inputTextViewId);

        final SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE); //getSharedPreferences for custom file name
        final SharedPreferences.Editor editor = sharedPreferences.edit();

        String retrievedValue = sharedPreferences.getString("input", "null");
        showSavedInput.setText(retrievedValue);

                okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputData = input.getText().toString();
                editor.putString("input", inputData);
                editor.apply();


                showSavedInput.setText(sharedPreferences.getString("input", ""));
                Log.e(TAG, "onClick: "+ sharedPreferences.getString("input",""));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.menuSettings :
                Toast.makeText(this, "You selected "+ item.getTitle(), Toast.LENGTH_LONG).show();
                break;
            case R.id.menuAdd:
                Toast.makeText(this, "You selected "+ item.getTitle(), Toast.LENGTH_LONG).show();
                break;
            case R.id.menuDelete :
                Toast.makeText(this, "You selected "+ item.getTitle(), Toast.LENGTH_LONG).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
