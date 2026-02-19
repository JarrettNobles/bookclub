package com.bookclub.service.impl;

import com.bookclub.model.BookOfTheMonth;
import com.bookclub.service.dao.BookOfTheMonthDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * Program Name: Book Club Application
 * File Name: MongoBookOfTheMonthDao.java
 * Author: Jarrett Nobles
 * Description:
 *   This class provides MongoDB-based data access operations for
 *   BookOfTheMonth objects within the Book Club application.
 */

/**
 * The MongoBookOfTheMonthDao class implements the BookOfTheMonthDao
 * interface using MongoDB for persistence.
 */
@Repository("bookOfTheMonthDao")
public class MongoBookOfTheMonthDao implements BookOfTheMonthDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public BookOfTheMonth add(BookOfTheMonth entity) {
        mongoTemplate.save(entity);
        return entity;
    }

    @Override
    public void update(BookOfTheMonth entity) {
    }

    @Override
    public BookOfTheMonth remove(BookOfTheMonth entity) {
        mongoTemplate.remove(entity);
        return entity;
    }

    @Override
    public boolean remove(BookOfTheMonth entity, String key) {
        mongoTemplate.remove(entity);
        return true;
    }

    @Override
    public List<BookOfTheMonth> list(String key) {
        int month = Integer.parseInt(key);

        System.out.println("Month: " + month);

        if (month == 999) {
            return mongoTemplate.findAll(BookOfTheMonth.class);
        }

        Query query = new Query();

        query.addCriteria(Criteria.where("month").is(month));

        return mongoTemplate.find(query, BookOfTheMonth.class);
    }

    @Override
    public BookOfTheMonth find(String key) {
        return mongoTemplate.findById(key, BookOfTheMonth.class);
    }
}
