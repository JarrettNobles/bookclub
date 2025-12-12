package com.bookclub.service.impl;
import com.bookclub.model.Book;
import com.bookclub.service.dao.BookDao;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MemBookDao implements BookDao {

    private List<Book> books;

    public MemBookDao() {
        books = new ArrayList<>();

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

    @Override
    public List<Book> list() {
        return books;
    }

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

