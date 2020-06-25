package com.cart.services;

import com.cart.models.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();

    Product findById(Long id);

    void addProduct(Product product);

    void deleteProductById(Long id);

    boolean checkContainById(Long id1, Long id2);
}
