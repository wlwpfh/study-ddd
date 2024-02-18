package com.ddd.studyddd.catalog.query;

import com.ddd.studyddd.catalog.command.domain.product.Product;
import com.ddd.studyddd.catalog.command.domain.product.ProductId;
import com.ddd.studyddd.store.Store;

import static com.sun.tools.javac.util.Assert.checkNull;

public class RegisterProductService {
    public ProductId registerNewProduct(NewProductRequest req) {
        Store store = storeRepository.findById(req.getStoreId());
        checkNull(store);

        ProductId productId = productRepository.nextId();
        Product product = store.createProduct(req.getProductId);
        productRepository.save(product);
        return productId;
    }
}
