package com.codingblocks.camera;

import android.content.Context;
import android.hardware.Camera;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.IOException;

/**
 * Created by harshitdwivedi on 21/07/17.
 */

public class CameraView extends SurfaceView implements SurfaceHolder.Callback{

    Camera c;

    public CameraView(Context context, Camera camera) {
        super(context);
        this.c = camera;
        SurfaceHolder h = getHolder();

        h.addCallback(this);

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        try {
            c.setPreviewDisplay(holder);
            c.startPreview();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        c.stopPreview();
        try {
            c.setPreviewDisplay(holder);
            c.startPreview();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
//        c.release();
    }
}
