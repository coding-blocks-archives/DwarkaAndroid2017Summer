package com.codingblocks.firebasesample;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.BaseTransientBottomBar;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final LinearLayout l = (LinearLayout) getLayoutInflater().inflate(R.layout.custom_dialog,null);

//        final
        Snackbar.make(findViewById(android.R.id.content),"Hello", BaseTransientBottomBar.LENGTH_INDEFINITE).show();

        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("This is a dialog")
                .setView(l)
                .setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        EditText editText = (EditText) l.findViewById(R.id.editText);
//                        TextView textView = l.findViewById(R.id.textView);
//                        textView.setText(editText.getText().toString());

                        Toast.makeText(MainActivity.this,editText.getText().toString(),Toast.LENGTH_SHORT).show();
                    }
                })
                .create();

        dialog.show();
    }
}
