package com.dcarminatti.market.cart.exception.category;

public class CategoryNotFoundException extends RuntimeException {
    public CategoryNotFoundException(String categoryNotFound) {
        super(categoryNotFound);
    }

    public CategoryNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CategoryNotFoundException(Throwable cause) {
        super(cause);
    }
}
