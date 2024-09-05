package com.learningSpring.demo_banking_app.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Bank")
@Getter 
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long customerId;

    @Column(name = "customerAccountNumber")
    private String customerAccountNumber;
    
    @Column(name="customerName")
    private String customerName;

    @Column(name = "customerPhone")
    private String customerPhone;

    @Column(name="customerEmail")
    private String customerEmail;

    @Column(name = "customerBalance")
    private double customerBalance;


}
