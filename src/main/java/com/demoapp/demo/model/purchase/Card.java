package com.demoapp.demo.model.purchase;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.ws.rs.POST;

/**
 * Created with IntelliJ IDEA.
 * User: sdipankar
 * Date: 3/21/13
 * Time: 12:48 PM
 * To change this template use File | Settings | File Templates.
 */
@Document
@JsonIgnoreProperties(ignoreUnknown = true)
public class Card {
    @NotNull(groups=POST.class, message = "card_number: Missing Required Field")
    @JsonProperty("card_number")
    private String cardNumber;

    @NotNull(groups=POST.class, message = "card_type: Missing Required Field")
    @JsonProperty("card_type")
    private String cardType;

    @JsonProperty("encryption_type")
    private String encryptionType;

    @JsonProperty("expiration_month")
    private String expirationMonth;

    @JsonProperty("expiration_year")
    private String expirationYear;

    @NotNull(groups=POST.class, message = "security_code: Missing Required Field")
    @JsonProperty("security_code")
    private String securityCode;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getEncryptionType() {
        return encryptionType;
    }

    public void setEncryptionType(String encryptionType) {
        this.encryptionType = encryptionType;
    }

    public String getExpirationMonth() {
        return expirationMonth;
    }

    public void setExpirationMonth(String expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    public String getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(String expirationYear) {
        this.expirationYear = expirationYear;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardNumber='" + cardNumber + '\'' +
                ", cardType='" + cardType + '\'' +
                ", encryptionType='" + encryptionType + '\'' +
                ", expirationMonth='" + expirationMonth + '\'' +
                ", expirationYear='" + expirationYear + '\'' +
                ", securityCode='" + securityCode + '\'' +
                '}';
    }
}
