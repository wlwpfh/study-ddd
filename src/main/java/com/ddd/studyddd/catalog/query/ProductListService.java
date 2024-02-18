package com.ddd.studyddd.catalog.query;

import com.ddd.studyddd.catalog.command.domain.category.Category;
import com.ddd.studyddd.catalog.command.domain.category.CategoryRepository;
import com.ddd.studyddd.catalog.command.domain.product.Product;
import com.ddd.studyddd.catalog.command.domain.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductListService {
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    public Page<Product> getProductOfCategory(Long categoryId, int page, int size){
        Category category = categoryRepository.findById(categoryId);
        checkCategory(category);
        List<Product> products = productRepository.findByCategoryId(category.getId(), page, size);
        int totalCount = productRepository.countsByCategoryId(category.getId());
        return new Page(page, size, totalCount, products);
    }
}
