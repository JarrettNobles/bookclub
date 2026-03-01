package com.bookclub.web;

import com.bookclub.service.dao.WishlistDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/*
 * Program Name: Book Club Application
 * File Name: WishlistControllerTest.java
 * Author: Jarrett Nobles
 * Description:
 *   Web unit test for the WishlistController class.
 *   Verifies that the wishlist list page and new item
 *   form return the correct HTTP status and view names.
 */
@WebMvcTest(WishlistController.class)
class WishlistControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WishlistDao wishlistDao;

    @Test
    @WithMockUser
    void testShowWishlistReturnsListView() throws Exception {
        mockMvc.perform(get("/wishlist"))
                .andExpect(status().isOk())
                .andExpect(view().name("wishlist/list"));
    }

    @Test
    @WithMockUser
    void testWishlistFormReturnsNewView() throws Exception {
        mockMvc.perform(get("/wishlist/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("wishlist/new"))
                .andExpect(model().attributeExists("wishlistItem"));
    }
}
