package com.dcarminatti.market.cart.exception.category;

public class CategoryAlreadyExistsException extends RuntimeException {
    public CategoryAlreadyExistsException(String message) {
        super(message);
    }

    public CategoryAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public CategoryAlreadyExistsException(Throwable cause) {
        super(cause);
    }
}
