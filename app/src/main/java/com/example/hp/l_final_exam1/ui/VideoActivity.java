package com.example.hp.l_final_exam1.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.hp.l_final_exam1.R;

import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;

public class VideoActivity extends AppCompatActivity {
    private JZVideoPlayerStandard mJZVideoPlayerStandard;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        mJZVideoPlayerStandard = (JZVideoPlayerStandard)findViewById(R.id.video_player);

        Intent intent = getIntent();
        String videoName = intent.getStringExtra("video_name");
        String videoUrl = intent.getStringExtra("video_url");
        mJZVideoPlayerStandard.setUp(videoUrl, JZVideoPlayer.SCREEN_WINDOW_NORMAL,videoName);
    }
    @Override
    public void onBackPressed() {
        if (JZVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }
    @Override
    protected void onPause() {
        super.onPause();
        JZVideoPlayer.releaseAllVideos();
    }
}
