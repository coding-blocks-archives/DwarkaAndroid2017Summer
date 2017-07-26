package com.codingblocks.jobscheduler;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("TAG", "onCreate: of Activity");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final JobScheduler jobScheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);

        ComponentName cn = new ComponentName(this,MyJobService.class);

        final JobInfo jobInfo = new JobInfo.Builder(123,cn)
                .setMinimumLatency(10000)
                .setOverrideDeadline(15000)
                .setRequiresCharging(true)
                .build();

        Button b = (Button) findViewById(R.id.btnSchedule);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jobScheduler.schedule(jobInfo);
            }
        });


    }
}
