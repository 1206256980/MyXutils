package com.example.myxutils;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.xutils.x;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        HttpUtils.xutilsGet(WebApi.GetApi(WebApi.VideoFindPage,0,0,0),new HttpUtils.onRequestComplete<VideoPageResult>(){

            @Override
            public VideoPageResult getInstance() {
                return new VideoPageResult();
            }

            @Override
            public void complete(VideoPageResult videoPageResult) {
                Log.d("提示",videoPageResult.getVideoList().size()+"");
            }
        });
    }
}
