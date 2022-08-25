package com.teachmeskills.entity.shop;

import java.util.ArrayList;
import java.util.List;

public class WishBook {
    List<String> wishBookNotes = new ArrayList<>();

    public WishBook() {
    }

    public void add(String wishNote) {
        wishBookNotes.add(wishNote);
    }

    public List<String> getWishBookNotes() {
        return wishBookNotes;
    }
}
