package com.online.shop.web.rest;

import com.online.shop.config.Constants;
import com.online.shop.domain.Order;
import com.online.shop.domain.OrderDetails;
import com.online.shop.domain.Product;
import com.online.shop.security.AuthoritiesConstants;
import com.online.shop.service.OrderService;
import com.online.shop.service.criteria.OrderDetailsCriteria;
import com.online.shop.service.criteria.ProductCriteria;
import com.online.shop.service.dto.CreateOrderDto;
import com.online.shop.web.rest.errors.BadRequestAlertException;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.online.shop.domain.Order}.
 */
@RestController
@RequestMapping("/api")
public class OrderResource {

    private final Logger log = LoggerFactory.getLogger(OrderResource.class);

    private static final String ENTITY_NAME = "order";

    private String applicationName = Constants.APPLICATION_NAME;

    private final OrderService orderService;

    public OrderResource(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/orders")
    public  ResponseEntity<Order> placeOrder(@Valid @RequestBody CreateOrderDto createOrderDto) throws URISyntaxException {
        log.debug("REST request to place Order : {}", createOrderDto);
        if (createOrderDto.getProductDTO().isEmpty()) {
            throw new BadRequestAlertException("Select at least one product to continue!", ENTITY_NAME, "emptyorder");
        } else {
            Order result = orderService.createOrder(createOrderDto);
            return ResponseEntity.created(new URI("/api/orders/" + result.getId()))
                    .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
                    .body(result);
        }
    }

    /**
     * {@code GET  /orders} : get all the orders.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of orders in body.
     */
    @GetMapping("/orders")
    @PreAuthorize("hasAuthority(\"" + AuthoritiesConstants.ADMIN + "\")")
    public ResponseEntity<List<Order>> getAllOrders(Pageable pageable) {
        log.debug("REST request to get a page of Orders");
        Page<Order> page = orderService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    @GetMapping("/orders-filter")
    public ResponseEntity<List<OrderDetails>> getAllOrdersByCriteria(OrderDetailsCriteria criteria, Pageable pageable) {
        log.debug("REST request to get a page of Products");
        Page<OrderDetails> page = orderService.getAllOrdersByCriteria(pageable, criteria);
        HttpHeaders headers = com.online.shop.util.PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }



    /**
     * {@code GET  /orders/:id} : get the "id" order.
     *
     * @param id the id of the orderDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the orderDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/orders/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable Long id) {
        log.debug("REST request to get Order : {}", id);
        Optional<Order> order = orderService.findOne(id);
        return ResponseUtil.wrapOrNotFound(order);
    }

    /**
     * {@code DELETE  /orders/:id} : delete the "id" order.
     *
     * @param id the id of the orderDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/orders/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        log.debug("REST request to delete Order : {}", id);
        orderService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
