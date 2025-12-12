package com.bookclub.model;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/*
 * Program Name: Book Club Application
 * File Name: WishlistItem.java
 * Author: Jarrett Nobles
 * Date: MM/DD/YYYY
 * Course: COURSE-ID – Course Name
 * Instructor: Instructor Name
 * Description:
 *   This class represents an item stored in a user's wishlist
 *   within the Book Club application. It contains basic book
 *   information required to identify and display wishlist items.
 */

/**
 * The WishlistItem class models a lightweight book reference
 * used specifically for wishlist functionality.
 */
public class WishlistItem {

    // ----------------------------------------------
    // Instance Variables
    // ----------------------------------------------

    @NotNull(message = "ISBN is a required field.")
    @NotEmpty(message = "ISBN is a required field.")
    private String isbn;

    @NotNull(message = "Title is a required field.")
    @NotEmpty(message = "Title is a required field.")
    private String title;

    // ----------------------------------------------
    // Constructors
    // ----------------------------------------------

    /**
     * Constructs an empty WishlistItem object.
     */
    public WishlistItem() {
    }

    /**
     * Constructs a WishlistItem with required values.
     *
     * @param isbn  The ISBN identifier for the book
     * @param title The title of the book
     */
    public WishlistItem(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
    }

    // ----------------------------------------------
    // Getter and Setter Methods
    // ----------------------------------------------

    /**
     * Retrieves the ISBN of the wishlist item.
     *
     * @return The book ISBN
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Sets the ISBN of the wishlist item.
     *
     * @param isbn The ISBN identifier to assign
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Retrieves the title of the wishlist item.
     *
     * @return The book title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the wishlist item.
     *
     * @param title The title to assign
     */
    public void setTitle(String title) {
        this.title = title;
    }

    // ----------------------------------------------
    // Overridden Methods
    // ----------------------------------------------

    /**
     * Returns a string representation of the WishlistItem object.
     *
     * @return A formatted string containing wishlist item details
     */
    @Override
    public String toString() {
        return "WishlistItem{" +
                "isbn=" + isbn +
                ", title=" + title +
                '}';
    }
}

