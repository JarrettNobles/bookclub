package com.bookclub.web;
import com.bookclub.model.Book;
import com.bookclub.service.impl.MemBookDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;

//home controller
@Controller
@RequestMapping("/")
public class HomeController {

    //show home page
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showHome(Model model) {

        MemBookDao booksDao = new MemBookDao();
        List<Book> books = booksDao.list();

        model.addAttribute("books", books);

        return "index";
    }

    //show about
    @RequestMapping(method = RequestMethod.GET, path = "/about")
    public String showAbout(Model model){
        return "about";
    }

    //show contact
    @RequestMapping(method = RequestMethod.GET, path = "/contact")
    public String showContact(Model model){
        return "contact";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public String getMonthlyBook(@PathVariable("id") String id, Model model) {

        MemBookDao bookDao = new MemBookDao();
        Book book = bookDao.find(id);

        model.addAttribute("book", book);

        return "monthly-books/view";
    }

}//end class
