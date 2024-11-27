package com.example.bankmanagement.dto;

import com.example.bankmanagement.entity.Account;
import jakarta.validation.constraints.NotNull;

import java.sql.Timestamp;

public class CardRequest {
    @NotNull
    private Long accountId;
    @NotNull
    private String cardType;

    public CardRequest(Long accountId, String cardType) {
        this.accountId = accountId;
        this.cardType = cardType;
    }

    public CardRequest() {
    }

    public @NotNull Long getAccountId() {
        return accountId;
    }

    public void setAccountId(@NotNull Long accountId) {
        this.accountId = accountId;
    }

    public @NotNull String getCardType() {
        return cardType;
    }

    public void setCardType(@NotNull String cardType) {
        this.cardType = cardType;
    }
}