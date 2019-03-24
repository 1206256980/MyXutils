package com.example.myxutils;

import org.json.JSONException;
import org.json.JSONObject;

public interface IItemResult {
    IWebAPIResult fromJson(JSONObject jsonObject) throws JSONException;
}
