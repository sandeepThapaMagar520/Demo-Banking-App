package com.learning_spring.banking_app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountDto {

    private Long id;
    private String account_holder_name;
    private String account_holder_location;
    private Long account_number;
    private Double balance;
}
