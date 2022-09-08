package com.teachmeskills.service.productService;

import com.teachmeskills.entity.products.Product;
import com.teachmeskills.entity.shop.Shop;
import com.teachmeskills.interfaces.productInterface.Removable;
import com.teachmeskills.interfaces.productInterface.Searchable;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class ShopService <T extends Shop> implements Removable<T>, Searchable<T> {
 
    public void addProductToShop(T shop, final Product product, final int quantityProduct) {
        final List<Product> productsInShop = shop.getProducts();
        final Product searchResult = searchProductByName(shop, product);
        if (searchResult != null) {
            searchResult.setQuantity(searchResult.getQuantity() + quantityProduct);
        } else {
            Product productToShop = product.cloneProduct();
            productToShop.setQuantity(quantityProduct);
            productsInShop.add(productToShop);
        }
    }

    public boolean isValidQuantityProductInShop(T shop, final Product product, final int quantityProduct) {
        final Product searchResult = searchProductByName(shop, product);
        return searchResult != null && searchResult.getQuantity() >= quantityProduct;
    }

    public void editQuantityProductInShop(T shop, final Product product, final int quantityProduct)
            throws RuntimeException {

        final Product searchResult = searchProductByName(shop, product);
        if ((searchResult != null) && (searchResult.getQuantity() >= quantityProduct)) {
            searchResult.setQuantity(searchResult.getQuantity() - quantityProduct);
        } else {
            throw new RuntimeException("This product " + product.getName() + " is not available in the store");
        }
    }

    public Map<String, Double> nameOfProductAndTotalPriceOfProduct(final Shop shop) {
        return shop
                .getProducts()
                .stream()
                .collect(
                        Collectors
                                .groupingBy(
                                        Product::getName,
                                        Collectors.summingDouble(product -> product.getQuantity() * product.getPrice())
                                )
                );
    }

    @Override
    public void removeProduct(T shop, final Product product) throws RuntimeException {
        final List<Product> productInShop = shop.getProducts();
        if (productInShop.isEmpty()) {
            throw new RuntimeException("There is no products in this shop");
        }
        final Product searchResult = searchProductByName(shop, product);
        if (searchResult != null) {
            productInShop.remove(searchResult);
        } else {
            throw new RuntimeException("This product " + product.getName() + " is not available in the store");
        }
    }

    @Override
    public Product searchProductByName(T shop, final Product product) {
        final List<Product> productsInShop = shop.getProducts();
        return productsInShop
                .stream()
                .filter(productInShop -> productInShop.getName().equals(product.getName()))
                .findFirst()
                .orElse(null);
    }
}
