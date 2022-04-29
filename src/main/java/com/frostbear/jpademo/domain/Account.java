package com.frostbear.jpademo.domain;

import com.frostbear.jpademo.LotConverter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Table
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAccount;

    @Column(nullable = false)
    private BigDecimal balance;

    @Embedded
    private Xref xref;

    @Column
    @Convert(converter = LotConverter.class)
    private AccountTypeLoT type;

    @JoinColumn(name = "owner", referencedColumnName = "idCustomer")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Customer owner;

    @Override
    public String toString() {
        return "Account{" +
                "idAccount=" + idAccount +
                ", balance=" + balance +
                ", type=" + type +
                '}';
    }
}