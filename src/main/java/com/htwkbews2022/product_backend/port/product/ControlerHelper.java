
package com.htwkbews2022.product_backend.port.product;

import com.htwkbews2022.product_backend.core.domain.model.Product;
import com.htwkbews2022.product_backend.port.data.ProductDTO;

public class ControlerHelper {

    static Product translateDto(ProductDTO productDTO){
        Product product = new Product();
        product.setId(productDTO.id);
        product.setTitle(productDTO.title);
        product.setCurrency(productDTO.currency);
        product.setCategory(productDTO.category);
        product.setCount(productDTO.count);
        product.setPrice(productDTO.price);
        product.setDescription(productDTO.description);
        product.setUrl(productDTO.url);
        return product;
    }
}