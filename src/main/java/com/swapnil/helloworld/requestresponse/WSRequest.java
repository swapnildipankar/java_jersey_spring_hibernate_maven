package com.swapnil.helloworld.requestresponse;

/**
 * Created with IntelliJ IDEA.
 * User: sdipankar
 * Date: 9/26/12
 * Time: 12:05 PM
 * To change this template use File | Settings | File Templates.
 */

import java.util.List;

public class WSRequest<V> {
    private String code;
    private String message;
    private List<V> additionalData;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<V> getAdditionalData() {
        return additionalData;
    }

    public void setAdditionalData(List<V> additionalData) {
        this.additionalData = additionalData;
    }

    @Override
    public String toString() {
        return "Request: Code [" + code + "], Message [" + message + "]";
    }

}
