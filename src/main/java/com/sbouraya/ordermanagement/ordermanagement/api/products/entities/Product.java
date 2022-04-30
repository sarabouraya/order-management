package com.sbouraya.ordermanagement.ordermanagement.api.products.entities;


import com.sbouraya.ordermanagement.ordermanagement.api.orders.entities.Order;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 31, nullable = false, name = "product_name")
    private String name;

    @Column(length = 31, nullable = false, name = "register_number")
    private String regNumber;

    @Column(length = 31, nullable = false)
    private double price;

    @Column
    private long quantity = 0;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<ProductMedia> medias = new HashSet<>();

    @ManyToMany
    private Set<Order> orders = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "product_categories",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> categories = new HashSet<>();
}
