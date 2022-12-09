
package com.htwkbews2022.product_backend.core.services;

import com.htwkbews2022.product_backend.core.domain.model.Product;
import com.htwkbews2022.product_backend.core.interfaces.ProductInterface;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService implements ProductInterface {
    @Override
    public void createProduct(Product product) {

    }

    @Override
    public Product updateProduct(Product product) {
        return null;
    }

    @Override
    public void deleteProduct(Product product) {

    }

    @Override
    public Product getProduct(UUID id) {
        return null;
    }

    @Override
    public List<Product> getProducts() {
        return null;
    }

    @Override
    public int incrementProduct(int count) {
        return 0;
    }

    @Override
    public int decrementProduct(int count) {
        return 0;
    }

    @Override
    public boolean addToCard(Product product) {
        return false;
    }
}