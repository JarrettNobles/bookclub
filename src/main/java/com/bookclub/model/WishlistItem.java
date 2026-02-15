package com.bookclub.model;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;

/*
 * Program Name: Book Club Application
 * File Name: WishlistItem.java
 * Author: Jarrett Nobles
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

    @Id
    private String id;

    @NotNull(message = "ISBN is a required field.")
    @NotEmpty(message = "ISBN is a required field.")
    private String isbn;

    @NotNull(message = "Title is a required field.")
    @NotEmpty(message = "Title is a required field.")
    private String title;

    private String username;

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
     * @param isbn     The ISBN identifier for the book
     * @param title    The title of the book
     * @param username The username of the wishlist owner
     */
    public WishlistItem(String isbn, String title, String username) {
        this.isbn = isbn;
        this.title = title;
        this.username = username;
    }

    // ----------------------------------------------
    // Getter and Setter Methods
    // ----------------------------------------------

    /**
     * Retrieves the id of the wishlist item.
     *
     * @return The wishlist item id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the id of the wishlist item.
     *
     * @param id The id to assign
     */
    public void setId(String id) {
        this.id = id;
    }

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

    /**
     * Retrieves the username of the wishlist owner.
     *
     * @return The username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username of the wishlist owner.
     *
     * @param username The username to assign
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Returns a string representation of the WishlistItem object.
     *
     * @return A formatted string containing wishlist item details
     */
    @Override
    public String toString() {
        return "WishlistItem{" +
                "id=" + id +
                ", isbn=" + isbn +
                ", title=" + title +
                ", username=" + username +
                '}';
    }
}
