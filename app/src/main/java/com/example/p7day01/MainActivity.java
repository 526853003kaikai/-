package com.example.p7day01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.p7day01.factory.ThreadManager;
import com.example.p7day01.factory2.ScheduleThread;
import com.example.p7day01.factory2.ThreadsManager;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button but1;
    private Button but2;
    private Button but3;
    private Button but4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        but1 = (Button) findViewById(R.id.but1);
        but2 = (Button) findViewById(R.id.but2);

        but1.setOnClickListener(this);
        but2.setOnClickListener(this);
        but3 = (Button) findViewById(R.id.but3);
        but3.setOnClickListener(this);
        but4 = (Button) findViewById(R.id.but4);
        but4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.but1:

                break;
            case R.id.but2:
                Phone miPhone = new PhoneFactory().cratePhone("miPhone");
                miPhone.makePhone();


                Phone iPhone = new PhoneFactory().cratePhone("iPhone");
                iPhone.makePhone();
                break;
            case R.id.but3:
                ThreadManager.myThreatPoolFactory(ThreadManager.CACHE_THREAD)
                        .executorThreat(runnable);
                break;

            case R.id.but4:
                ThreadsManager.mineThreadFactory(ThreadsManager.SCHEDULE_THREAD)
                        .executorThread(runnable);

                ThreadsManager.mineThreadFactory(ThreadsManager.CUSTOM_THREAD)
                        .executorThread(runnable);

                break;
        }
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {

        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ThreadManager.myThreatPoolFactory(ThreadManager.CACHE_THREAD)
                .deleteThread(runnable);

        ThreadsManager.mineThreadFactory(ThreadsManager.SCHEDULE_THREAD)
                .removeThread(runnable);

        ThreadsManager.mineThreadFactory(ThreadsManager.CUSTOM_THREAD)
                .removeThread(runnable);
    }
}