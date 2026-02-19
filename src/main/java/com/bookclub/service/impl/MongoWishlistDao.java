package com.bookclub.service.impl;

import com.bookclub.model.WishlistItem;
import com.bookclub.service.dao.WishlistDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("wishlistDao")
public class MongoWishlistDao implements WishlistDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public WishlistItem add(WishlistItem entity) {
        mongoTemplate.save(entity);
        return entity;
    }

    @Override
    public List<WishlistItem> list(String username) {
        Query query = new Query(Criteria.where("username").is(username));
        return mongoTemplate.find(query, WishlistItem.class);
    }

    @Override
    public void update(WishlistItem entity){
        WishlistItem wishlistItem = mongoTemplate.findById(entity.getId(), WishlistItem.class);
        if(wishlistItem != null){
            wishlistItem.setTitle(entity.getTitle());
            wishlistItem.setIsbn(entity.getIsbn());
            wishlistItem.setUsername(entity.getUsername());
            mongoTemplate.save(wishlistItem);
        }
    }

    @Override
    public boolean remove(String key){
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(key));
        mongoTemplate.remove(query, WishlistItem.class);
        return true;
    }

    @Override
    public boolean remove(WishlistItem entity, String key) {
        mongoTemplate.remove(entity);
        return true;
    }


    @Override
    public WishlistItem find(String key) {
        return mongoTemplate.findById(key, WishlistItem.class);
    }
}
