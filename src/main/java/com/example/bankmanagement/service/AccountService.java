package com.example.bankmanagement.service;

import com.example.bankmanagement.dto.AccountRequest;
import com.example.bankmanagement.dto.AccountResponse;

import java.util.List;

public interface AccountService {
    AccountResponse createAccount(AccountRequest accountRequest);
    AccountResponse updateAccount(Long accountId, AccountRequest accountRequest) throws Exception;
    void deleteAccount(Long accountId);
    AccountResponse getAccountById(Long accountId);
    List<AccountResponse> getAllAccounts();
}
