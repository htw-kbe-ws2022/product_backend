package com.htwkbews2022.product_backend.port.product.failHandling;


import com.htwkbews2022.product_backend.port.product.exeption.ProductNotFoundExeption;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ProductNotFoundHanling {

    @ResponseBody
    //@ExceptionHandler(value = ProductNotFoundExeption.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String productNotFoundHandler(ProductNotFoundExeption e) {
        return "Product not Found " + e;
    }

}