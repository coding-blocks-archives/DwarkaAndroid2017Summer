package com.codingblocks.permissions;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b = (Button) findViewById(R.id.btnCall);

        editText = (EditText) findViewById(R.id.etNumber);

        int permissionResult = ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);

        if (permissionResult == PackageManager.PERMISSION_GRANTED) {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_CALL);

            intent.setData(Uri.parse("tel:9968195588"));

            startActivity(intent);
        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 123);
//            Intent intent = new Intent();
//            intent.setAction(Intent.ACTION_CALL);
//
//            intent.setData(Uri.parse("tel:9968195588"));
//
//            startActivity(intent);
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {

        if (requestCode == 123) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.CALL_PHONE)){

            }
            if (permissions[0].equals(Manifest.permission.CALL_PHONE)
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_CALL);

                intent.setData(Uri.parse("tel:9968195588"));

                startActivity(intent);
            }
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

//    void callPhone() {
//        b.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String number = editText.getText().toString();
//
//                Intent intent = new Intent();
//                intent.setAction(Intent.ACTION_CALL);
//
//                intent.setData(Uri.parse("tel:" + number));
//
//                startActivity(intent);
//
//            }
//        });
//    }
}
