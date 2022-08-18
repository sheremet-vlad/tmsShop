package com.teachmeskills.entity.products;

import com.teachmeskills.entity.products.Product;

import java.util.List;

public class ShoppingCart {
    private List<Product> productsList;

    public ShoppingCart(List<Product> productsList) {
        this.productsList = productsList;
    }

    public List<Product> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<Product> productsList) {
        this.productsList = productsList;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "productsList=" + productsList +
                '}';
    }
}
