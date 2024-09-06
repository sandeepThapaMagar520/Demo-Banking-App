package com.learning_spring.banking_app.service;

import com.learning_spring.banking_app.dto.AccountDto;
import com.learning_spring.banking_app.entity.Account;
import com.learning_spring.banking_app.mapper.AccountMapper;
import com.learning_spring.banking_app.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService {
    private final AccountRepository accountRepository;
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    //creating new account
    public AccountDto createAccount(AccountDto accountDto) {

        Account account = AccountMapper.mapToAccount(accountDto); //mapping to account
        Account saveAccount = accountRepository.save(account);   // using account repository to save account in the database

        return AccountMapper.mapToAccountDto(saveAccount);
    }

    //fetching accounts by id
    public AccountDto getAccount(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account does not exists"));
        return AccountMapper.mapToAccountDto(account);
    }

    //depositing to account
    public AccountDto accountDeposite(Long id, double amount) {
        Account account = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account does not exists"));
        double total_balance = account.getBalance() + amount;
        account.setBalance(total_balance);
        Account depositedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(depositedAccount);
    }

    //withdraw from the account
    public AccountDto accountWithdrawal(Long id, double amount){
        Account account = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account does not exists"));
        double account_balance= account.getBalance();
        if(account_balance < amount){
            throw new RuntimeException("Insufficient balance");
        }
        double remaning_balance = account_balance - amount;
        account.setBalance(remaning_balance);

        Account withdrawalAccount = accountRepository.save(account);

        return AccountMapper.mapToAccountDto(withdrawalAccount);
    }
    public List<AccountDto> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();

        return accounts.stream().map(AccountMapper::mapToAccountDto)
                .collect(Collectors.toList());

    }


    public void deleteAccount(Long id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Account does not exists"));

        accountRepository.deleteById(id);
    }
}
