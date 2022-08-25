package com.teachmeskills.test;

import com.teachmeskills.entity.shop.Shop;
import com.teachmeskills.entity.shop.WishBook;
import com.teachmeskills.service.ShopService;

public class TestShop {
    public static void main(String[] args) {
        Shop shop = new Shop();
        shop.setWishBook(new WishBook());
        ShopService<Shop> shopService = new ShopService<>();
        shopService.addNoteToWishBook(shop, "Norm");
        shopService.addNoteToWishBook(shop, "Ne norm");
        shopService.readWishBookNotes(shop);
    }
}
