package com.teachmeskills.service;

import com.teachmeskills.entity.products.Product;

import java.util.ArrayList;

public class ProductService {

    public static ArrayList<Product> addProduct(Product product,  ArrayList<Product> products) {
        products.add(product);
        return products;
    }

    public static ArrayList<Product> buy(Product product,  ArrayList<Product> products) {
        for (int i = 0; i < products.size(); i++) {
            if (product == products.get(i)) {
                products.remove(product);
            }
        }
        return products;
    }
}
