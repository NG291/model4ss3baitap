package com.module4.service;

import com.module4.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getProducts();
    void createProduct(Product product);
    Product FindByID(int id);
    void updateProduct( int id ,Product product);
    void deleteProduct(int id);
}
