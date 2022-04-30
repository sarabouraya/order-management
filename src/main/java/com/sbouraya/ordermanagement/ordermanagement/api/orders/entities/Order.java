package com.sbouraya.ordermanagement.ordermanagement.api.orders.entities;

import com.sbouraya.ordermanagement.ordermanagement.api.customers.entities.Customer;
import com.sbouraya.ordermanagement.ordermanagement.api.products.entities.Product;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_time", nullable = false)
    private LocalDateTime dateTime;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToMany
    private Set<Product> products = new HashSet<>();

}
