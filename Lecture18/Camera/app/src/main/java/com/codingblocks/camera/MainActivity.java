package com.codingblocks.camera;

import android.hardware.Camera;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Surface;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Camera";
    Camera c;
    CameraView cameraView;
    ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getCameraParams(){
        List<Camera.Size> pictureSizes = c.getParameters().getSupportedPictureSizes();

        for (Camera.Size s : pictureSizes){
            Log.d(TAG, "Picture width " + s.width + " height " + s.height);
        }

        List<Camera.Size> videoSizes = c.getParameters().getSupportedVideoSizes();

        for (Camera.Size s : videoSizes){
            Log.d(TAG, "Video width " + s.width + " height " + s.height);
        }

        List<Camera.Size> previewSizes = c.getParameters().getSupportedPreviewSizes();

        for (Camera.Size s : previewSizes){
            Log.d(TAG, "Preview width " + s.width + " height " + s.height);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        c = Camera.open();
        int currentOrientation = getWindowManager().getDefaultDisplay().getRotation();

        switch (currentOrientation){

            case Surface.ROTATION_0 :
                c.setDisplayOrientation(90);
                break;
            case Surface.ROTATION_90:
                c.setDisplayOrientation(0);
                break;
            case Surface.ROTATION_180:
                c.setDisplayOrientation(270);
                break;
            case Surface.ROTATION_270:
                c.setDisplayOrientation(180);
        }


        constraintLayout = (ConstraintLayout) findViewById(R.id.constraintLayout);


        cameraView = new CameraView(this,c);

        constraintLayout.addView(cameraView);

    }

    @Override
    protected void onStop() {
        super.onStop();
        c.release();
        constraintLayout.removeView(cameraView);
    }

    public void takePic(View view) {
        c.takePicture(null, new Camera.PictureCallback() {
            @Override
            public void onPictureTaken(byte[] rawData, Camera camera) {
                //raw format
            }
        }, new Camera.PictureCallback() {
            @Override
            public void onPictureTaken(byte[] data, Camera camera) {
                //jpeg format
//                camera.startPreview();
            }
        });
    }
}
