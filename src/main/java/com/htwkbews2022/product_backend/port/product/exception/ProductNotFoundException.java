
package com.htwkbews2022.product_backend.port.product.exception;

import org.h2.api.ErrorCode;

public class ProductNotFoundException extends Exception {

    private final ErrorCode code;

    public ProductNotFoundException(String message, Throwable cause, ErrorCode code) {
        super(message, cause);
        this.code = code;
    }

    public ProductNotFoundException(ErrorCode code) {
        super();
        this.code = code;
    }

    public ProductNotFoundException(Throwable cause, ErrorCode code) {
        super(cause);
        this.code = code;
    }

    public ErrorCode getCode() {
        return this.code;
    }
}