package com.example.bankmanagement.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Table(name = "card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cardId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;

    @Column(name = "card_type")
    private String cardType;

    @CreationTimestamp
    @Column(name = "expiry_date", columnDefinition = "TIMESTAMP")
    private Timestamp expiryDate;

    @Column(name = "status")
    private Integer status;

    public Card(Integer cardId, Account accountId, String cardType, Timestamp expiryDate, Integer status) {
        this.cardId = cardId;
        this.account = accountId;
        this.cardType = cardType;
        this.expiryDate = expiryDate;
        this.status = status;
    }

    public Card() {
    }

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public Account getAccountId() {
        return account;
    }

    public void setAccountId(Account accountId) {
        this.account = accountId;
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
