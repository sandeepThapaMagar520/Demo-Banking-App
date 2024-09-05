package com.learningSpring.demo_banking_app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BankDto {
    private Long customerId;
    private String customerAccountNumber;
    private String customerName;
    private String customerPhone;
    private String customerEmail;
    private double customerBalance;


}
