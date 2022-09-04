package com.online.shop.service.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;

@Data
@Setter
@Getter
public class CreateOrderProduct extends ProductDTO {
    @Max(value = 4)
    private Integer quantity;

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CreateOrderProduct{" +
                "quantity=" + quantity +
                '}';
    }
}
