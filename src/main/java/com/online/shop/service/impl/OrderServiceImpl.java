package com.online.shop.service.impl;

import com.online.shop.domain.*;
import com.online.shop.domain.enumeration.Status;
import com.online.shop.repository.OrderDetailsRepository;
import com.online.shop.repository.UserRepository;
import com.online.shop.security.SecurityUtils;
import com.online.shop.service.MailService;
import com.online.shop.service.OrderService;
import com.online.shop.repository.OrderRepository;
import com.online.shop.service.criteria.OrderDetailsCriteria;
import com.online.shop.service.criteria.ProductCriteria;
import com.online.shop.service.dto.CreateOrderDto;
import com.online.shop.service.dto.OrderDTO;
import com.online.shop.service.dto.ProductDTO;
import io.github.jhipster.service.QueryService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link Order}.
 */
@Service
@Transactional
public class OrderServiceImpl  extends QueryService<OrderDetails> implements OrderService {

    private final Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final MailService mailService;
    private final OrderDetailsRepository orderDetailsRepository;

    public OrderServiceImpl(
            OrderRepository orderRepository,
            UserRepository userRepository,
            ModelMapper modelMapper,
            MailService mailService,
            OrderDetailsRepository orderDetailsRepository
                            ) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.mailService = mailService;
        this.orderDetailsRepository = orderDetailsRepository;
    }


    @Override
    public Order createOrder(CreateOrderDto createOrder) {

        Double totalBill = createOrder.getProductDTO().stream().mapToDouble(order -> order.getPrice() * order.getQuantity()).sum();
        User user = getAuthUser();
        Order order = new Order();
        order.setStatus(Status.PENDING);
        order.setTotalPrice(totalBill);
        order.setUser(user);
        List<OrderItem> orderItems = new ArrayList<>();
        createOrder.getProductDTO().forEach(productDTO -> {
            OrderItem orderItem = new OrderItem();
            orderItem.setQuantity(productDTO.getQuantity());
            orderItem.setTotalPrice(orderItem.getProduct().getPrice() * orderItem.getQuantity());
            orderItem.setProduct(modelMapper.map(productDTO, Product.class));
            orderItems.add(orderItem);
        });
        order.setOrderItems(orderItems);
        order = orderRepository.save(order);
        mailService.sendOrderCreatedEmail(order, user);
        return order;

    }

    @Override
    @Transactional(readOnly = true)
    public Page<Order> findAll(Pageable pageable) {
        log.debug("Request to get all Orders");
        return orderRepository.findAll(pageable);
    }

    @Override
    public Page<OrderDetails> getAllOrdersByCriteria(Pageable pageable, OrderDetailsCriteria criteria) {
        final Specification<OrderDetails> specification = createSpecification(criteria);
        return orderDetailsRepository.findAll(specification, pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Order> findOne(Long id) {
        log.debug("Request to get Order : {}", id);
        return orderRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Order : {}", id);
        orderRepository.deleteById(id);
    }

    private User getAuthUser() {
        return SecurityUtils.getCurrentUserLogin().flatMap(userRepository::findOneWithAuthoritiesByLogin).orElse(null);
    }

    protected Specification<OrderDetails> createSpecification(OrderDetailsCriteria criteria) {
        Specification<OrderDetails> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getCategoryId() != null) {
                specification = specification.or(buildSpecification(criteria.getCategoryId(), OrderDetails_.categoryId));
            }
            if (criteria.getProductId() != null) {
                specification = specification.or(buildSpecification(criteria.getProductId(), OrderDetails_.productId));
            }
            if (criteria.getOrderId() != null) {
                specification = specification.or(buildSpecification(criteria.getOrderId(), OrderDetails_.orderId));
            }
            if (criteria.getSku() != null) {
                specification = specification.or(buildStringSpecification(criteria.getSku(), OrderDetails_.sku));
            }
        }
        return specification;
    }
}
