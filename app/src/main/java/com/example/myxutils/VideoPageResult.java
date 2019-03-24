package com.example.myxutils;



import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * 视频页面数据 列表
 */

public class VideoPageResult extends JsonResult {

    private int videoCount;
    private long version;

    public List<Video> getVideoList() {
        return videoList;
    }

    public void setVideoList(List<Video> videoList) {
        this.videoList = videoList;
    }

    private List<Video> videoList;

    private List<AdvertisementResult> adList;

    private int advertisementSpan;

    public VideoPageResult() {
        this.videoList = new ArrayList<>();
        this.adList = new ArrayList<>();
    }


    @Override
    public VideoPageResult setResult(String result) {
        super.setResult(result);

        Log.d("提示:视频列表",result);

        if(!isSuccess()) return this;
        try {
            JSONArray array = jsonObject.getJSONArray("videos");
            for(int i=0; i<array.length();i++){
                JSONObject item = array.getJSONObject(i);
                Video idata = new Video();
                idata.fromJSON(item);
                videoList.add(idata);
            }
            if(jsonObject.has("videoCount")){
                videoCount = jsonObject.getInt("videoCount");
            }
            if(!jsonObject.has("advertisements")) return this;
            JSONArray adArray = jsonObject.getJSONArray("advertisements");
            for(int i=0; i<adArray.length();i++){
                JSONObject item = adArray.getJSONObject(i);
                AdvertisementResult idata = new AdvertisementResult();
                idata.fromJson(item);
                adList.add(idata);
            }
            if(jsonObject.has("advertisementSpan")){
                advertisementSpan = jsonObject.getInt("advertisementSpan");
            }
            if(jsonObject.has("version")){
                version = jsonObject.getLong("version");
            }

        }
        catch (JSONException e){
            e.printStackTrace();
            setError(e.getMessage(), -10);
        }

        return this;
    }

    public List<AdvertisementResult> getAdList() {
        return adList;
    }

    public int getAdvertisementSpan() {
        return advertisementSpan;
    }

    public int getVideoCount() {
        return videoCount;
    }

    public long getVersion() {
        return version;
    }

    public void removeAdvs() {
        this.adList.clear();
    }
}
