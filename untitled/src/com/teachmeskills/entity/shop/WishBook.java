package com.teachmeskills.entity.shop;

public class WishBook {
    private WishBookNote[] wishBookNotes;

    public WishBook() {
    }

    public WishBook(WishBookNote[] wishBookNotes) {
        this.wishBookNotes = wishBookNotes;
    }

    public WishBookNote[] getWishBookNotes() {
        return wishBookNotes;
    }

    public void setWishBookNotes(WishBookNote[] wishBookNotes) {
        this.wishBookNotes = wishBookNotes;
    }
}
