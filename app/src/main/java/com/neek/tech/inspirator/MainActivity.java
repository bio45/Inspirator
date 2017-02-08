package com.neek.tech.inspirator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.neek.tech.inspirator.datalayer.logic.RandomGenerator;
import com.neek.tech.inspirator.service.manager.InspiratorScheduleManager;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    /**
     * Schedule Manager reference to schedule tasks.
     */
    private InspiratorScheduleManager mScheduleManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RelativeLayout rootLayout = (RelativeLayout) findViewById(R.id.rootLayout);

        rootLayout.setBackgroundColor(RandomGenerator.getRandomColorId(this));

        final TextView scheduledTextView = (TextView) findViewById(R.id.scheduledTextView);

        mScheduleManager = new InspiratorScheduleManager(this);
        mScheduleManager.bindService();

        final Button startButton = (Button) findViewById(R.id.startButton);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                int time =  calendar.get(Calendar.MINUTE) + 1;
                calendar.set(Calendar.MINUTE, time);
                mScheduleManager.setAlarmForNotification(calendar);
                scheduledTextView.setVisibility(View.VISIBLE);
                startButton.setVisibility(View.GONE);
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        mScheduleManager.unBindService();
    }
}
