package com.learningSpring.demo_banking_app.mapper;

import com.learningSpring.demo_banking_app.dto.BankDto;
import com.learningSpring.demo_banking_app.entity.Bank;

public class BankMapper {
    

    public static Bank mapToBank(BankDto bankDto) {
        Bank bank = new Bank(
            bankDto.getCustomerId(),
            bankDto.getCustomerAccountNumber(),
            bankDto.getCustomerName(),
            bankDto.getCustomerPhone(),
            bankDto.getCustomerEmail(),
            bankDto.getCustomerBalance());
            
            return bank;
    }

    public static BankDto mapToBankDto(Bank bank) {

        BankDto bankDto = new BankDto(
            bank.getCustomerId(),
            bank.getCustomerAccountNumber(),
            bank.getCustomerName(),
            bank.getCustomerPhone(),
            bank.getCustomerEmail(),
            bank.getCustomerBalance());
        return bankDto;
    }
        

        
}
