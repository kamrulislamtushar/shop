package com.online.shop.service.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class CreateOrderDto {

    private List<CreateOrderProduct> productDTO;
    public List<CreateOrderProduct> getProductDTO() {
        return productDTO;
    }

    public void setProductDTO(List<CreateOrderProduct> productDTO) {
        this.productDTO = productDTO;
    }

    @Override
    public String toString() {
        return "CreateOrderDto{" +
                "productDTO=" + productDTO +
                '}';
    }
}
