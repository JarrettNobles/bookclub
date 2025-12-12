package com.bookclub.web;
import com.bookclub.model.Book;
import com.bookclub.service.impl.MemBookDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;

/*
 * Program Name: Book Club Application
 * File Name: HomeController.java
 * Author: Jarrett Nobles
 * Description:
 *   This controller handles all primary navigation routes
 *   for the Book Club application, including the home page,
 *   informational pages, and monthly book detail views.
 */

/**
 * The HomeController class manages web requests related to
 * the application's main pages and book listings.
 */
@Controller
@RequestMapping("/")
public class HomeController {

    // ----------------------------------------------
    // Request Mapping Methods
    // ----------------------------------------------

    /**
     * Displays the home page and populates the model
     * with a list of available books.
     *
     * @param model The model used to pass data to the view
     * @return The name of the home page view
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showHome(Model model) {

        MemBookDao booksDao = new MemBookDao();
        List<Book> books = booksDao.list();

        model.addAttribute("books", books);

        return "index";
    }

    /**
     * Displays the About page.
     *
     * @param model The model used to pass data to the view
     * @return The name of the about page view
     */
    @RequestMapping(method = RequestMethod.GET, path = "/about")
    public String showAbout(Model model) {
        return "about";
    }

    /**
     * Displays the Contact page.
     *
     * @param model The model used to pass data to the view
     * @return The name of the contact page view
     */
    @RequestMapping(method = RequestMethod.GET, path = "/contact")
    public String showContact(Model model) {
        return "contact";
    }

    /**
     * Displays details for the selected monthly book
     * based on the provided ISBN.
     *
     * @param id    The ISBN identifier of the selected book
     * @param model The model used to pass data to the view
     * @return The name of the monthly book detail view
     */
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public String getMonthlyBook(@PathVariable("id") String id, Model model) {

        MemBookDao bookDao = new MemBookDao();
        Book book = bookDao.find(id);

        model.addAttribute("book", book);

        return "monthly-books/view";
    }
}
