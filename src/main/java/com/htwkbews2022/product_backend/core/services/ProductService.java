
package com.htwkbews2022.product_backend.core.services;

import com.htwkbews2022.product_backend.core.domain.model.Product;
import com.htwkbews2022.product_backend.core.interfaces.ProductInterface;
import com.htwkbews2022.product_backend.core.interfaces.ProductRepoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService implements ProductInterface {
    @Autowired
    ProductRepoInterface productRepo;

    @Override
    public void createProduct(Product product) {
        productRepo.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepo.save(changeProductDetail(product));
    }

    @Override
    public void deleteProduct(Product product) {
        var tmpProduct = productRepo.getReferenceById(product.getId());
        tmpProduct.setDeleted(true);
        productRepo.save(tmpProduct);
    }

    @Override
    public Product getProduct(UUID id) {
        return productRepo.getReferenceById(id);

    }

    @Override
    public List<Product> getProducts() {
        return productRepo.findAll();
    }

    @Override
    public int incrementProduct(UUID uuid, int count) {
        return changeCount(uuid, count);
    }

    @Override
    public int decrementProduct(UUID uuid, int count) {
        return changeCount(uuid, count);
    }

    @Override
    public boolean addToCard(UUID uuid, int count) {
        // todo send to Cart
        changeCount(uuid, count * -1);
        return false;
    }

    //helper//


    protected int changeCount(UUID uuid, int count) {
        var tmpProduct = productRepo.getReferenceById(uuid);
        var newCount = tmpProduct.getCount() + count;
        tmpProduct.setCount(newCount);
        return newCount;
    }

    protected Product changeProductDetail(Product newProduct) {
        Product orgProduct = productRepo.getReferenceById(newProduct.getId());
        orgProduct.setTitle((isEqulasOrNullOrMinusOne(newProduct.getTitle(), orgProduct.getTitle())));
        orgProduct.setCurrency((isEqulasOrNullOrMinusOne(newProduct.getCurrency(), orgProduct.getCurrency())));
        orgProduct.setCategory((isEqulasOrNullOrMinusOne(newProduct.getCategory(), orgProduct.getCategory())));
        orgProduct.setCount((isEqulasOrNullOrMinusOne(newProduct.getCount(), orgProduct.getCount())));
        orgProduct.setPrice((isEqulasOrNullOrMinusOne(newProduct.getPrice(), orgProduct.getPrice())));
        orgProduct.setDescription((isEqulasOrNullOrMinusOne(newProduct.getTitle(), orgProduct.getTitle())));
        orgProduct.setUrl((isEqulasOrNullOrMinusOne(newProduct.getTitle(), orgProduct.getTitle())));
        return orgProduct;
    }

    private <T> T isEqulasOrNullOrMinusOne(T one, T two) {
        if (one == null || one.equals(-1) || one != two)
            return two;
        return one;
    }
}