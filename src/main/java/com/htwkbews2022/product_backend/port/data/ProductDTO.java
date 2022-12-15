
package com.htwkbews2022.product_backend.port.data;

import com.htwkbews2022.product_backend.core.domain.model.Category;
import com.htwkbews2022.product_backend.core.domain.model.Currency;
import lombok.Data;

import java.util.UUID;
@Data
public class ProductDTO {

    public UUID id;
    public String title;
    public Currency currency;
    public Category category;
    public int count;
    public double price;
    public String description;
    public String picUrl;
    public int countForCard;
}

