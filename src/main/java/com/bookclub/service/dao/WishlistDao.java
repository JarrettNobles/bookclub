package com.bookclub.service.dao;

import com.bookclub.model.WishlistItem;
import com.bookclub.service.GenericCrudDao;

/*
 * Program Name: Book Club Application
 * File Name: WishlistDao.java
 * Author: Jarrett Nobles
 * Description:
 *   This interface defines data access operations for WishlistItem
 *   objects within the Book Club application. It extends the
 *   GenericDao interface and includes additional lookup
 *   functionality specific to wishlist items.
 */

/**
 * The WishlistDao interface provides an abstraction layer
 * for performing persistence operations on WishlistItem objects.
 */
public interface WishlistDao extends GenericCrudDao<WishlistItem, String> {

    boolean remove(String key);

    /**
     * Retrieves a WishlistItem by its ISBN.
     *
     * @param isbn The ISBN identifier of the wishlist item
     * @return The matching WishlistItem, or null if not found
     */
    WishlistItem find(String isbn);
}

