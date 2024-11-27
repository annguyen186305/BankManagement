package com.example.bankmanagement.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AccountRequest {
    @NotBlank(message = "Customer name is required.")
    private String customerName;

    @NotBlank(message = "Email is required.")
    @Email(message = "Invalid email format.")
    private String email;

    @NotBlank(message = "Phone number is required.")
    private String phoneNumber;
}
