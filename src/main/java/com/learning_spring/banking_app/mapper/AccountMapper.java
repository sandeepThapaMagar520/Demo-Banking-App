package com.learning_spring.banking_app.mapper;

import com.learning_spring.banking_app.dto.AccountDto;
import com.learning_spring.banking_app.entity.Account;

public class AccountMapper {

    public static Account mapToAccount(AccountDto accountDto) {
        Account account = new Account(
                accountDto.getId(),
                accountDto.getAccount_holder_name(),
                accountDto.getAccount_holder_location(),
                accountDto.getAccount_number(),
                accountDto.getBalance()
        );
        return account;

    }

    public static AccountDto mapToAccountDto(Account account){
        AccountDto accountDto = new AccountDto(
                account.getId(),
                account.getAccountHolderName(),
                account.getAccountHolderLocation(),
                account.getAccountNumber(),
                account.getBalance()
        );
        return accountDto;
    }

}



