
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
        product.setPicUrl(productDTO.picUrl);
        return product;
    }

    static ProductDTO buildDTOfromProduct(Product product) {
        ProductDTO productDto = new ProductDTO();
        productDto.setId(product.getId());
        productDto.setTitle(product.getTitle());
        productDto.setCurrency(product.getCurrency());
        productDto.setCategory(product.getCategory());
        productDto.setCount(product.getCount());
        productDto.setPrice(product.getPrice());
        productDto.setDescription(product.getDescription());
        productDto.setPicUrl(product.getPicUrl());
        return productDto;
    }
}