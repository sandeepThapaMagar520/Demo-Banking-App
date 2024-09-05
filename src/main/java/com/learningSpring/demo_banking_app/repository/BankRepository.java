
package com.learningSpring.demo_banking_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learningSpring.demo_banking_app.entity.Bank;

public interface BankRepository extends JpaRepository<Bank, Long>{

}
