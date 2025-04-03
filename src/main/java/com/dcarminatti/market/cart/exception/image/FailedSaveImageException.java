package com.dcarminatti.market.cart.exception.image;

public class FailedSaveImageException extends RuntimeException {
    public FailedSaveImageException(String message) {
        super(message);
    }

    public FailedSaveImageException(String message, Throwable cause) {
        super(message, cause);
    }

    public FailedSaveImageException(Throwable cause) {
        super(cause);
    }
}
