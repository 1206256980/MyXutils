package com.example.myxutils;

public class WebApi {

    public static String VideoFindPage="http://154.8.172.16:5001/API/VideoFindPage_%d_%d_%d.json";


    public static String GetApi(String url,Object...param){

        return String.format(url,param);
    }
}
