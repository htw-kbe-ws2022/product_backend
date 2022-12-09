package com.htwkbews2022.product_backend.port.product;

import com.htwkbews2022.product_backend.core.domain.model.Category;
import com.htwkbews2022.product_backend.core.domain.model.Currency;
import com.htwkbews2022.product_backend.core.domain.model.Product;
import com.htwkbews2022.product_backend.port.data.ProductDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class ControlerHelperTest {


    @Test
    void translateDto() {
        ProductDTO productDTO = new ProductDTO();
        UUID uuid = UUID.randomUUID();
        productDTO.setId(uuid);
        productDTO.setTitle("hanfÖl");
        productDTO.setCategory(Category.PROCESSED);
        productDTO.setCount(5);
        productDTO.setPrice(3.99);
        productDTO.setCurrency(Currency.EURO);
        productDTO.setDescription("Verry good homade stuff or oil");
        productDTO.setUrl("http://www.du_do_auch.de");

        Product product = ControlerHelper.translateDto(productDTO);

        assertEquals(uuid, product.getId());
        assertEquals("hanfÖl", product.getTitle());
        assertEquals(Category.PROCESSED, product.getCategory());
        assertEquals(5, product.getCount());
        assertEquals(3.99, product.getPrice());
        assertEquals(Currency.EURO, product.getCurrency());
        assertEquals("Verry good homade stuff or oil", product.getDescription());
        assertEquals("http://www.du_do_auch.de", product.getUrl());

    }
}