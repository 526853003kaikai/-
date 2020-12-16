package com.example.videoplayer;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.yc.video.player.VideoPlayer;
import com.yc.video.ui.view.BasisVideoController;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private VideoPlayer player;
    private Button but1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {

        player = (VideoPlayer) findViewById(R.id.player);
        BasisVideoController basisVideoController = new BasisVideoController(this);
        player.setController(basisVideoController);
        player.setUrl("https://tpcdn.whfpsoft.com:443/File/video/20200804/72a0a15c5d6b7d4a9793a9279835a7fd.mp4");
        player.start();
        but1 = (Button) findViewById(R.id.but1);
        but1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.but1:

                break;
        }
    }
}
