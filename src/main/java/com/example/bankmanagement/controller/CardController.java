package com.example.bankmanagement.controller;

import com.example.bankmanagement.dto.AccountRequest;
import com.example.bankmanagement.dto.AccountResponse;
import com.example.bankmanagement.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    AccountService accountService;

    // 1. Create Account
    @PostMapping("/add")
    public ResponseEntity<AccountResponse> createAccount(@Valid @RequestBody AccountRequest accountRequest) {
        AccountResponse response = accountService.createAccount(accountRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // 2. Update Account
    @PutMapping("/{accountId}")
    public ResponseEntity<AccountResponse> updateAccount(
            @PathVariable Long accountId,
            @Valid @RequestBody AccountRequest accountRequest) throws Exception {
        AccountResponse response = accountService.updateAccount(accountId, accountRequest);
        return ResponseEntity.ok(response);
    }

    // 3. Delete Account
    @DeleteMapping("/{accountId}")
    public ResponseEntity<Void> deleteAccount(@PathVariable Long accountId) {
        accountService.deleteAccount(accountId);
        return ResponseEntity.noContent().build();
    }

    // 4. Get Account by ID
    @GetMapping("/{accountId}")
    public ResponseEntity<AccountResponse> getAccountById(@PathVariable Long accountId) {
        AccountResponse response = accountService.getAccountById(accountId);
        return ResponseEntity.ok(response);
    }

    // 5. Get All Accounts
    @GetMapping
    public ResponseEntity<List<AccountResponse>> getAllAccounts() {
        List<AccountResponse> responseList = accountService.getAllAccounts();
        return ResponseEntity.ok(responseList);
    }
}
