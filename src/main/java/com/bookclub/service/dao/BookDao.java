package com.bookclub.service.dao;

import com.bookclub.model.Book;
import com.bookclub.service.GenericDao;

/*
 * Program Name: Book Club Application
 * File Name: BookDao.java
 * Author: Jarrett Nobles
 * Description:
 *   This interface defines data access operations for Book
 *   objects within the Book Club application. It extends the
 *   GenericDao interface to provide CRUD functionality using
 *   the Book entity and its ISBN as the primary key.
 */

/**
 * The BookDao interface provides an abstraction layer
 * for performing persistence operations on Book objects.
 */
public interface BookDao extends GenericDao<Book, String> {

}

