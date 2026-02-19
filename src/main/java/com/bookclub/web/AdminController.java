package com.bookclub.web;

import com.bookclub.model.BookOfTheMonth;
import com.bookclub.service.dao.BookOfTheMonthDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/*
 * Program Name: Book Club Application
 * File Name: AdminController.java
 * Author: Jarrett Nobles
 * Description:
 *   This controller manages all admin-related web
 *   interactions, including viewing monthly book selections,
 *   displaying the book of the month form, and handling
 *   form submissions with validation.
 */

/**
 * The AdminController class handles HTTP requests
 * related to monthly book functionality within the
 * Book Club application.
 */
@Controller
@RequestMapping("/monthly-books")
public class AdminController {

    private BookOfTheMonthDao bookOfTheMonthDao;

    @Autowired
    private void setBookOfTheMonthDao(BookOfTheMonthDao bookOfTheMonthDao) {
        this.bookOfTheMonthDao = bookOfTheMonthDao;
    }

    // ----------------------------------------------
    // Request Mapping Methods
    // ----------------------------------------------

    /**
     * Displays the full list of books of the month.
     *
     * @param model The model used to pass data to the view
     * @return The monthly books list view
     */
    @RequestMapping(method = RequestMethod.GET)
    public String showBookOfTheMonth(Model model) {
        model.addAttribute("books", bookOfTheMonthDao.list("999"));
        return "monthly-books/list";
    }

    /**
     * Displays the form for adding a new book of the month.
     *
     * @param model The model used to pass data to the view
     * @return The book of the month form view
     */
    @RequestMapping(path = "/new", method = RequestMethod.GET)
    public String bookOfTheMonthForm(Model model) {
        model.addAttribute("bookOfTheMonth", new BookOfTheMonth());
        model.addAttribute("months", getMonths());
        return "monthly-books/new";
    }

    /**
     * Handles submission of a new book of the month form.
     *
     * @param bookOfTheMonth The book of the month submitted by the user
     * @param bindingResult  Contains validation results
     * @return A redirect to the monthly books page if successful,
     *         or the form view if validation fails
     */
    @RequestMapping(method = RequestMethod.POST)
    public String addBookOfTheMonth(
            @Valid BookOfTheMonth bookOfTheMonth,
            BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("months", getMonths());
            return "monthly-books/new";
        }

        bookOfTheMonthDao.add(bookOfTheMonth);

        return "redirect:/monthly-books";
    }

    /**
     * Removes a book of the month by its ID.
     *
     * @param id The ID of the book of the month to remove
     * @return A redirect to the monthly books page
     */
    @RequestMapping(method = RequestMethod.GET, path = "/remove/{id}")
    public String removeBookOfTheMonth(@PathVariable String id) {
        BookOfTheMonth bookOfTheMonth = bookOfTheMonthDao.find(id);
        bookOfTheMonthDao.remove(bookOfTheMonth);
        return "redirect:/monthly-books";
    }

    /**
     * Returns a HashMap of month numbers and their names.
     *
     * @return A HashMap mapping month numbers to month names
     */
    private Map<Integer, String> getMonths() {
        HashMap<Integer, String> months = new HashMap<>();
        months.put(1, "January");
        months.put(2, "February");
        months.put(3, "March");
        months.put(4, "April");
        months.put(5, "May");
        months.put(6, "June");
        months.put(7, "July");
        months.put(8, "August");
        months.put(9, "September");
        months.put(10, "October");
        months.put(11, "November");
        months.put(12, "December");
        return months;
    }
}
