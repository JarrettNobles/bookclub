package com.bookclub.service;

import java.util.List;

/*
 * Program Name: Book Club Application
 * File Name: GenericDao.java
 * Author: Jarrett Nobles
 * Description:
 *   This interface defines generic data access operations
 *   for managing application entities. It provides a
 *   reusable abstraction for basic retrieval functionality
 *   across different data models.
 */

/**
 * The GenericDao interface defines common data access
 * operations for application entities.
 *
 * @param <E> The entity type managed by the DAO
 * @param <K> The type of the entity's primary key
 */
public interface GenericDao<E, K> {

    /**
     * Retrieves all entities managed by the DAO.
     *
     * @return A list of all entities
     */
    List<E> list(K key);

    /**
     * Retrieves an entity by its primary key.
     *
     * @param key The unique identifier for the entity
     * @return The matching entity if found; otherwise, null
     */
    E find(K key);
}
