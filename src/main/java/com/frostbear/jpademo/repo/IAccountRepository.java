package com.frostbear.jpademo.repo;

import com.frostbear.jpademo.domain.Account;
import com.frostbear.jpademo.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.swing.text.html.Option;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface IAccountRepository extends JpaRepository<Account, Long> {

    List<Account> findByOwnerAndAndBalanceIsNotNull(Customer customer);
    List<Account> findByOwnerIdCustomer(Long idCustomer);

    List<Account> findAccountByBalanceBetween(BigDecimal lower, BigDecimal upper);


    @Query(
            """
                SELECT a FROM Account a
                inner join fetch Customer c ON a.owner = c
                WHERE a.idAccount = ?2 AND c.firstName = ?1
            """
    )
    Optional<Account> findByFirstNameAndId(String firstName, long idAccount);





    @Query(
            nativeQuery = true,
            value = "SELECT COUNT(*) FROM account where owner = ?1"
    )
    long countOfAccountsForCustomerId(long idCustomer);
}