package com.online.shop.service.impl;

import com.online.shop.domain.Product_;
import com.online.shop.domain.User;
import com.online.shop.domain.User_;
import com.online.shop.service.ProductService;
import com.online.shop.domain.Product;
import com.online.shop.repository.ProductRepository;
import com.online.shop.service.criteria.ProductCriteria;
import com.online.shop.service.criteria.UserCriteria;
import com.online.shop.service.dto.ProductDTO;
import io.github.jhipster.service.QueryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Product}.
 */
@Service
@Transactional
public class ProductServiceImpl extends QueryService<Product> implements ProductService  {

    private final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product save(Product product) {
        log.debug("Request to save Product : {}", product);
        product = productRepository.save(product);
        return product;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Product> findAll(Pageable pageable, ProductCriteria criteria) {
        log.debug("Request to get all Products");
        final Specification<Product> specification = createSpecification(criteria);
        return productRepository.findAll(specification, pageable);
    }


    @Override
    @Transactional(readOnly = true)
    public Page<Product> findAllBYCategory(Pageable pageable, Long categoryId) {
        log.debug("Request to get all Products");
        return productRepository.findAllByCategory_id(pageable, categoryId);
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<Product> findOne(Long id) {
        log.debug("Request to get Product : {}", id);
        return productRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Product : {}", id);
        productRepository.deleteById(id);
    }


    protected Specification<Product> createSpecification(ProductCriteria criteria) {
        Specification<Product> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getName() != null) {
                specification = specification.or(buildStringSpecification(criteria.getName(), Product_.sku));
            }
            if (criteria.getSku() != null) {
                specification = specification.or(buildStringSpecification(criteria.getSku(), Product_.sku));
            }
        }
        return specification;
    }
}
