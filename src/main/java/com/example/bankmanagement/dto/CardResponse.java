package com.example.bankmanagement.dto;

import java.sql.Timestamp;

public class CardResponse {
    private Integer cardId;
    private Integer accountId;
    private String cardType;
    private Timestamp expiryDate;
    private Integer status;

    public CardResponse(Integer cardId, Integer accountId, String cardType, Timestamp expiryDate, Integer status) {
        this.cardId = cardId;
        this.accountId = accountId;
        this.cardType = cardType;
        this.expiryDate = expiryDate;
        this.status = status;
    }

    public CardResponse() {
    }

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public Timestamp getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Timestamp expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
