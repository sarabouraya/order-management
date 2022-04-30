package com.sbouraya.ordermanagement.ordermanagement.api.customers.entities;

import com.sbouraya.ordermanagement.ordermanagement.api.orders.entities.Order;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 31, nullable = false, name = "first_name")
    private String firstName;

    @Column(length = 31, nullable = false, name = "last_name")
    private String lastName;

    @Column(unique = true, nullable = true)
    private String email;

    @Column(unique = true, nullable = false, length = 31)
    private String phone;

    @OneToMany(mappedBy = "customer")
    private Set<Order> orders = new HashSet<>();
}
