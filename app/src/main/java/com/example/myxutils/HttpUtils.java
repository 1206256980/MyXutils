package com.example.myxutils;

import org.xutils.common.Callback;
import org.xutils.http.HttpMethod;
import org.xutils.http.RequestParams;
import org.xutils.x;

public class HttpUtils {


    public static <TResult extends IWebAPIResult> void xutilsPost(String url,final onRequestComplete<TResult> complete){

        RequestParams requestParams=new RequestParams(url);
        x.http().post(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                TResult tResult=complete.getInstance();
                tResult.setResult(result);
                complete.complete(tResult);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                TResult tResult=complete.getInstance();
                tResult.setError("连接错误",-10);
                complete.complete(tResult);
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });

    }





    public static  <TResult extends IWebAPIResult>  void xutilsGet(String url, final onRequestComplete<TResult> complete){
        
        RequestParams requestParams=new RequestParams(url);
        x.http().get(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                TResult tResult=complete.getInstance();
                tResult.setResult(result);
                complete.complete(tResult);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                TResult tResult=complete.getInstance();
                tResult.setError("连接错误",-10);
                complete.complete(tResult);
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }


    public static <TResult extends IWebAPIResult> void xutilsPut(String url,final onRequestComplete<TResult> complete){

        RequestParams requestParams=new RequestParams(url);
        x.http().request(HttpMethod.PUT, requestParams, new Callback.CommonCallback<String>() {

            @Override
            public void onSuccess(String result) {
                TResult tResult=complete.getInstance();
                tResult.setResult(result);
                complete.complete(tResult);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                TResult tResult=complete.getInstance();
                tResult.setError("连接错误",-10);
                complete.complete(tResult);
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });

    }



    public interface onRequestComplete<TResult extends  IWebAPIResult>{
        TResult getInstance();
        void complete(TResult tResult);

    }

}
