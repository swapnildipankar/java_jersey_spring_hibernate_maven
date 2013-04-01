package com.demoapp.demo.model.purchase;

public class PurchaseSearchCriteria {
    private String userIPAddress;
    private String email;
    private String clientId;
    private String orderNumber;

    public PurchaseSearchCriteria() {
    }

    public PurchaseSearchCriteria(
			String userIPAddress,
			String email,
			String clientId,
			String orderNumber)
    {
        this.userIPAddress = userIPAddress;
        this.email = email;
        this.clientId = clientId;
        this.orderNumber = orderNumber;
    }

	public String getUserIPAddress() {
		return userIPAddress;
	}

	public void setUserIPAddress(String userIPAddress) {
		this.userIPAddress = userIPAddress;
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

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	@Override
	public String toString() {
		return "PurchaseSearchCriteria{" +
				"userIPAddress='" + userIPAddress + '\'' +
				", email='" + email + '\'' +
				", clientId='" + clientId + '\'' +
				", orderNumber='" + orderNumber + '\'' +
				'}';
	}
}
