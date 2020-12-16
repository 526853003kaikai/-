package com.example.videoplayer;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.yc.video.player.VideoPlayer;
import com.yc.video.ui.view.BasisVideoController;


public class MainActivity extends AppCompatActivity {


    private VideoPlayer player;

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
    }
}
