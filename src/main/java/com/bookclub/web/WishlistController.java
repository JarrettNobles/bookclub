package com.bookclub.web;
import com.bookclub.model.WishlistItem;
import com.bookclub.service.dao.WishlistDao;
import com.bookclub.service.impl.MemWishlistDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/wishlist")
public class WishlistController {

    // 1) Show the full wishlist
    @RequestMapping(method = RequestMethod.GET)
    public String showWishlist(Model model) {
        WishlistDao dao = new MemWishlistDao();
        List<WishlistItem> wishlist = dao.list();
        model.addAttribute("wishlist", wishlist);
        return "wishlist/list";   // templates/wishlist/list.html
    }

    // 2) Show the "New Wishlist Item" form
    @RequestMapping(path = "/new", method = RequestMethod.GET)
    public String wishlistForm(Model model) {
        model.addAttribute("wishlistItem", new WishlistItem());
        return "wishlist/new";    // templates/wishlist/new.html
    }

    // 3) Handle form submission
    @RequestMapping(method = RequestMethod.POST)
    public String addWishlistItem(
            @Valid WishlistItem wishlistItem,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            // If validation fails, show the form again with errors
            return "wishlist/new";
        }

        // In a real app we'd save to DAO here.
        // Redirect back to the wishlist list page.
        return "redirect:/wishlist";
    }
}
