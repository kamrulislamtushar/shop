package com.online.shop.service.dto;

import com.online.shop.domain.enumeration.Status;
import com.online.shop.service.mapper.UserMapper;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * A DTO for the {@link com.online.shop.domain.Order} entity.
 */
@Data
@Setter
@Getter
public class OrderDTO implements Serializable {
    
    private Long id;
    private Double totalPrice;
    private Status status;
    private List<OrderItemDTO> orderItems;
    private UserDTO userDTO;

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

    @Override
    public String toString() {
        return "OrderDTO{" +
                "id=" + id +
                ", totalPrice=" + totalPrice +
                ", status=" + status +
                ", orderItems=" + orderItems +
                ", userDTO=" + userDTO +
                '}';
    }
}
