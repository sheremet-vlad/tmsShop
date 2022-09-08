package com.teachmeskills.entity.shop;

import com.teachmeskills.entity.products.Product;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> productList;

    public ShoppingCart() {
        this.productList = new ArrayList<>();
    }
    public ShoppingCart(List<Product> productList) {
        this.productList = productList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "productsList=" + productList +
                '}';
    }
}
