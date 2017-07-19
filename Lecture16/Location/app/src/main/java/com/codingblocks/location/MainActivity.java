package com.codingblocks.location;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements LocationListener{
    AlertDialog alertDialog;
    public static final String TAG = "LocationActivity";
    LocationManager lm;
    LocationListener lListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        lm = (LocationManager) getSystemService(LOCATION_SERVICE);


//        lListener = new LocationListener() {
//            @Override
//            public void onLocationChanged(Location location) {
//
//                Log.d(TAG, "onLocationChanged: getProvider " + location.getProvider());
//                Log.d(TAG, "onLocationChanged: getLatitude " + location.getLatitude());
//                Log.d(TAG, "onLocationChanged: getLongitude " + location.getLongitude());
//                Log.d(TAG, "onLocationChanged: getAccuracy " + location.getAccuracy());
//                Log.d(TAG, "onLocationChanged: getAltitude " + location.getAltitude());
//                Log.d(TAG, "onLocationChanged: getSpeed " + location.getSpeed());
//                Log.d(TAG, "onLocationChanged: getElapsedRealtimeNanos " + location.getElapsedRealtimeNanos());
//                Log.d(TAG, "onLocationChanged: getBearing " + location.getBearing());
//                Log.d(TAG, "onLocationChanged: getTime " + location.getTime());
//            }
//
//            @Override
//            public void onStatusChanged(String provider, int status, Bundle extras) {
//
//            }
//
//            @Override
//            public void onProviderEnabled(String provider) {
//
//            }
//
//            @Override
//            public void onProviderDisabled(String provider) {
//
//            }
//        };



        lm.addGpsStatusListener(new GpsStatus.Listener() {

            @Override
            public void onGpsStatusChanged(int event) {
                //// TODO: 7/16/17
            }
        });



        alertDialog = new AlertDialog.Builder(this)
                .setTitle("Enable Location")
                .setMessage("Looks like you have disabled the location, enable it?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .create();

    }

    @Override
    protected void onResume() {
        super.onResume();
        lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,
                20000,
                0,
                this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        lm.removeUpdates(this);
    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {
        alertDialog.show();
    }
}
