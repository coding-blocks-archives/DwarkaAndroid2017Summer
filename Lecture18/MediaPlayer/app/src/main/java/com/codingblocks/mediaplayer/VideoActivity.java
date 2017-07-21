package com.codingblocks.mediaplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        final VideoView vv = (VideoView) findViewById(R.id.videoView);

        vv.setVideoPath("https://raw.githubusercontent.com/the-dagger/sample-media/master/video.mp4");

        MediaController mediaController = new MediaController(this, true);

        mediaController.setPrevNextListeners(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //next
                vv.getCurrentPosition();
            }
        }, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //prev
            }
        });

        vv.setMediaController(mediaController);

        vv.start();

    }
}
