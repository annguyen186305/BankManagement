package com.example.bankmanagement.model;

import lombok.Data;

@Data
public class AccountResponse {
    private Long accountId;
    private String customerName;
    private String email;
    private String phoneNumber;
}
