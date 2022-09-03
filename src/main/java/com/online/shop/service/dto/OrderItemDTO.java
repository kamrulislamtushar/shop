package com.online.shop.service.dto;

import java.io.Serializable;

/**
 * A DTO for the {@link com.online.shop.domain.OrderItem} entity.
 */
public class OrderItemDTO implements Serializable {
    
    private Long id;

    private Integer quantity;

    private Double totalPrice;

    private OrderDTO orderDTO;

    public OrderDTO getOrderDTO() {
        return orderDTO;
    }

    public void setOrderDTO(OrderDTO orderDTO) {
        this.orderDTO = orderDTO;
    }



    
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof OrderItemDTO)) {
            return false;
        }

        return id != null && id.equals(((OrderItemDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "OrderItemDTO{" +
            "id=" + getId() +
            ", quantity=" + getQuantity() +
            ", totalPrice=" + getTotalPrice() +
            "}";
    }
}
