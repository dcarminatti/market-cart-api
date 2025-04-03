package com.dcarminatti.market.cart.request.category;

import lombok.Data;

@Data
public class CategoryUpdateRequest {
    private Long id;
    private String name;
    private String description;
}
