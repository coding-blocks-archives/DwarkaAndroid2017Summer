package com.codingblocks.mediaplayer;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import java.io.IOException;

import static android.view.View.GONE;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Uri uri = Uri.parse("android.resource://com.codingblocks.mediaplayer/" + R.raw.audio);
//        mp = MediaPlayer.create(this, uri);
        Uri uri = Uri.parse("https://raw.githubusercontent.com/the-dagger/sample-media/master/audio.mp3");
        mp = new MediaPlayer();

        mp.setAudioStreamType(AudioManager.STREAM_MUSIC);

        try {
            mp.setDataSource(this, uri);

            mp.prepareAsync();

            final ProgressBar pb = (ProgressBar) findViewById(R.id.progressBar);

            mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    pb.setVisibility(View.GONE);
                    mp.start();
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }

        mp.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mp.release();
    }
}
