package com.sbouraya.ordermanagement.ordermanagement.api.orders.entities;


import com.sbouraya.ordermanagement.ordermanagement.api.products.entities.Product;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "order_line")
public class OrderLine {
    @EmbeddedId
    private OrderLineKey id;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "order_id")
    private Order order;

    @Column(nullable = false)
    private int quantity = 0;
}
