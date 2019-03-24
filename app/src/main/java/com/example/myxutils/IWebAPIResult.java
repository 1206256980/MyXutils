package com.example.myxutils;

public interface IWebAPIResult {
    void setError(String errorMsg,int resultCode);
    IWebAPIResult setResult(String result);
}
