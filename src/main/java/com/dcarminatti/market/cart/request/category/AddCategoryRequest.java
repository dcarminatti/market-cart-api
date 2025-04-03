package com.dcarminatti.market.cart.request.category;

import lombok.Data;

@Data
public class AddCategoryRequest {
    private Long id;
    private String name;
    private String description;
}
