package com.bookclub.service.impl;

import com.bookclub.model.WishlistItem;
import com.bookclub.service.dao.WishlistDao;

import java.util.ArrayList;
import java.util.List;

public class MemWishlistDao implements WishlistDao {

    private List<WishlistItem> wishlist = new ArrayList<>();

    public MemWishlistDao() {
        wishlist.add(new WishlistItem("9780544339683", "The Hobbit or There and Back Again"));
        wishlist.add(new WishlistItem("9780261103573", "The Fellowship of the Ring"));
        wishlist.add(new WishlistItem("9780261102361", "The Two Towers"));
        wishlist.add(new WishlistItem("9780261102378", "The Return of the King"));
    }

    @Override
    public List<WishlistItem> list() {
        return wishlist;
    }

    @Override
    public WishlistItem find(String isbn) {
        return wishlist.stream()
                .filter(w -> w.getIsbn().equals(isbn))
                .findFirst()
                .orElse(null);
    }
}
