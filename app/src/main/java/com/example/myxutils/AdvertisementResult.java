package com.example.myxutils;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 广告的返回结果
 */

public class AdvertisementResult extends JsonResult implements IItemResult {

    public static final int RES_TYPE_IMAGE = 1;
    private int ID;
    private String title;
    private String cover;
    private String url;
    private int playTime;
    private int resType;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    /**
     * 从JSON字符串中加载数据
     *
     * @param result
     * @return
     */
    public AdvertisementResult setResult(String result) {
        super.setResult(result);
        if (!isSuccess()) return this;
        try {
            parseData();
        } catch (JSONException e) {
            e.printStackTrace();
            setError(e.getMessage(), -10);
        }
        return this;
    }

    @Override
    public AdvertisementResult fromJson(JSONObject item) throws JSONException {
        jsonObject = item;
        parseData();
        return this;
    }


    private void parseData() throws JSONException {
        if (jsonObject.has("id"))
            this.setID(jsonObject.getInt("id"));
        if (jsonObject.has("title"))
            this.setTitle(jsonObject.getString("title"));
        if (jsonObject.has("cover"))
            cover = jsonObject.getString("cover");
        if (jsonObject.has("url"))
            url = jsonObject.getString("url");
        if (jsonObject.has("playTime"))
            playTime = jsonObject.getInt("playTime");
        if (jsonObject.has("resType"))
            resType = jsonObject.getInt("resType");
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public int getPlayTime() {
        return playTime;
    }

    public int getResType() {
        return resType;
    }
}
