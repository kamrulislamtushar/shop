package com.online.shop.service.criteria;

import io.github.jhipster.service.Criteria;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;

import java.io.Serializable;
import java.util.Objects;

import static com.online.shop.domain.Product_.price;

public class ProductCriteria implements Serializable, Criteria{


    private static final long serialVersionUID = 1L;

    private StringFilter name;
    private StringFilter sku;
    private LongFilter productCategory;
    public ProductCriteria() {
    }

    public ProductCriteria(ProductCriteria other) {
        this.name = other.name == null ? null : other.name.copy();
        this.sku = other.sku == null ? null : other.sku.copy();
        this.productCategory = other.productCategory == null ? null : other.productCategory.copy();
    }

    @Override
    public ProductCriteria copy() {
        return new ProductCriteria(this);
    }


    public StringFilter getName() {
        return name;
    }

    public void setName(StringFilter name) {
        this.name = name;
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
        final ProductCriteria that = (ProductCriteria) o;
        return
                Objects.equals(name, that.name) &&
                        Objects.equals(sku, that.sku) &&
                        Objects.equals(productCategory, that.productCategory)
                ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                name,
                sku,
                productCategory
        );
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ProductCriteria{" +
                (name != null ? "name=" + name + ", " : "") +
                (sku != null ? "sku=" + sku + ", " : "") +
                (productCategory != null ? "productCategory=" + productCategory + ", " : "") +
                "}";
    }
}
