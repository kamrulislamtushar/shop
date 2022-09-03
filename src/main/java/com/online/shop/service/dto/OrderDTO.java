package com.online.shop.service.dto;

import com.online.shop.domain.enumeration.Status;
import com.online.shop.service.mapper.UserMapper;

import java.io.Serializable;
import java.util.List;

/**
 * A DTO for the {@link com.online.shop.domain.Order} entity.
 */
public class OrderDTO implements Serializable {
    
    private Long id;

    private Double totalPrice;

    private Status status;

    private List<OrderItemDTO> orderItems;

    private UserDTO userDTO;

    private UserMapper userMapper;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<OrderItemDTO> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemDTO> orderItems) {
        this.orderItems = orderItems;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(o instanceof OrderDTO)) {
            return false;
        }

        return id != null && id.equals(((OrderDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "OrderDTO{" +
            "id=" + getId() +
            ", totalPrice=" + getTotalPrice() +
            "}";
    }
}
