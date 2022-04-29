package com.frostbear.jpademo.service;

import com.frostbear.jpademo.domain.Account;
import com.frostbear.jpademo.domain.AccountTypeLoT;
import com.frostbear.jpademo.domain.Xref;
import com.frostbear.jpademo.repo.IAccountRepository;
import com.frostbear.jpademo.repo.ICustomerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@AllArgsConstructor
@Service
@Slf4j
public class UpdateStuff implements IUpdateStuff{

    protected ICustomerRepository customerRepository;
    protected IAccountRepository accountRepository;

    @Override
    @Transactional
    public void update(Long customerId) {
        log.info("--- UPDATING ---");

        var customer = this.customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        log.info("Customer = {}", customer);

        var accounts = this.accountRepository.findByOwner(customer);

        for(var account : accounts) {
            log.info("\t Account found = {}", account);
        }

        if(accounts.size() > 0) {
            var target = accounts.get(0);

            log.info("Deleting account {}", target);
            this.accountRepository.delete(target);
        }

        customer.setFirstName("Peter");
        this.customerRepository.saveAndFlush(customer);
        log.info("Updated customer");

        var account = new Account(
                null,
                BigDecimal.ZERO,
                Xref.create(),
                AccountTypeLoT.SAVINGS,
                customer
        );

        this.accountRepository.saveAndFlush(account);
        log.info("Created new account = {}", account);
    }
}