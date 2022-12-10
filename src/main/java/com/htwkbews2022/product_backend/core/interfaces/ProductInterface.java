package com.htwkbews2022.product_backend.core.interfaces;

import com.htwkbews2022.product_backend.core.domain.model.Product;

import java.util.List;
import java.util.UUID;

public interface ProductInterface {

    void createProduct(Product product);

    Product updateProduct(Product product);

    void deleteProduct(Product product);

    Product getProduct(UUID id);

    List<Product> getProducts();

    int incrementProduct(UUID uuid, int count);

    int decrementProduct(UUID uuid, int count);

    boolean addToCard(Product product);



}