
package com.htwkbews2022.product_backend.core.domain.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Builder
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="products")
public class Product {

    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "title")
    private String title;

    @Column(name = "currency")
    private Currency currency;

    @Column(name = "category")
    private Category category;

    @Column(name = "count")
    private int count;

    @Column(name = "price")
    private double price;

    @Column(name = "isDeleted")
    private boolean isDeleted;

    @Column(name = "description")
    private String description;

    @Column(name = "picURL")
    private String picUrl;

}