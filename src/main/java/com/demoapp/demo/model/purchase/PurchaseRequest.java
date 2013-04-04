package com.demoapp.demo.model.purchase;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
		@CompoundIndex(name = "user_id_idx", def = "{'userId': 1}"),
        @CompoundIndex(name = "user_ip_address_idx", def = "{'userIPAddress': 1}"),
        @CompoundIndex(name = "email_idx", def = "{'email': 1}"),
        @CompoundIndex(name = "payment_client_id_idx", def = "{'paymentClientId': 1}"),
        @CompoundIndex(name = "order_number_idx", def = "{'orderNumber': 1}")
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class PurchaseRequest {
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

	@JsonProperty("create_date")
	private String createDate;

    @Indexed
    @NotNull(groups=POST.class, message = "email: Missing Required Field")
    @Email(groups=POST.class, message = "email: Invalid Email")
    private String email;

    @Indexed
    @NotNull(groups=POST.class, message = "client_id: Missing Required Field")
    @JsonProperty("client_id")
    private String clientId;

	@JsonProperty("invoice_number")
	private String invoiceNumber;

    @Indexed
    @NotNull(groups=POST.class, message = "order_number: Missing Required Field")
    @JsonProperty("order_number")
    private String orderNumber;

	@Indexed
	@NotNull(groups=POST.class, message = "user_id: Missing Required Field")
	@JsonProperty("user_id")
	private String userId;

	@Indexed
	@NotNull(groups=POST.class, message = "user_ip_address: Missing Required Field")
	@JsonProperty("user_ip_address")
	private String userIPAddress;

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

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserIPAddress() {
		return userIPAddress;
	}

	public void setUserIPAddress(String userIPAddress) {
		this.userIPAddress = userIPAddress;
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	@Override
	public String toString() {
		return "PurchaseRequest{" +
				"id='" + id + '\'' +
				", billingAddress=" + billingAddress +
				", shippingAddress=" + shippingAddress +
				", billingCard=" + billingCard +
				", createDate='" + createDate + '\'' +
				", email='" + email + '\'' +
				", clientId='" + clientId + '\'' +
				", invoiceNumber='" + invoiceNumber + '\'' +
				", orderNumber='" + orderNumber + '\'' +
				", userId='" + userId + '\'' +
				", userIPAddress='" + userIPAddress + '\'' +
				", transaction=" + transaction +
				'}';
	}
}
