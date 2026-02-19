package com.bookclub.service.dao;

import com.bookclub.model.BookOfTheMonth;
import com.bookclub.service.GenericCrudDao;

/*
 * Program Name: Book Club Application
 * File Name: BookOfTheMonthDao.java
 * Author: Jarrett Nobles
 * Description:
 *   This interface defines data access operations for BookOfTheMonth
 *   objects within the Book Club application. It extends the
 *   GenericCrudDao interface for persistence operations specific
 *   to monthly book selections.
 */

/**
 * The BookOfTheMonthDao interface provides an abstraction layer
 * for performing persistence operations on BookOfTheMonth objects.
 */
public interface BookOfTheMonthDao extends GenericCrudDao<BookOfTheMonth, String> {
    BookOfTheMonth add(BookOfTheMonth bookOfTheMonth);
    BookOfTheMonth remove(BookOfTheMonth bookOfTheMonth);
}
