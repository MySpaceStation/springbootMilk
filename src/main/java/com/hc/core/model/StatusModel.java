package com.hc.core.model;

import java.util.Map;

/**
 * Created by milk.huchan on 2017/3/6.
 */
public class StatusModel {
    /**
     * 状态
     */
    private boolean status;

    /**
     * 消息显示
     */
    private String msg;

    /**
     * 额外参数
     */
    private Map<String, Object> param;

    public StatusModel() {

    }

    public StatusModel(boolean status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public StatusModel(boolean status, String msg, Map<String, Object> param) {
        this.status = status;
        this.msg = msg;
        this.param = param;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getParam() {
        return param;
    }

    public void setParam(Map<String, Object> param) {
        this.param = param;
    }
}
