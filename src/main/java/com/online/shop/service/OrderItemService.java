package com.online.shop.service;

import com.online.shop.domain.OrderItem;
import com.online.shop.service.dto.OrderItemDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link com.online.shop.domain.OrderItem}.
 */
public interface OrderItemService {

    /**
     * Save a orderItem.
     *
     * @param orderItem the entity to save.
     * @return the persisted entity.
     */
    OrderItem save(OrderItem orderItemD);

    /**
     * Get all the orderItems.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<OrderItem> findAll(Pageable pageable);


    /**
     * Get the "id" orderItem.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<OrderItem> findOne(Long id);

    /**
     * Delete the "id" orderItem.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
