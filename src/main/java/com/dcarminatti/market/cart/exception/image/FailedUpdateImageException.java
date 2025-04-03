package com.dcarminatti.market.cart.exception.image;

public class FailedUpdateImageException extends RuntimeException {
    public FailedUpdateImageException(String message) {
        super(message);
    }

    public FailedUpdateImageException(String message, Throwable cause) {
        super(message, cause);
    }

    public FailedUpdateImageException(Throwable cause) {
        super(cause);
    }
}
