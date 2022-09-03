package com.online.shop.service;

import com.online.shop.domain.ProductCategory;
import com.online.shop.service.dto.ProductCategoryDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link com.online.shop.domain.ProductCategory}.
 */
public interface ProductCategoryService {

    /**
     * Save a productCategory.
     *
     * @param productCategory the entity to save.
     * @return the persisted entity.
     */
    ProductCategory save(ProductCategory productCategory);

    /**
     * Get all the productCategories.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<ProductCategory> findAll(Pageable pageable);


    /**
     * Get the "id" productCategory.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<ProductCategory> findOne(Long id);

    /**
     * Delete the "id" productCategory.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
