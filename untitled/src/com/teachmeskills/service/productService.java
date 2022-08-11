package com.teachmeskills.service;

import com.teachmeskills.entity.products.Product;

import java.util.ArrayList;

public class productService {

    public static ArrayList<Product> addCart(ArrayList<Product> products, Product product) {
        products.add(product);
        return products;
    }

    public static ArrayList<Product> removeCart(ArrayList<Product> products, Product product) {
        for (int i = 0; i < products.size(); i++) {
            if (product == products.get(i)) {
                products.remove(product);
            }
        }
        return products;
    }

    public void addToStore(final Product product, final int quantity)
    {
        product.setQuantity(product.getQuantity() + quantity);
    }

}
