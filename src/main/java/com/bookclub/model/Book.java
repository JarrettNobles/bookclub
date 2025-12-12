package com.bookclub.model;
import java.util.List;

/*
 * Program Name: Book Club Application
 * File Name: Book.java
 * Author: Jarrett Nobles
 * Description:
 *   This class represents a Book entity within the Book Club application.
 *   It is used to store and manage book-related information such as ISBN,
 *   title, description, number of pages, and authors.
 */

/**
 * The Book class models a book object used by the application
 * to represent books available in the system.
 */
public class Book {

    // ----------------------------------------------
    // Instance Variables
    // ----------------------------------------------
    private String isbn;
    private String title;
    private String description;
    private int numOfPages;
    private List<String> authors;

    // ----------------------------------------------
    // Constructors
    // ----------------------------------------------

    /**
     * Constructs an empty Book object.
     */
    public Book() {
    }

    /**
     * Constructs a Book object with all required attributes.
     *
     * @param isbn        The ISBN identifier for the book
     * @param title       The title of the book
     * @param description A brief description of the book
     * @param numOfPages  The total number of pages in the book
     * @param authors     A list of authors for the book
     */
    public Book(String isbn, String title, String description,
                int numOfPages, List<String> authors) {
        this.isbn = isbn;
        this.title = title;
        this.description = description;
        this.numOfPages = numOfPages;
        this.authors = authors;
    }

    // ----------------------------------------------
    // Getter and Setter Methods
    // ----------------------------------------------

    /**
     * Retrieves the ISBN of the book.
     *
     * @return The book ISBN
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Sets the ISBN of the book.
     *
     * @param isbn The ISBN identifier to assign
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Retrieves the title of the book.
     *
     * @return The book title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the book.
     *
     * @param title The title to assign
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Retrieves the description of the book.
     *
     * @return The book description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the book.
     *
     * @param description The description to assign
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Retrieves the number of pages in the book.
     *
     * @return The total number of pages
     */
    public int getNumOfPages() {
        return numOfPages;
    }

    /**
     * Sets the number of pages in the book.
     *
     * @param numOfPages The total page count
     */
    public void setNumOfPages(int numOfPages) {
        this.numOfPages = numOfPages;
    }

    /**
     * Retrieves the list of authors for the book.
     *
     * @return A list of author names
     */
    public List<String> getAuthors() {
        return authors;
    }

    /**
     * Sets the list of authors for the book.
     *
     * @param authors A list of author names to assign
     */
    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    // ----------------------------------------------
    // Overridden Methods
    // ----------------------------------------------

    /**
     * Returns a string representation of the Book object.
     *
     * @return A formatted string containing book details
     */
    @Override
    public String toString() {
        return "Book{" +
                "isbn=" + isbn +
                ", title=" + title +
                ", description=" + description +
                ", numOfPages=" + numOfPages +
                ", authors=" + authors +
                '}';
    }
}
