package com.bookclub.service.impl;

import com.bookclub.model.Book;
import com.bookclub.service.dao.BookDao;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

public class RestBookDao implements BookDao {

    public RestBookDao() {
    }

    public Object getBooksDoc(String isbnString) {
        String url = "https://openlibrary.org/api/books";

        RestTemplate rest = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
                .queryParam("bibkeys", isbnString)
                .queryParam("format", "json")
                .queryParam("jscmd", "details");

        HttpEntity<?> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = rest.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                entity,
                String.class
        );

        String jsonBooklist = response.getBody();

        return Configuration.defaultConfiguration().jsonProvider().parse(jsonBooklist);
    }

    @Override
    public List<Book> list() {
        List<Book> books = new ArrayList<>();

        String[] isbns = {"ISBN:9780593099322", "ISBN:9780261102361", "ISBN:9780590353427"};
        String isbnString = String.join(",", isbns);

        Object doc = getBooksDoc(isbnString);

        for (String isbn : isbns) {
            String titlePath = "$." + isbn + ".details.title";
            String descPath = "$." + isbn + ".details.description";
            String infoUrlPath = "$." + isbn + ".info_url";
            String numOfPagesPath = "$." + isbn + ".details.number_of_pages";

            String title = JsonPath.read(doc, titlePath);
            String infoUrl = JsonPath.read(doc, infoUrlPath);

            String description;
            try {
                description = JsonPath.read(doc, descPath);
            } catch (Exception e) {
                description = "N/A";
            }

            int numOfPages;
            try {
                numOfPages = JsonPath.read(doc, numOfPagesPath);
            } catch (Exception e) {
                numOfPages = 0;
            }

            String isbnValue = isbn.replace("ISBN:", "");

            Book book = new Book(isbnValue, title, description, infoUrl, numOfPages);
            books.add(book);
        }

        return books;
    }

    @Override
    public Book find(String key) {
        String isbnKey = "ISBN:" + key;

        Object doc = getBooksDoc(isbnKey);

        String titlePath = "$." + isbnKey + ".details.title";
        String descPath = "$." + isbnKey + ".details.description";
        String infoUrlPath = "$." + isbnKey + ".info_url";
        String numOfPagesPath = "$." + isbnKey + ".details.number_of_pages";

        String title = JsonPath.read(doc, titlePath);
        String infoUrl = JsonPath.read(doc, infoUrlPath);

        String description;
        try {
            description = JsonPath.read(doc, descPath);
        } catch (Exception e) {
            description = "N/A";
        }

        int numOfPages;
        try {
            numOfPages = JsonPath.read(doc, numOfPagesPath);
        } catch (Exception e) {
            numOfPages = 0;
        }

        return new Book(key, title, description, infoUrl, numOfPages);
    }
}
