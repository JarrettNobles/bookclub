package com.bookclub.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/*
 * Program Name: Book Club Application
 * File Name: WishlistItemTest.java
 * Author: Jarrett Nobles
 * Description:
 *   Java unit tests for the WishlistItem model class.
 *   Verifies that constructors, getters, and setters
 *   behave correctly.
 */
class WishlistItemTest {

    @Test
    void testWishlistItemConstructorSetsFields() {
        WishlistItem item = new WishlistItem("978-0-06-112008-4", "To Kill a Mockingbird", "jnobles");

        assertEquals("978-0-06-112008-4", item.getIsbn());
        assertEquals("To Kill a Mockingbird", item.getTitle());
        assertEquals("jnobles", item.getUsername());
    }

    @Test
    void testWishlistItemSettersUpdateFields() {
        WishlistItem item = new WishlistItem();
        item.setId("abc123");
        item.setIsbn("978-0-7432-7356-5");
        item.setTitle("The Great Gatsby");
        item.setUsername("admin");

        assertEquals("abc123", item.getId());
        assertEquals("978-0-7432-7356-5", item.getIsbn());
        assertEquals("The Great Gatsby", item.getTitle());
        assertEquals("admin", item.getUsername());
    }
}
