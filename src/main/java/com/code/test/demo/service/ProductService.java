package com.code.test.demo.service;

import com.code.test.demo.domain.Product;

public interface ProductService {
    void create(Product product);
    Product getProductById(int productId);
    Product update(Product product, int productId);
    void deleteById(int productId);
}
