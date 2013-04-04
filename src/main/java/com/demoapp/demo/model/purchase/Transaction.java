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
 * Time: 12:50 PM
 * To change this template use File | Settings | File Templates.
 */
@Document
@JsonIgnoreProperties(ignoreUnknown = true)
public class Transaction {
    @NotNull(groups=POST.class, message = "currency_code: Missing Required Field")
    @JsonProperty("currency_code")
    private String currencyCode;

    @NotNull(groups=POST.class, message = "transaction_amount: Missing Required Field")
    @JsonProperty("transaction_amount")
    private String transactionAmount;

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(String transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "currencyCode='" + currencyCode + '\'' +
                ", transactionAmount='" + transactionAmount + '\'' +
                '}';
    }
}
