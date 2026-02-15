package com.bookclub.web;
import com.bookclub.model.WishlistItem;
import com.bookclub.service.dao.WishlistDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.validation.Valid;
import java.util.List;

/*
 * Program Name: Book Club Application
 * File Name: WishlistController.java
 * Author: Jarrett Nobles
 * Description:
 *   This controller manages all wishlist-related web
 *   interactions, including viewing wishlist items,
 *   displaying the wishlist form, and handling form
 *   submissions with validation.
 */

/**
 * The WishlistController class handles HTTP requests
 * related to wishlist functionality within the
 * Book Club application.
 */
@Controller
@RequestMapping("/wishlist")
public class WishlistController {

    private WishlistDao wishlistDao;

    @Autowired
    private void setWishlistDao(WishlistDao wishlistDao) {
        this.wishlistDao = wishlistDao;
    }

    // ----------------------------------------------
    // Request Mapping Methods
    // ----------------------------------------------

    /**
     * Displays the full wishlist.
     *
     * @param model The model used to pass data to the view
     * @return The wishlist list view
     */
    /**@RequestMapping(method = RequestMethod.GET)
    public String showWishlist(Model model) {

        List<WishlistItem> wishlist = wishlistDao.list();

        model.addAttribute("wishlist", wishlist);

        return "wishlist/list";
    }*/
    @RequestMapping(method = RequestMethod.GET)
    public String showWishlist() {

        return "wishlist/list";
    }

    /**
     * Displays the form for adding a new wishlist item.
     *
     * @param model The model used to pass data to the view
     * @return The wishlist item form view
     */
    @RequestMapping(path = "/new", method = RequestMethod.GET)
    public String wishlistForm(Model model) {

        model.addAttribute("wishlistItem", new WishlistItem());

        return "wishlist/new";
    }

    /**
     * Handles submission of a new wishlist item form.
     * Validation errors will return the user to the
     * form view with error messages displayed.
     *
     * @param wishlistItem  The wishlist item submitted by the user
     * @param bindingResult Contains validation results
     * @return A redirect to the wishlist page if successful,
     *         or the form view if validation fails
     */
    @RequestMapping(method = RequestMethod.POST)
    public String addWishlistItem(
            @Valid WishlistItem wishlistItem,
            BindingResult bindingResult,
            Authentication authentication) {

        // Set the username from the authenticated user before validation
        wishlistItem.setUsername(authentication.getName());

        if (bindingResult.hasErrors()) {
            // Redisplay the form if validation errors are present
            return "wishlist/new";
        }

        // In a production application, the wishlist item
        // would be persisted using the DAO layer here.

        wishlistDao.add(wishlistItem); // add the record to MongoDB

        return "redirect:/wishlist";
    }

    /**
     * Displays a single wishlist item.
     *
     * @param id    The ID of the wishlist item to view
     * @param model The model used to pass data to the view
     * @return The wishlist item view
     */
    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public String showWishlistItem(@PathVariable String id, Model model) {
        WishlistItem wishlistItem = wishlistDao.find(id);
        model.addAttribute("wishlistItem", wishlistItem);
        return "wishlist/view";
    }

    /**
     * Handles update of an existing wishlist item.
     *
     * @param wishlistItem  The wishlist item to update
     * @param bindingResult Contains validation results
     * @param authentication The authentication object containing user details
     * @return A redirect to the wishlist page if successful,
     *         or the view form if validation fails
     */
    @RequestMapping(method = RequestMethod.POST, path = "/update")
    public String updateWishlistItem(
            @Valid WishlistItem wishlistItem,
            BindingResult bindingResult,
            Authentication authentication,
            Model model) {

        wishlistItem.setUsername(authentication.getName());

        if (bindingResult.hasErrors()) {
            model.addAttribute("wishlistItem", wishlistItem);
            return "wishlist/view";
        }

        wishlistDao.update(wishlistItem);

        return "redirect:/wishlist";
    }

    /**
     * Removes a wishlist item by its ID.
     *
     * @param id The ID of the wishlist item to remove
     * @return A redirect to the wishlist page
     */
    @RequestMapping(method = RequestMethod.GET, path = "/delete/{id}")
    public String removeWishlistItem(@PathVariable String id) {
        wishlistDao.remove(id);
        return "redirect:/wishlist";
    }

}
