package com.teachmeskills.service;

import com.teachmeskills.entity.products.Product;
import com.teachmeskills.entity.shop.Shop;
import com.teachmeskills.entity.shop.Statuses;
import com.teachmeskills.entity.supplier.Supplier;
import com.teachmeskills.interfaces.Addable;
import com.teachmeskills.interfaces.Searchable;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public final class ShopService <T extends Shop> implements Addable<T, Product>, Searchable<T, Product> {
    @Override
    public void addProduct(T shop, Product product, int counter) {
        final List<Product> productsInShop = shop.getProducts();
        final Product searchProduct = searchProductByName(shop, product);

        if (searchProduct != null) {
            searchProduct.setQuantity(searchProduct.getQuantity() + counter);
        } else {
            productsInShop.add(product);
        }
    }

    public void removeProductToShop(Shop shop, Product product) throws RuntimeException {
        final List<Product> productsInShoppingCart = shop.getProducts();
        if (productsInShoppingCart.isEmpty()) {
            throw new RuntimeException("Shopping cart is empty");
        }
        final Product searchProduct = searchProductByName((T) shop, product);
        if (searchProduct != null) {
            productsInShoppingCart.remove(searchProduct);
        }
    }

    @Override
    public Product searchProductByName(T shop, Product product) {
        final List<Product> productsInShop = shop.getProducts();
        Product productInShop;
        for (int i = 0; i < productsInShop.size(); i++) {
            productInShop = productsInShop.get(i);
            if (product.getName().equals(productInShop.getName())) {
                return productInShop;
            }
        }
        return null;
    }

    public void addNoteToWishBook(T shop, String wishNote) {
        shop.getWishBook().add(wishNote);
    }

    public void readWishBookNotes(T shop) {
        System.out.println(shop.getWishBook().getWishBookNotes());
    }
    // принимает список магазинов, отдает высоконагруженные магазины
    // (больше чем 30 сотрудников, > кастомер, открыт
    // потом отсортируем оставшиеся магазины по количеству записей в книге пожеланий

    public List<Shop> sortShops(List<Shop> shops) {
        return shops.stream()
                .filter(s -> s.getEmployees().size() >= 30
                        && s.getCustomers().size() > 15
                        && s.getStatuses().contains(Statuses.Open))
                .sorted(Comparator.comparingInt(s -> s.getWishBook().getWishBookNotes().size()))
                .toList();
    }

    // приходит список магазинов, каждому считаем среднюю зарплату, возвращаем магазин с наибольшой зп
}
