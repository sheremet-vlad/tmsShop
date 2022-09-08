package com.teachmeskills.service.productService;

import com.teachmeskills.entity.shop.ShoppingCart;
import com.teachmeskills.entity.products.Product;
import com.teachmeskills.entity.shop.Shop;
import com.teachmeskills.interfaces.productInterface.Removable;
import com.teachmeskills.interfaces.productInterface.Searchable;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ShoppingCartService <T extends ShoppingCart> implements Removable<T>, Searchable<T>, Comparator<Product> {

    public void addProductToShoppingCart(T shoppingCart,
                                         final Product product,
                                         final int quantityProduct,
                                         final Shop shop) throws RuntimeException {

        final ShopService<Shop> shopService = new ShopService<>();
        final boolean isValid = shopService.isValidQuantityProductInShop(shop, product, quantityProduct);
        if (!isValid) {
            throw new RuntimeException("There are not enough products in the store");
        }

        final List<Product> productsInShoppingCart = shoppingCart.getProductList();
        final Product searchResult  = searchProductByName(shoppingCart, product);

        if (searchResult != null) {
            searchResult.setQuantity(searchResult.getQuantity() + quantityProduct);
        } else {
            Product productToShoppingCart = product.cloneProduct();
            productToShoppingCart.setQuantity(quantityProduct);
            productsInShoppingCart.add(productToShoppingCart);
        }
        shopService.editQuantityProductInShop(shop, product, quantityProduct);
    }

    @Override
    public Product searchProductByName(T shoppingCart, final Product product) {
        final List<Product> productsInShoppingCart = shoppingCart.getProductList();
        return productsInShoppingCart
                .stream()
                .filter(productInShoppingCart -> productInShoppingCart.getName().equals(product.getName()))
                .findFirst().orElse(null);
    }

    public void displayInformationProductsInShoppingCart(final ShoppingCart shoppingCart) throws RuntimeException {
        final List<Product> productsInShoppingCart = shoppingCart.getProductList();
        doTrowIfEmpty(productsInShoppingCart);

        System.out.printf("%-15s%-15s%-15s%-15s%-15s%n",
                "Id product",
                "Product name",
                "Type product",
                "Quantity",
                "Cost per unit");
        System.out.println("--------------------------------------------------------------------------");

        productsInShoppingCart
                .forEach(product -> System.out.printf("%-15s%-15s%-15s%-15s%-15s%n",
                        product.getProductId(),
                        product.getName(),
                        product.getTypeProduct(),
                        product.getQuantity(),
                        product.getPrice()));

        System.out.println("--------------------------------------------------------------------------");
    }

    public List<String> generateCheck(final ShoppingCart shoppingCart) throws RuntimeException {
        final List<Product> productsInShoppingCart = shoppingCart.getProductList();
        doTrowIfEmpty(productsInShoppingCart);

        List<String> productList = new ArrayList<>();
        productList.add("---------------Check---------------");

        productsInShoppingCart
                .forEach(product -> productList.add(
                                product.getName() + "  " +
                                product.getQuantity() + " * " +
                                product.getPrice() + " = " +
                                product.getQuantity() * product.getPrice()
                        )
                );

        productList.add("-----------------------------------");
        productList.add("Order amount: " + calculateCostOfProductsInShoppingCart(shoppingCart));

        return productList;
    }

    public void buyProductsFromCheck(final List<String> check, final String path) throws RuntimeException, IOException {
        if (check.isEmpty()) {
            throw new RuntimeException("Check is empty");
        }
        else {
            Files.write(Paths.get(path), check, StandardCharsets.UTF_8);
        }
    }

    @Override
    public int compare(final Product firstProduct, final Product secondProduct) {
        return Double.compare(firstProduct.getPrice(), secondProduct.getPrice());
    }

    @Override
    public void removeProduct(T shoppingCart, final Product product) throws RuntimeException {
        final List<Product> productsInShoppingCart = shoppingCart.getProductList();
        doTrowIfEmpty(productsInShoppingCart);

        final Product searchResult = searchProductByName(shoppingCart, product);

        if (searchResult != null) {
            productsInShoppingCart.remove(searchResult);
        } else {
            throw new RuntimeException("This product " +
                    product.getName() +
                    " is not available in the shopping cart");
        }
    }

    public int calculateQuantityProductsInShoppingCart(final ShoppingCart shoppingCart) {
        final List<Product> productsInShoppingCart = shoppingCart.getProductList();
        return  productsInShoppingCart
                .stream()
                .mapToInt(Product::getQuantity).sum();
    }

    public double calculateCostOfProductsInShoppingCart(final ShoppingCart shoppingCart) {
        final List<Product> productsInShoppingCart = shoppingCart.getProductList();
        return  productsInShoppingCart
                .stream()
                .mapToDouble(product -> product.getQuantity() * product.getPrice()).sum();
    }

    private void doTrowIfEmpty(final List<Product> productsInShoppingCart) {
        if (productsInShoppingCart.isEmpty()) {
            throw new RuntimeException("Shopping cart is empty");
        }
    }
}

