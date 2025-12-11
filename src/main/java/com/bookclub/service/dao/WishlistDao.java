package com.bookclub.service.dao;

import com.bookclub.model.WishlistItem;
import com.bookclub.service.GenericDao;

public interface WishlistDao extends GenericDao<WishlistItem> {
    WishlistItem find(String isbn);
}
