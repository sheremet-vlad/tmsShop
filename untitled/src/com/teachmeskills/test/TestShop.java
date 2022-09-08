package com.teachmeskills.test;


import com.teachmeskills.entity.shop.WishBook;
import com.teachmeskills.entity.shop.WishBookNote;
import com.teachmeskills.service.productService.ShopService;

import java.io.IOException;

public class TestShop {
    public static void main(String[] args) throws IOException {
        WishBookNote[] wishBookNote = new WishBookNote[]{new WishBookNote("asdsad"),
                new WishBookNote("asddfgdf"),
        new WishBookNote("asdasd")};
        WishBook wishBook = new WishBook(wishBookNote);
        ShopService shopService = new ShopService();
        //shopService.readWishBook(wishBook);
    }
}
