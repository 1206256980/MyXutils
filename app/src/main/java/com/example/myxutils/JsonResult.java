package com.example.myxutils;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * WebAPI的返回结果
 */

public class JsonResult implements IWebAPIResult {
    private int resultCode;
    private String errorMessage;
    protected JSONObject jsonObject;
    private String money;//仅用于红包的金额


    public boolean isSuccess() {
        return resultCode>=0;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setError(String errorMessage, int resultCode){
        this.errorMessage = errorMessage;
        this.resultCode = resultCode;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    /**
     * 从JSON字符串中加载数据
     *
     * @param result
     * @return
     */
    public JsonResult setResult(String result) {
        try {
            jsonObject = new JSONObject(result);
            resultCode = jsonObject.getInt("resultCode");
            this.errorMessage = jsonObject.getString("errorMessage");
            if(jsonObject.has("money"))this.money=jsonObject.getString("money");
        } catch (JSONException e) {
            e.printStackTrace();
            resultCode = -10;
            errorMessage = e.getMessage();
        }
        return this;
    }


    public int getResultCode() {
        return resultCode;
    }
}
