package com.demoapp.demo.model.authorization;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Email;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;

/**
 * Created with IntelliJ IDEA.
 * User: sdipankar
 * Date: 3/21/13
 * Time: 8:15 AM
 * To change this template use File | Settings | File Templates.
 */
@Document
@CompoundIndexes({
        @CompoundIndex(name = "authorization_request_id_idx", def = "{'authorizationRequestId': 1}"),
        @CompoundIndex(name = "customer_ip_address_idx", def = "{'customerIPAddress': 1}"),
        @CompoundIndex(name = "email_idx", def = "{'email': 1}"),
        @CompoundIndex(name = "payment_client_id_idx", def = "{'paymentClientId': 1}"),
        @CompoundIndex(name = "web_order_number_idx", def = "{'webOrderNumber': 1}")
})
public class AuthorizationRequest {
    @Id
    @NotNull(groups=PUT.class, message = "id: Missing Required Field")
    private String id;

    @NotNull(groups=POST.class, message = "billing_address: Missing Required Field")
    @Valid
    @JsonProperty("billing_address")
    private Address billingAddress;

    @JsonProperty("shipping_address")
    private Address shippingAddress;

    @NotNull(groups=POST.class, message = "billing_card: Missing Required Field")
    @Valid
    @JsonProperty("billing_card")
    private Card billingCard;

    @Indexed
    @NotNull(groups=POST.class, message = "authorization_request_id: Missing Required Field")
    @JsonProperty("authorization_request_id")
    private String authorizationRequestId;

    @JsonProperty("barclay_web_order_number_prefix")
    private String barclayWebOrderNumberPrefix;

    @Indexed
    @NotNull(groups=POST.class, message = "customer_ip_address: Missing Required Field")
    @JsonProperty("customer_ip_address")
    private String customerIPAddress;

    @Indexed
    @NotNull(groups=POST.class, message = "email: Missing Required Field")
    @Email(groups=POST.class, message = "email: Invalid Email")
    private String email;

    @JsonProperty("invoice_number")
    private String invoiceNumber;

    @Indexed
    @NotNull(groups=POST.class, message = "payment_client_id: Missing Required Field")
    @JsonProperty("payment_client_id")
    private String paymentClientId;

    @JsonProperty("person_id")
    private String personId;

    @JsonProperty("request_id")
    private String requestId;

    @Indexed
    @NotNull(groups=POST.class, message = "web_order_number: Missing Required Field")
    @JsonProperty("web_order_number")
    private String webOrderNumber;

    @JsonProperty("create_date")
    private String createDate;

    @JsonProperty("service_instance")
    private String serviceInstance;

    @JsonProperty("store_instance")
    private String storeInstance;

    @NotNull(groups=POST.class, message = "transaction: Missing Required Field")
    @Valid
    private Transaction transaction;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Card getBillingCard() {
        return billingCard;
    }

    public void setBillingCard(Card billingCard) {
        this.billingCard = billingCard;
    }

    public String getAuthorizationRequestId() {
        return authorizationRequestId;
    }

    public void setAuthorizationRequestId(String authorizationRequestId) {
        this.authorizationRequestId = authorizationRequestId;
    }

    public String getBarclayWebOrderNumberPrefix() {
        return barclayWebOrderNumberPrefix;
    }

    public void setBarclayWebOrderNumberPrefix(String barclayWebOrderNumberPrefix) {
        this.barclayWebOrderNumberPrefix = barclayWebOrderNumberPrefix;
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

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getPaymentClientId() {
        return paymentClientId;
    }

    public void setPaymentClientId(String paymentClientId) {
        this.paymentClientId = paymentClientId;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getWebOrderNumber() {
        return webOrderNumber;
    }

    public void setWebOrderNumber(String webOrderNumber) {
        this.webOrderNumber = webOrderNumber;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getServiceInstance() {
        return serviceInstance;
    }

    public void setServiceInstance(String serviceInstance) {
        this.serviceInstance = serviceInstance;
    }

    public String getStoreInstance() {
        return storeInstance;
    }

    public void setStoreInstance(String storeInstance) {
        this.storeInstance = storeInstance;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    @Override
    public String toString() {
        return "AuthorizationRequest{" +
                "id='" + id + '\'' +
                ", billingAddress=" + billingAddress +
                ", shippingAddress=" + shippingAddress +
                ", billingCard=" + billingCard +
                ", authorizationRequestId='" + authorizationRequestId + '\'' +
                ", barclayWebOrderNumberPrefix='" + barclayWebOrderNumberPrefix + '\'' +
                ", customerIPAddress='" + customerIPAddress + '\'' +
                ", email='" + email + '\'' +
                ", invoiceNumber='" + invoiceNumber + '\'' +
                ", paymentClientId='" + paymentClientId + '\'' +
                ", personId='" + personId + '\'' +
                ", requestId='" + requestId + '\'' +
                ", webOrderNumber='" + webOrderNumber + '\'' +
                ", createDate='" + createDate + '\'' +
                ", serviceInstance='" + serviceInstance + '\'' +
                ", storeInstance='" + storeInstance + '\'' +
                ", transaction=" + transaction +
                '}';
    }
}
