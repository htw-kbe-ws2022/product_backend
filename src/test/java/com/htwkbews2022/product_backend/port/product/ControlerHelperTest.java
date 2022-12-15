package com.htwkbews2022.product_backend.port.product;

import com.htwkbews2022.product_backend.core.domain.model.Category;
import com.htwkbews2022.product_backend.core.domain.model.Currency;
import com.htwkbews2022.product_backend.core.domain.model.Product;
import com.htwkbews2022.product_backend.port.data.ProductDTO;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

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
        productDTO.setPicUrl("http://www.du_do_auch.de");

        Product product = ControlerHelper.translateDto(productDTO);

        assertEquals(uuid, product.getId());
        assertEquals("hanfÖl", product.getTitle());
        assertEquals(Category.PROCESSED, product.getCategory());
        assertEquals(5, product.getCount());
        assertEquals(3.99, product.getPrice());
        assertEquals(Currency.EURO, product.getCurrency());
        assertEquals("Verry good homade stuff or oil", product.getDescription());
        assertEquals("http://www.du_do_auch.de", product.getPicUrl());

    }

    @Test
    void translateNullDto() {
        ProductDTO productDTO = new ProductDTO();
        UUID uuid = null;
        productDTO.setId(uuid);
        productDTO.setTitle(null);
        productDTO.setCategory(null);
        productDTO.setCount(-1);
        productDTO.setPrice(-1);
        productDTO.setCurrency(null);
        productDTO.setDescription(null);
        productDTO.setPicUrl(null);

        Product product = ControlerHelper.translateDto(productDTO);

        assertEquals(uuid, product.getId());
        assertNull(product.getTitle());
        assertNull(product.getCategory());
        assertEquals(-1, product.getCount());
        assertEquals(-1, product.getPrice());
        assertNull(product.getCurrency());
        assertNull(product.getDescription());
        assertNull(product.getPicUrl());

    }
}