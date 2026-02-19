package com.bookclub.model;

import javax.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;

/*
 * Program Name: Book Club Application
 * File Name: BookOfTheMonth.java
 * Author: Jarrett Nobles
 * Description:
 *   This class represents a book selected as the book of the month
 *   within the Book Club application. It contains the month and ISBN
 *   needed to identify and display monthly book selections.
 */

/**
 * The BookOfTheMonth class models a monthly book selection
 * used for the book of the month functionality.
 */
public class BookOfTheMonth {

    // ----------------------------------------------
    // Instance Variables
    // ----------------------------------------------

    @Id
    private String id;

    private Integer month;

    @NotEmpty(message = "ISBN is a required field.")
    private String isbn;

    // ----------------------------------------------
    // Constructors
    // ----------------------------------------------

    /**
     * Constructs an empty BookOfTheMonth object.
     */
    public BookOfTheMonth() {
    }

    /**
     * Constructs a BookOfTheMonth with required values.
     *
     * @param month The month number for the selection
     * @param isbn  The ISBN identifier for the book
     */
    public BookOfTheMonth(Integer month, String isbn) {
        this.month = month;
        this.isbn = isbn;
    }

    // ----------------------------------------------
    // Getter and Setter Methods
    // ----------------------------------------------

    /**
     * Retrieves the id of the book of the month.
     *
     * @return The book of the month id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the id of the book of the month.
     *
     * @param id The id to assign
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Retrieves the month of the selection.
     *
     * @return The month number
     */
    public Integer getMonth() {
        return month;
    }

    /**
     * Sets the month of the selection.
     *
     * @param month The month number to assign
     */
    public void setMonth(Integer month) {
        this.month = month;
    }

    /**
     * Retrieves the ISBN of the book of the month.
     *
     * @return The book ISBN
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Sets the ISBN of the book of the month.
     *
     * @param isbn The ISBN identifier to assign
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Returns a string representation of the BookOfTheMonth object.
     *
     * @return A formatted string containing book of the month details
     */
    @Override
    public String toString() {
        return "BookOfTheMonth{" +
                "id=" + id +
                ", month=" + month +
                ", isbn=" + isbn +
                '}';
    }
}
