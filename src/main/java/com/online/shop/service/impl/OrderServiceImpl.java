package com.online.shop.service.impl;

import com.online.shop.domain.OrderItem;
import com.online.shop.domain.Product;
import com.online.shop.domain.User;
import com.online.shop.domain.enumeration.Status;
import com.online.shop.repository.UserRepository;
import com.online.shop.security.SecurityUtils;
import com.online.shop.service.OrderService;
import com.online.shop.domain.Order;
import com.online.shop.repository.OrderRepository;
import com.online.shop.service.dto.CreateOrderDto;
import com.online.shop.service.dto.OrderDTO;
import com.online.shop.service.dto.ProductDTO;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
public class OrderServiceImpl implements OrderService {

    private final Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public OrderServiceImpl(
            OrderRepository orderRepository,
            UserRepository userRepository,
            ModelMapper modelMapper
                            ) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Order save(Order order) {
        log.debug("Request to save Order : {}", order);
        order = orderRepository.save(order);
        return order;
    }


    @Override
    public Order createOrder(CreateOrderDto createOrder) {

        Double totalBill = createOrder.getProductDTO().stream().mapToDouble(order -> order.getPrice() * order.getQuantity()).sum();
        Order order = new Order();
        order.setStatus(Status.PENDING);
        order.setTotalPrice(totalBill);
        order.setUser(getAuthUser());
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
        return order;

    }

    @Override
    @Transactional(readOnly = true)
    public Page<Order> findAll(Pageable pageable) {
        log.debug("Request to get all Orders");
        return orderRepository.findAll(pageable);
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
}
