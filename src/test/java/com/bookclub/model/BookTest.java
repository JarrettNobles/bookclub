package com.bookclub.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/*
 * Program Name: Book Club Application
 * File Name: BookTest.java
 * Author: Jarrett Nobles
 * Description:
 *   Java unit tests for the Book model class.
 *   Verifies that constructors, getters, and setters
 *   behave correctly.
 */
class BookTest {

    @Test
    void testBookConstructorSetsAllFields() {
        Book book = new Book("978-0-06-112008-4", "To Kill a Mockingbird",
                "A classic novel about justice", "http://example.com", 281);

        assertEquals("978-0-06-112008-4", book.getIsbn());
        assertEquals("To Kill a Mockingbird", book.getTitle());
        assertEquals("A classic novel about justice", book.getDescription());
        assertEquals("http://example.com", book.getInfoUrl());
        assertEquals(281, book.getNumOfPages());
    }

    @Test
    void testBookSettersUpdateFields() {
        Book book = new Book();
        book.setIsbn("978-0-7432-7356-5");
        book.setTitle("The Great Gatsby");
        book.setDescription("A story of the American Dream");
        book.setInfoUrl("http://gatsby.com");
        book.setNumOfPages(180);

        assertEquals("978-0-7432-7356-5", book.getIsbn());
        assertEquals("The Great Gatsby", book.getTitle());
        assertEquals("A story of the American Dream", book.getDescription());
        assertEquals("http://gatsby.com", book.getInfoUrl());
        assertEquals(180, book.getNumOfPages());
    }
}
