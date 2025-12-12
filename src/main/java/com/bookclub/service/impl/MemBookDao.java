package com.bookclub.service.impl;
import com.bookclub.model.Book;
import com.bookclub.service.dao.BookDao;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Program Name: Book Club Application
 * File Name: MemBookDao.java
 * Author: Jarrett Nobles
 * Description:
 *   This class provides an in-memory implementation of the
 *   BookDao interface. It is primarily used for development,
 *   testing, and demonstration purposes without requiring
 *   a persistent database.
 */

/**
 * The MemBookDao class implements the BookDao interface
 * using an in-memory collection to store Book objects.
 */
public class MemBookDao implements BookDao {

    // ----------------------------------------------
    // Instance Variables
    // ----------------------------------------------

    /**
     * In-memory collection of Book objects.
     */
    private List<Book> books;

    // ----------------------------------------------
    // Constructors
    // ----------------------------------------------

    /**
     * Constructs a MemBookDao and initializes sample book data.
     */
    public MemBookDao() {
        books = new ArrayList<>();

        // Initialize sample book records
        books.add(new Book(
                "1111",
                "The First Book",
                "Description of the first book.",
                250,
                Arrays.asList("Author One", "Author Two")
        ));

        books.add(new Book(
                "2222",
                "Learning Java",
                "A great introduction to Java programming.",
                320,
                Arrays.asList("John Doe")
        ));

        books.add(new Book(
                "3333",
                "Spring Boot Essentials",
                "Getting started with Spring Boot.",
                280,
                Arrays.asList("Jane Smith")
        ));

        books.add(new Book(
                "4444",
                "Database Concepts",
                "Understanding relational databases.",
                410,
                Arrays.asList("Alan Turing")
        ));

        books.add(new Book(
                "5555",
                "Algorithms Explained",
                "A guide to common algorithms.",
                350,
                Arrays.asList("Grace Hopper")
        ));
    }

    // ----------------------------------------------
    // DAO Method Implementations
    // ----------------------------------------------

    /**
     * Retrieves all Book records stored in memory.
     *
     * @return A list of all Book objects
     */
    @Override
    public List<Book> list() {
        return books;
    }

    /**
     * Retrieves a Book by its ISBN.
     *
     * @param key The ISBN identifier of the book
     * @return The matching Book if found; otherwise, null
     */
    @Override
    public Book find(String key) {
        for (Book b : books) {
            if (b.getIsbn().equals(key)) {
                return b;
            }
        }
        return null;
    }
}
