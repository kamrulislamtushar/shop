package com.online.shop.repository;

import com.online.shop.domain.OrderDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long>, JpaSpecificationExecutor<OrderDetails> {
    @Query(value = "SELECT order from OrderDetails as order where order.orderId=:orderId" +
            " and (:productId is null or order.productId=:productId) " +
            " and (:categoryId is null or order.categoryId=:categoryId) " +
            " and (:sku is null or order.sku like %:sku%) order by ID DESC ")
    Page<OrderDetails> findAllByFilter(Long orderId, Long categoryId, Long productId, String sku, Pageable pageable);
}
