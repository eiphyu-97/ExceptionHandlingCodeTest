package com.code.test.demo.service;

import com.code.test.demo.controller.ProductController;
import com.code.test.demo.domain.Customer;
import com.code.test.demo.domain.Product;
import com.code.test.demo.exception.customer.CustomerNotFoundException;
import com.code.test.demo.exception.product.ProductNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private static List<Product> allProducts;

    public ProductServiceImpl() {
        System.out.println("Product list initialized...");
        allProducts = new ArrayList<>();
    }

    @Override
    public void create(Product product) {
        allProducts.add(product);
    }

    @Override
    public Product getProductById(int productId) {
        return allProducts.stream().filter(prod -> prod.getProdId() == productId).findAny().orElseThrow(() -> new ProductNotFoundException("Product is not found by id " + productId));
    }

    @Override
    public Product update(Product product, int productId) {
        boolean isRemovalSuccess = allProducts.removeIf(prod -> productId == prod.getProdId());
        if(isRemovalSuccess) {
            allProducts.add(product);
            return product;
        }
        throw new ProductNotFoundException("Product is not found by id " + productId);
    }

    @Override
    public void deleteById(int productId) {
        allProducts.removeIf(prod -> productId == prod.getProdId());
    }
}