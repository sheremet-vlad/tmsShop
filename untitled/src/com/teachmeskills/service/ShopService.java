package com.teachmeskills.service;

import com.teachmeskills.entity.shop.Shop;
import com.teachmeskills.entity.shop.WishBook;
import com.teachmeskills.entity.shop.WishBookNote;

import java.util.Arrays;

public class ShopService {
    //магазины - открыть, закрыть, ремонт, переучет, уборка, прочитать книгу пожеланий
    public void readWishBook(WishBook wishBook) {
        System.out.println(Arrays.toString(wishBook.getWishBookNotes()));
    }

    public void addWishToWishBook(WishBook wishBook, String text) {
        WishBookNote wishBookNote = new WishBookNote(text);
        WishBookNote[] wishBookNotes = Arrays.copyOf(wishBook.getWishBookNotes(),
                wishBook.getWishBookNotes().length + 1);
        wishBookNotes[wishBookNotes.length - 1] = wishBookNote;
        wishBook.setWishBookNotes(wishBookNotes);
    }
}
