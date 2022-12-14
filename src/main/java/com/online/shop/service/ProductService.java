package com.online.shop.service;

import com.online.shop.domain.Product;
import com.online.shop.service.criteria.ProductCriteria;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link com.online.shop.domain.Product}.
 */
public interface ProductService {

    /**
     * Save a product.
     *
     * @param product the entity to save.
     * @return the persisted entity.
     */
    Product save(Product product);

    /**
     * Get all the products.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<Product> findAll(Pageable pageable, ProductCriteria criteria);


    /**
     * Get all the products by category.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<Product> findAllBYCategory(Pageable pageable, Long categoryId);


    /**
     * Get the "id" product.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Product> findOne(Long id);

    /**
     * Delete the "id" product.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
