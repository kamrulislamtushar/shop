package com.online.shop.service.criteria;

import io.github.jhipster.service.Criteria;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;

import java.io.Serializable;
import java.util.Objects;

public class OrderDetailsCriteria implements Serializable, Criteria{


    private static final long serialVersionUID = 1L;


    private LongFilter categoryId;
    private LongFilter orderId;
    private LongFilter productId;
    private StringFilter sku;
    public OrderDetailsCriteria() {
    }

    public OrderDetailsCriteria(OrderDetailsCriteria other) {
        this.categoryId = other.categoryId == null ? null : other.categoryId.copy();
        this.sku = other.sku == null ? null : other.sku.copy();
        this.orderId = other.orderId == null ? null : other.orderId.copy();
        this.productId = other.productId == null ? null : other.productId.copy();
    }

    @Override
    public OrderDetailsCriteria copy() {
        return new OrderDetailsCriteria(this);
    }


    public LongFilter getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(LongFilter categoryId) {
        this.categoryId = categoryId;
    }

    public LongFilter getOrderId() {
        return orderId;
    }

    public void setOrderId(LongFilter orderId) {
        this.orderId = orderId;
    }

    public LongFilter getProductId() {
        return productId;
    }

    public void setProductId(LongFilter productId) {
        this.productId = productId;
    }

    public StringFilter getSku() {
        return sku;
    }

    public void setSku(StringFilter sku) {
        this.sku = sku;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final OrderDetailsCriteria that = (OrderDetailsCriteria) o;
        return
                Objects.equals(categoryId, that.categoryId) &&
                        Objects.equals(orderId, that.orderId) &&
                        Objects.equals(productId, that.productId) &&
                        Objects.equals(sku, that.sku)
                ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                categoryId,
                sku,
                productId,
                orderId
        );
    }


}
