package com.ddd.studyddd.catalog.command.domain.product;

import com.ddd.studyddd.catalog.command.domain.category.CategoryId;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "product")
public class Product {
    @Embedded
    private ProductId id;

    @ElementCollection
    @CollectionTable(name = "product_category", joinColumns = @JoinColumn(name = "product_id"))
    private Set<CategoryId> categoryIds;

}
