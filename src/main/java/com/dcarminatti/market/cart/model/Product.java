package com.dcarminatti.market.cart.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String brand;
    private Float price;
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Image> images;

    public Product(String name, String description, String brand, Float price, int quantity, Category category) {
        this.name = name;
        this.description = description;
        this.brand = brand;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }
}