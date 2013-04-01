package com.demoapp.demo.model.error;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sdipankar
 * Date: 3/27/13
 * Time: 11:20 AM
 * To change this template use File | Settings | File Templates.
 */
public class PaymentServiceException extends Exception {
    private int exceptionCode;
    private List<String> exceptionMessageList;

    public PaymentServiceException(String exceptionMessage) {
        super(exceptionMessage);
    }

    public PaymentServiceException(int exceptionCode, String exceptionMessage) {
        super(exceptionMessage);
        this.exceptionCode = exceptionCode;
    }

    public PaymentServiceException(int exceptionCode, String exceptionMessage, List<String> exceptionMessageList) {
        super(exceptionMessage);
        this.exceptionCode = exceptionCode;
        this.exceptionMessageList = exceptionMessageList;
    }

    public String getExceptionMessage() {
        return super.getMessage();
    }

    public int getExceptionCode() {
        return exceptionCode;
    }

    public void setExceptionCode(int exceptionCode) {
        this.exceptionCode = exceptionCode;
    }

    public List<String> getExceptionMessageList() {
        return exceptionMessageList;
    }

    public void setExceptionMessageList(List<String> exceptionMessageList) {
        this.exceptionMessageList = exceptionMessageList;
    }
}
