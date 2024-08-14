package com.module4.service;

import com.module4.model.Product;

import java.util.*;

public class ProductService implements IProductService {

    private static final Map<Integer, Product> products;

    static {
        products = new HashMap<Integer, Product>();
        products.put(1, new Product(1,"dien thoai",43000,"10 cai sam sung","Sam sung"));
        products.put(2, new Product(2,"May Tinh",4000,"10 cai dell","dell"));
        products.put(3, new Product(3,"Nha Dat",41000,"10 mat bang","Viet Nam"));
        products.put(4, new Product(4,"Nha Cai",42000,"di xa","F88.com"));
    }

    @Override
    public List<Product> getProducts() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void createProduct(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product FindByID(int id) {
        return products.get(id);
    }

    @Override
    public void updateProduct(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void deleteProduct(int id) {
        products.remove(id);
    }
    public List<Product> findByName(String name) {
        List<Product> result = new ArrayList<>();

        for (Product product : products.values()) {
            if (product.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(product);
            }
        }

        return result;
    }
}
