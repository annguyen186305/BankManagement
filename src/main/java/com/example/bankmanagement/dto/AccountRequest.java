package com.example.bankmanagement.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


public class AccountRequest {
    @NotBlank(message = "Customer name is required.")
    private String customerName;

    @NotBlank(message = "Email is required.")
    @Email(message = "Invalid email format.")
    private String email;

    @NotBlank(message = "Phone number is required.")
    private String phoneNumber;

    public AccountRequest(String customerName, String email, String phoneNumber) {
        this.customerName = customerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public AccountRequest() {
    }

    public @NotBlank(message = "Customer name is required.") String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(@NotBlank(message = "Customer name is required.") String customerName) {
        this.customerName = customerName;
    }

    public @NotBlank(message = "Email is required.") @Email(message = "Invalid email format.") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "Email is required.") @Email(message = "Invalid email format.") String email) {
        this.email = email;
    }

    public @NotBlank(message = "Phone number is required.") String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(@NotBlank(message = "Phone number is required.") String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
