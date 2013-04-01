package com.demoapp.demo.model.user;

/**
 * Created with IntelliJ IDEA.
 * User: sdipankar
 * Date: 12/12/12
 * Time: 9:43 AM
 * To change this template use File | Settings | File Templates.
 */
public enum UserStatus {
    PENDING("P"), ACTIVE("A"), INACTIVE("I"), DELETED("D");

    private String statusCode;

    private UserStatus(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusCode() {
        return this.statusCode;
    }
}