package com.teachmeskills.service;

import com.teachmeskills.entity.products.ShoppingCart;
import com.teachmeskills.entity.products.Product;
import com.teachmeskills.interfaces.Addable;
import com.teachmeskills.interfaces.Searchable;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ShoppingCartService <T extends ShoppingCart> implements Addable<T, Product>,
        Searchable<T, Product>, Comparator<Product> {

    @Override
    public void addProduct(T shoppingCart, Product product, int counter) {
        final List<Product> productsInShoppingCart = shoppingCart.getProductsList();
        final Product searchProduct = searchProductByName(shoppingCart, product);

        if (searchProduct != null) {
            searchProduct.setQuantity(searchProduct.getQuantity() + counter);
        } else {
            productsInShoppingCart.add(product);
        }
    }

    @Override
    public Product searchProductByName(T shoppingCart, Product product) {
        final List<Product> productsInShoppingCart = shoppingCart.getProductsList();
        Product productInShoppingCart;
        for (int i = 0; i < productsInShoppingCart.size(); i++) {
            productInShoppingCart = productsInShoppingCart.get(i);
            if (product.getName().equals(productInShoppingCart.getName())) {
                return productInShoppingCart;
            }
        }
        return null;
    }

    public void removeProductToShoppingCart(ShoppingCart shoppingCart, Product product) throws RuntimeException {
        final List<Product> productsInShoppingCart = shoppingCart.getProductsList();
        if (productsInShoppingCart.isEmpty()) {
            throw new RuntimeException("Shopping cart is empty");
        }
        final Product searchProduct = searchProductByName((T) shoppingCart, product);
        if (searchProduct != null) {
            productsInShoppingCart.remove(searchProduct);
        }
    }

    private double calculateOrderAmount(ShoppingCart shoppingCart) throws RuntimeException {
        double totalPurchaseAmount = 0;
        final List<Product> productsInShoppingCart = shoppingCart.getProductsList();

        if (productsInShoppingCart.isEmpty()) {
            throw new RuntimeException("Shopping cart is empty");
        }
        Product productInShoppingCart;
        for (int i = 0; i < productsInShoppingCart.size(); i++) {
            productInShoppingCart = productsInShoppingCart.get(i);
            totalPurchaseAmount += productInShoppingCart.getQuantity() * productInShoppingCart.getPrice();
        }
        return totalPurchaseAmount;
    }

    public void displayInformationProductsInShoppingCart(ShoppingCart shoppingCart) throws RuntimeException {
        final List<Product> productsInShoppingCart = shoppingCart.getProductsList();
        if (productsInShoppingCart.isEmpty()) {
            throw new RuntimeException("Shopping cart is empty");
        }

        System.out.printf("%-15s%-15s%-15s%-15s%-15s%n",
                "Id product",
                "Product name",
                "Type product",
                "Quantity",
                "Cost per unit");
        System.out.println("--------------------------------------------------------------------------");

        Product productInShoppingCart;
        for (int i = 0; i < productsInShoppingCart.size(); i++) {
            productInShoppingCart = productsInShoppingCart.get(i);
            System.out.printf("%-15s%-15s%-15s%-15s%-15s%n",
                    productInShoppingCart.getProductId(),
                    productInShoppingCart.getName(),
                    productInShoppingCart.getTypeProduct(),
                    productInShoppingCart.getQuantity(),
                    productInShoppingCart.getPrice());
        }

        System.out.println("--------------------------------------------------------------------------");
    }

    private List<String> generateCheck(ShoppingCart shoppingCart) throws RuntimeException {
        final List<Product> productsInShoppingCart = shoppingCart.getProductsList();
        if (productsInShoppingCart.isEmpty()) {
            throw new RuntimeException("Shopping cart is empty");
        }
        List<String> productsList = new ArrayList<>();
        productsList.add("---------------Check---------------");
        Product productInShoppingCart;
        for (int i = 0; i < productsInShoppingCart.size(); i++) {
            productInShoppingCart = productsInShoppingCart.get(i);
            productsList.add(productInShoppingCart.getName() +
                    "  " + productInShoppingCart.getQuantity() +
                    " * " +  productInShoppingCart.getPrice() +
                    " = " + productInShoppingCart.getQuantity() * productInShoppingCart.getPrice());
        }
        productsList.add("-----------------------------------");
        productsList.add("Order amount: " + calculateOrderAmount(shoppingCart));
        return productsList;
    }

    public void buyProductsFromCheck(final List<String> check, String path) throws RuntimeException, IOException {
        if (check.isEmpty()) {
            throw new RuntimeException("Check is empty");
        }
        else {
            Files.write(Paths.get(path), check, StandardCharsets.UTF_8);
        }
    }

    @Override
    public int compare(Product firstProduct, Product secondProduct) {
        return Double.compare(firstProduct.getPrice(), secondProduct.getPrice());
    }
}

