package com.frostbear.jpademo.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCustomer;

    @Column
    private long version;

    @Column(nullable = false)
    private String firstName;

    @Embedded
    private Xref xref;

    @Column(nullable = true)
    private String lastName;

    @Override
    public String toString() {
        return "Customer{" +
                "idCustomer=" + idCustomer +
                ", version=" + version +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}