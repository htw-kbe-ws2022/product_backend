package com.htwkbews2022.product_backend.port.product.advice;


import com.htwkbews2022.product_backend.port.product.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ProductNotFoundHandling {

    @ResponseBody
    //@ExceptionHandler(value = ProductNotFoundExeption.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String productNotFoundHandler(ProductNotFoundException e) {
        return "Product not Found " + e;
    }

}