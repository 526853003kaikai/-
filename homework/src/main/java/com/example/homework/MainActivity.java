package com.example.homework;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import com.example.homework.view.activity.HomeActivity;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText user_main;
    private EditText is_code;
    private EditText pass_main;
    private Button log_main;
    private TextView num_main;
    private int count = 5;
    private int num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        user_main = (EditText) findViewById(R.id.user_main);
        is_code = (EditText) findViewById(R.id.is_code);
        pass_main = (EditText) findViewById(R.id.pass_main);
        log_main = (Button) findViewById(R.id.log_main);

        log_main.setOnClickListener(this);
        num_main = (TextView) findViewById(R.id.num_main);
        num_main.setOnClickListener(this);

        num_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                num_main.setText("验证码"+count+""+"s");
                                count--;
                                if(count == 0){
                                    timer.cancel();

                                    NotificationManager service = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                                    String id = "123";
                                    String name = "123456";
                                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                                        NotificationChannel notificationChannel = new NotificationChannel(id, name, NotificationManager.IMPORTANCE_DEFAULT);
                                        service.createNotificationChannel(notificationChannel);
                                    }
                                    num = new Random().nextInt(2000)+1;

                                    Notification notification = new NotificationCompat.Builder(MainActivity.this)
                                            .setContentTitle("通知")
                                            .setContentText(num + "")
                                            .setSmallIcon(R.drawable.ic_launcher_foreground)
                                            .build();
                                    service.notify(1,notification);
                                }
                            }
                        });
                    }
                },1000,1000);
            }
        });


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.log_main:
                String user = user_main.getText().toString().trim();
                String code = is_code.getText().toString().trim();
                String pass = pass_main.getText().toString().trim();
                if (TextUtils.isEmpty(user)) {
                    Toast.makeText(this, "请输入用户名", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(code)) {
                    Toast.makeText(this, "请输入验证码", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(pass)) {
                    Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
                    return;
                }

                String str = is_code.getText().toString();
                Log.e("TAG", "onClick: "+str);

                    if (str.equals(num + "")) {
                        startActivity(new Intent(MainActivity.this, HomeActivity.class));
                        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "请输入验证码", Toast.LENGTH_SHORT).show();
                    }

                break;
        }
    }
}
