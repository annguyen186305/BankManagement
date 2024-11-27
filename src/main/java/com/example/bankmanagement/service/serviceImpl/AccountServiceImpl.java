package com.example.bankmanagement.service.serviceImpl;

import com.example.bankmanagement.dto.AccountRequest;
import com.example.bankmanagement.dto.AccountResponse;
import com.example.bankmanagement.entity.Account;
import com.example.bankmanagement.repositories.AccountRepository;
import com.example.bankmanagement.service.AccountService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountResponse createAccount(AccountRequest accountRequest) {
        Account account = new Account();
        account.setCustomerName(accountRequest.getCustomerName());
        account.setEmail(accountRequest.getEmail());
        account.setPhoneNumber(accountRequest.getPhoneNumber());

        Account savedAccount = accountRepository.save(account);
        return mapToResponse(savedAccount);
    }

    @Override
    public AccountResponse updateAccount(Long accountId, AccountRequest accountRequest) throws Exception {
        Optional<Account> oldAccountOptional = accountRepository.findById(accountId);
        if (oldAccountOptional.isPresent()) {
            Account oldAccount = oldAccountOptional.get();

            if (!StringUtils.isEmpty(accountRequest.getCustomerName())) {
                oldAccount.setCustomerName(accountRequest.getCustomerName());
            }

            if (!StringUtils.isEmpty(accountRequest.getEmail())) {
                oldAccount.setEmail(accountRequest.getEmail());
            }

            if (!StringUtils.isEmpty(accountRequest.getPhoneNumber())) {
                oldAccount.setPhoneNumber(accountRequest.getPhoneNumber());
            }

            Account updatedAccount = accountRepository.save(oldAccount);
            return mapToResponse(updatedAccount);
        } else {
            throw new Exception("Account not found with id: " + accountId);
        }
    }

    @Override
    public void deleteAccount(Long accountId) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found"));
        accountRepository.delete(account);
    }

    @Override
    public AccountResponse getAccountById(Long accountId) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found"));
        return mapToResponse(account);
    }

    @Override
    public List<AccountResponse> getAllAccounts() {
        return accountRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private AccountResponse mapToResponse(Account account) {
        AccountResponse response = new AccountResponse();
        response.setAccountId(account.getAccountId());
        response.setCustomerName(account.getCustomerName());
        response.setEmail(account.getEmail());
        response.setPhoneNumber(account.getPhoneNumber());
        return response;
    }
}
