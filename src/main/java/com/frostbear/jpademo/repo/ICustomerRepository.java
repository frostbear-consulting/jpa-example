package com.frostbear.jpademo.repo;

import com.frostbear.jpademo.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {
}