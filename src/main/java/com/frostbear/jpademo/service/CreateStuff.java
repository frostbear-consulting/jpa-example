package com.frostbear.jpademo.service;

import com.frostbear.jpademo.domain.Account;
import com.frostbear.jpademo.domain.AccountTypeLoT;
import com.frostbear.jpademo.domain.Customer;
import com.frostbear.jpademo.domain.Xref;
import com.frostbear.jpademo.repo.IAccountRepository;
import com.frostbear.jpademo.repo.ICustomerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@AllArgsConstructor
@Service
@Slf4j
public class CreateStuff implements ICreateStuff {

    protected ICustomerRepository customerRepository;
    protected IAccountRepository accountRepository;

    @Transactional
    @Override
    public Long createStuff() {

        var cust = new Customer(
                null,
                1,
                "Jane",
                Xref.create(),
                "Dough"
        );

        cust = this.customerRepository.saveAndFlush(cust);

        log.info("Customer created: {}", cust.toString());

        var account = new Account(
                null,
                new BigDecimal("77813.94"),
                Xref.create(),
                AccountTypeLoT.CHECKING,
                cust
        );

        account = this.accountRepository.saveAndFlush(account);

        log.info("Account created: {}", account.toString());

        return cust.getIdCustomer();
    }
}