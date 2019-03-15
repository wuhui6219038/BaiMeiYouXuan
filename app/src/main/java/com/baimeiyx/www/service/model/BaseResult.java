package com.baimeiyx.www.service.model;

import java.io.Serializable;

public class BaseResult implements Serializable {
    /**
     * 判断是否是错误
     */
    protected boolean isExcetion;
    /**
     * 错误
     */
    protected Throwable throwable;
    protected String stateCode;
    protected String message;
    protected String comment;
    protected boolean ok;

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public boolean isExcetion() {
        return isExcetion;
    }

    public void setExcetion(boolean excetion) {
        isExcetion = excetion;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
