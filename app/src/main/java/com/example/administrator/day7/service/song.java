package com.example.administrator.day7.service;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Administrator on 2016/7/12.
 */
public class song extends Activity implements View.OnClickListener,MediaPlayer.OnPreparedListener{

    String url = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onPrepared(MediaPlayer mp) {

    }
}
