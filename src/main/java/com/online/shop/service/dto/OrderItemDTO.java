package com.online.shop.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.online.shop.domain.Order;
import com.online.shop.domain.Product;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.online.shop.domain.OrderItem} entity.
 */
@Data
@Setter
@Getter
public class OrderItemDTO implements Serializable {

    private Long id;
    private Integer quantity;
    private Double totalPrice;
    private OrderDTO orderDTO;
    private ProductDTO productDTO;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public OrderDTO getOrderDTO() {
        return orderDTO;
    }

    public void setOrderDTO(OrderDTO orderDTO) {
        this.orderDTO = orderDTO;
    }

    public ProductDTO getProductDTO() {
        return productDTO;
    }

    public void setProductDTO(ProductDTO productDTO) {
        this.productDTO = productDTO;
    }

    @Override
    public String toString() {
        return "OrderItemDTO{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                ", orderDTO=" + orderDTO +
                ", productDTO=" + productDTO +
                '}';
    }
}
