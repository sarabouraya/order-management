package com.sbouraya.ordermanagement.ordermanagement.api.products.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "product_medias")
public class ProductMedia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "file_name", nullable = false)
    private String fileName;

    @Column(nullable = false)
    private String path;

    @Column(nullable = false)
    private String mimeType;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

}
