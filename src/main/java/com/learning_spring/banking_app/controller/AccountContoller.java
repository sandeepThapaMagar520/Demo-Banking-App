package com.learning_spring.banking_app.controller;


import com.learning_spring.banking_app.dto.AccountDto;
import com.learning_spring.banking_app.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController  // used for restful web service
@RequestMapping("/api/account")
public class AccountContoller {
    private AccountService accountService;
    public AccountContoller(AccountService accountService) {
        this.accountService = accountService;
    }

    // creating account rest api
    @PostMapping
    public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountDto) {
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

    //get account rest api
    @GetMapping("/get/{id}")
    public ResponseEntity<AccountDto> getAccount(@PathVariable Long id){
        AccountDto accountDto = accountService.getAccount(id);
        return ResponseEntity.ok(accountDto);
    }

    //account deposite rest api
    @PutMapping("/deposite/{id}")
    public ResponseEntity<AccountDto> accountDeposit(@PathVariable Long id, @RequestBody Map<String, Double> request){
        double amount = request.get("amount");
        AccountDto accountDto = accountService.accountDeposite(id, amount);
        return ResponseEntity.ok(accountDto);
    }

    //withdraw from the account
    @PutMapping("/withdraw/{id}")
    public ResponseEntity<AccountDto> withdraw(@PathVariable Long id, @RequestBody Map<String, Double> request){
        Double withdrawAmount = request.get("amount");
        AccountDto accountDto = accountService.accountWithdrawal(id, withdrawAmount);

        return ResponseEntity.ok(accountDto);
    }
    @GetMapping
    public ResponseEntity<List<AccountDto>> getAllAccounts(){
        List<AccountDto> accounts = accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }

    //delete account rest api
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteAccountById(@PathVariable Long id) {
        accountService.deleteAccount(id);
        return ResponseEntity.ok("account is deleted sucessfully");
    }
}
