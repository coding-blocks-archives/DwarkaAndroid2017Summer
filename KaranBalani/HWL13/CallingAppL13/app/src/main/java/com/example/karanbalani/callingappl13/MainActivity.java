package com.example.karanbalani.callingappl13;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText inputPhone;
    Button callButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputPhone = (EditText) findViewById(R.id.phoneNumberEditTextId);
        callButton = (Button) findViewById(R.id.callButtonId);

        int permissionResult = ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);

        if (permissionResult == PackageManager.PERMISSION_GRANTED) {
            callPhone();
        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 123);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if(requestCode == 123){

            if(permissions[0].equals(Manifest.permission.CALL_PHONE) && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                callPhone();
            }

        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    void callPhone() {
        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String number = inputPhone.getText().toString();

                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_CALL);

                intent.setData(Uri.parse("tel:" + number));

                startActivity(intent);
            }
        });
    }
}
