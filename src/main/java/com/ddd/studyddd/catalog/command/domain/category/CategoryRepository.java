package com.ddd.studyddd.catalog.command.domain.category;

import org.springframework.data.repository.Repository;

public interface CategoryRepository extends Repository<Category, CategoryId> {
    Category findById(Long categoryId);

}
