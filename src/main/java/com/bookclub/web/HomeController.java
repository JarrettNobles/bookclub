package com.bookclub.web;
import com.bookclub.model.Book;
import com.bookclub.model.BookOfTheMonth;
import com.bookclub.service.dao.BookOfTheMonthDao;
import com.bookclub.service.impl.MongoBookOfTheMonthDao;
import com.bookclub.service.impl.RestBookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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

    private BookOfTheMonthDao bookOfTheMonthDao = new MongoBookOfTheMonthDao();

    @Autowired
    public void setBookOfTheMonthDao(BookOfTheMonthDao bookOfTheMonthDao) {
        this.bookOfTheMonthDao = bookOfTheMonthDao;
    }

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

        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int calMonth = cal.get(Calendar.MONTH) + 1;

        RestBookDao bookDao = new RestBookDao();
        List<BookOfTheMonth> monthlyBooks = bookOfTheMonthDao.list(Integer.toString(calMonth));

        List<Book> books = new ArrayList<>();

        if (!monthlyBooks.isEmpty()) {
            StringBuilder isbnBuilder = new StringBuilder();
            isbnBuilder.append("ISBN:");

            for (BookOfTheMonth monthlyBook : monthlyBooks) {
                isbnBuilder.append(monthlyBook.getIsbn()).append(",");
            }

            String isbnString = isbnBuilder.toString().substring(0, isbnBuilder.toString().length() - 1);

            books = bookDao.list(isbnString);
        }

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

        RestBookDao bookDao = new RestBookDao();
        Book book = bookDao.find(id);

        model.addAttribute("book", book);

        return "monthly-books/view";
    }
}
