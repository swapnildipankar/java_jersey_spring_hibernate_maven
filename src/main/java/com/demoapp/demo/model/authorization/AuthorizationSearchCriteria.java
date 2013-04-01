package com.demoapp.demo.model.authorization;

public class AuthorizationSearchCriteria {
    private String authorizationRequestId;
    private String customerIPAddress;
    private String email;
    private String paymentClientId;
    private String webOrderNumber;

    public AuthorizationSearchCriteria() {
    }

    public AuthorizationSearchCriteria(
            String authorizationRequestId,
            String customerIPAddress,
            String email,
            String paymentClientId,
            String webOrderNumber)
    {
        this.authorizationRequestId = authorizationRequestId;
        this.customerIPAddress = customerIPAddress;
        this.email = email;
        this.paymentClientId = paymentClientId;
        this.webOrderNumber = webOrderNumber;
    }

    public String getAuthorizationRequestId() {
        return authorizationRequestId;
    }

    public void setAuthorizationRequestId(String authorizationRequestId) {
        this.authorizationRequestId = authorizationRequestId;
    }

    public String getCustomerIPAddress() {
        return customerIPAddress;
    }

    public void setCustomerIPAddress(String customerIPAddress) {
        this.customerIPAddress = customerIPAddress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPaymentClientId() {
        return paymentClientId;
    }

    public void setPaymentClientId(String paymentClientId) {
        this.paymentClientId = paymentClientId;
    }

    public String getWebOrderNumber() {
        return webOrderNumber;
    }

    public void setWebOrderNumber(String webOrderNumber) {
        this.webOrderNumber = webOrderNumber;
    }

    @Override
    public String toString() {
        return "AuthorizationSearchCriteria{" +
                "webOrderNumber='" + webOrderNumber + '\'' +
                ", paymentClientId='" + paymentClientId + '\'' +
                ", email='" + email + '\'' +
                ", customerIPAddress='" + customerIPAddress + '\'' +
                ", authorizationRequestId='" + authorizationRequestId + '\'' +
                '}';
    }
}
