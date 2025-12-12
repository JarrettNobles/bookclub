package com.bookclub.service.impl;
import com.bookclub.model.WishlistItem;
import com.bookclub.service.dao.WishlistDao;
import java.util.ArrayList;
import java.util.List;

/*
 * Program Name: Book Club Application
 * File Name: MemWishlistDao.java
 * Author: Jarrett Nobles
 * Date: MM/DD/YYYY
 * Course: COURSE-ID – Course Name
 * Instructor: Instructor Name
 * Description:
 *   This class provides an in-memory implementation of the
 *   WishlistDao interface. It is used to manage wishlist items
 *   during development and testing without requiring a
 *   persistent data store.
 */

/**
 * The MemWishlistDao class implements the WishlistDao interface
 * using an in-memory collection to store WishlistItem objects.
 */
public class MemWishlistDao implements WishlistDao {

    // ----------------------------------------------
    // Instance Variables
    // ----------------------------------------------

    /**
     * In-memory collection of wishlist items.
     */
    private List<WishlistItem> wishlist = new ArrayList<>();

    // ----------------------------------------------
    // Constructors
    // ----------------------------------------------

    /**
     * Constructs a MemWishlistDao and initializes sample
     * wishlist data.
     */
    public MemWishlistDao() {
        wishlist.add(new WishlistItem("9780544339683", "The Hobbit or There and Back Again"));
        wishlist.add(new WishlistItem("9780261103573", "The Fellowship of the Ring"));
        wishlist.add(new WishlistItem("9780261102361", "The Two Towers"));
        wishlist.add(new WishlistItem("9780261102378", "The Return of the King"));
    }

    // ----------------------------------------------
    // DAO Method Implementations
    // ----------------------------------------------

    /**
     * Retrieves all wishlist items stored in memory.
     *
     * @return A list of all WishlistItem objects
     */
    @Override
    public List<WishlistItem> list() {
        return wishlist;
    }

    /**
     * Retrieves a WishlistItem by its ISBN.
     *
     * @param isbn The ISBN identifier of the wishlist item
     * @return The matching WishlistItem if found; otherwise, null
     */
    @Override
    public WishlistItem find(String isbn) {
        return wishlist.stream()
                .filter(w -> w.getIsbn().equals(isbn))
                .findFirst()
                .orElse(null);
    }
}
