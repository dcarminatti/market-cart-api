package com.dcarminatti.market.cart.request.product;

import com.dcarminatti.market.cart.model.Category;
import lombok.Data;

@Data
public class ProductUpdateRequest {
    private Long id;
    private String name;
    private String description;
    private String brand;
    private Float price;
    private int quantity;
    private Category category;
}
