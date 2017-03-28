package com.sqw.testretrofit;

/**
 * Created by Administrator on 2017/3/29.
 */

public class WeatherModel {

    private String success;
    private String msgid;
    private String  msg;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getMsgid() {
        return msgid;
    }

    public void setMsgid(String msgid) {
        this.msgid = msgid;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
