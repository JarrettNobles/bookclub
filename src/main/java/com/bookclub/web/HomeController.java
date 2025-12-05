package com.bookclub.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HomeController {

    //show home page
    @RequestMapping(method = RequestMethod.GET)
    public String showHome(Model model){
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

}//end class
