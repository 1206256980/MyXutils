package com.example.myxutils;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * 视频数据
 */

public class Video extends JsonResult{

    public static int LIST_TYPE_LATEST = 1;
    public static int LIST_TYPE_HOTEST = 2;
    public static int LIST_TYPE_USER_FOLLOW = 3;
    public static int LIST_TYPE_USER_VIDEO = 4;
    public static int LIST_TYPE_USER_FAVORITE = 5;
    public static int LIST_TYPE_USER_HEART = 6;
    public static int LIST_TYPE_USER_COMMENT = 7;
    public static int LIST_TYPE_RECENT = 8;

    private int id;
    private String title;
    private String cover;
    private String userPhoto;
    private int favoriteCount;
    private int userID;
    private int favoriteID;
    private int heartID;
    private String downloadName;
    private String downloadUrl;
    private int progress;
    private String localFile;
    private String auditTime;
    private String createTime;
    private String userName;
    private boolean isShort;
    private String serverUrl;
    private int heartCount;
    private int followCount;
    private int viewCount;
    private int commentCount;
    private String shareUrl;
    private String redPacketsId;
    private AdvertisementResult playAdv;
    private String shareQQUrl;
    private String shareWinXinUrl;



    private AdvertisementResult adv;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }




    public void setTitle(String title) {
        this.title = title;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    public int getFavoriteCount() {
        return favoriteCount;
    }

    public void setFavoriteCount(int favoriteCount) {
        this.favoriteCount = favoriteCount;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }



    private boolean isHeart;
    private boolean isFavorite;
    private boolean isFollow;

    public boolean isFollow() {
        return isFollow;
    }

    public void setFollow(boolean follow) {
        isFollow = follow;
    }

    public boolean isHeart() {
        return isHeart;
    }

    public void setHeart(boolean heart) {
        isHeart = heart;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRedPacketsId() {
        return redPacketsId;
    }

    public void setRedPacketsId(String redPacketsId) {
        this.redPacketsId = redPacketsId;
    }

    public String getDownloadName() {
        return downloadName;
    }

    public void setDownloadName(String downloadName) {
        this.downloadName = downloadName;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public void setAuditTime(String auditTime) {
        this.auditTime = auditTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public JsonResult setResult(String result) {
        super.setResult(result);
        if (!isSuccess()) return this;
        try {
            parseData();
        } catch (JSONException e) {
            this.setError(e.getMessage(), -10);
        }
        return this;
    }


    public static List<Video> ParseList(String JSONText) {
        List<Video> videoList = new ArrayList<>();
        try {
            JSONArray json = new JSONArray(JSONText);
            LoadVideoList(videoList, json);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return videoList;
    }

    public static List<Video> ParseList(JSONArray jyVideos) {
        List<Video> videoList = new ArrayList<>();
        try {
            LoadVideoList(videoList, jyVideos);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return videoList;
    }

    private static void LoadVideoList(List<Video> videoList, JSONArray json) throws JSONException {
        for (int i = 0; i < json.length(); i++) {
            JSONObject jsonObject = json.getJSONObject(i);
            Video video = new Video();
            video.setCover(jsonObject.getString("cover"));
            video.setId(jsonObject.getInt("id"));
            video.setFavoriteCount(jsonObject.getInt("favoriteCount"));
            video.setUserPhoto(jsonObject.getString("userPhoto"));
            video.setTitle(jsonObject.getString("title"));
            videoList.add(video);
        }
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public Video fromJSON(JSONObject item) throws JSONException {
        jsonObject = item;
        parseData();
        return this;
    }

    private void parseData() throws JSONException {
        this.setCover(jsonObject.getString("cover"));
        this.setId(jsonObject.getInt("id"));
        if (jsonObject.has("favoriteCount"))
            this.setFavoriteCount(jsonObject.getInt("favoriteCount"));
        if (jsonObject.has("heartCount"))
            this.heartCount = jsonObject.getInt("heartCount");
        if (jsonObject.has("userPhoto"))
            this.setUserPhoto(jsonObject.getString("userPhoto"));
        if (jsonObject.has("title"))
            this.setTitle(jsonObject.getString("title"));
        if (jsonObject.has("isHeart"))
            this.setHeart(jsonObject.getBoolean("isHeart"));
        if (jsonObject.has("isFavorite"))
            this.setFavorite(jsonObject.getBoolean("isFavorite"));
        if (jsonObject.has("url"))
            this.setUrl(jsonObject.getString("url"));
        if (jsonObject.has("playUrl"))
            this.setUrl(jsonObject.getString("playUrl"));
        if (jsonObject.has("redPacketsId"))
            this.setRedPacketsId(jsonObject.getString("redPacketsId"));
        if (jsonObject.has("userID"))
            this.setUserID(jsonObject.getInt("userID"));
        if (jsonObject.has("isFollow"))
            this.setFollow(jsonObject.getBoolean("isFollow"));
        if (jsonObject.has("favoriteID"))
            this.setFavoriteID(jsonObject.getInt("favoriteID"));
        if (jsonObject.has("heartID"))
            this.setHeartID(jsonObject.getInt("heartID"));
        if (jsonObject.has("downloadName"))
            this.setDownloadName(jsonObject.getString("downloadName"));
        if (jsonObject.has("downloadUrl"))
            this.setDownloadUrl(jsonObject.getString("downloadUrl"));
        if (jsonObject.has("auditTime"))
            this.auditTime = jsonObject.getString("auditTime");
        if (jsonObject.has("createTime"))
            this.createTime = jsonObject.getString("createTime");
        if (jsonObject.has("userName"))
            this.userName = jsonObject.getString("userName");
        if (jsonObject.has("isShort"))
            this.isShort = jsonObject.getBoolean("isShort");
        if (jsonObject.has("serverUrl"))
            this.serverUrl = jsonObject.getString("serverUrl");
        if (jsonObject.has("followCount"))
            this.followCount = jsonObject.getInt("followCount");
        if (jsonObject.has("commentCount"))
            this.commentCount = jsonObject.getInt("commentCount");
        if (jsonObject.has("viewCount"))
            this.viewCount = jsonObject.getInt("viewCount");
        if (jsonObject.has("shareUrl"))
            this.shareUrl = jsonObject.getString("shareUrl");
        if (jsonObject.has("playAdv") && !jsonObject.isNull("playAdv")) {
            AdvertisementResult adv = new AdvertisementResult();
            this.playAdv = adv.fromJson(jsonObject.getJSONObject("playAdv"));
        }
        if (jsonObject.has("adv") && !jsonObject.isNull("adv")) {
            AdvertisementResult adv = new AdvertisementResult();
            this.adv = adv.fromJson(jsonObject.getJSONObject("adv"));
        }
        if (jsonObject.has("shareQQUrl") && !jsonObject.isNull("shareQQUrl")) {
            AdvertisementResult adv = new AdvertisementResult();
            this.shareQQUrl = jsonObject.getString("shareQQUrl");
        }
        if (jsonObject.has("shareWinXinUrl") && !jsonObject.isNull("shareWinXinUrl")) {
            AdvertisementResult adv = new AdvertisementResult();
            this.shareWinXinUrl = jsonObject.getString("shareWinXinUrl");
        }
    }

    public int getFavoriteID() {
        return favoriteID;
    }

    public void setFavoriteID(int favoriteID) {
        this.favoriteID = favoriteID;
    }

    public int getHeartID() {
        return heartID;
    }

    public void setHeartID(int heartID) {
        this.heartID = heartID;
    }

    public String getAuditTime() {
        return auditTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public String getUserName() {
        return userName;
    }

    public boolean isShort() {
        return isShort;
    }



    public String getServerUrl() {
        return serverUrl;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setShort(boolean isShort) {
        this.isShort = isShort;
    }

    public int getHeartCount() {
        return heartCount;
    }

    public int getFollowCount() {
        return followCount;
    }

    public void setFollowCount(int followCount) {
        this.followCount = followCount;
    }

    public String getShareUrl() {
        return shareUrl;
    }

    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl;
    }

    public AdvertisementResult getPlayAdv() {
        return playAdv;
    }


    public void setHeartCount(int heartCount) {
        this.heartCount = heartCount;
    }

    public AdvertisementResult getAdv() {
        return adv;
    }

    public String getShareQQUrl() {
        return shareQQUrl;
    }

    public void setShareQQUrl(String shareQQUrl) {
        this.shareQQUrl = shareQQUrl;
    }

    public String getShareWinXinUrl() {
        return shareWinXinUrl;
    }

    public void setShareWinXinUrl(String shareWinXinUrl) {
        this.shareWinXinUrl = shareWinXinUrl;
    }

    public void setAdv(AdvertisementResult adv) {
        this.adv = adv;
    }
}
