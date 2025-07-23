package com.kce.order_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kce.order_service.dto.Flavour;
import com.kce.order_service.dto.OrderRequest;
import com.kce.order_service.entity.Order;
import com.kce.order_service.response.CommonResponse;
import com.kce.order_service.service.OrderService;


@RestController
@RequestMapping("/api/order")
public class OrderContoller {
	@Autowired
    private OrderService orderService;

	 @PostMapping
	 public ResponseEntity<Order> createOrder(@RequestBody OrderRequest orderRequest) {
	       Order createdOrder = orderService.createOrder(orderRequest);
	       return ResponseEntity.ok(createdOrder);
	 }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable String id) {
        return orderService.getOrderById(id);
    }

    @PutMapping("/{id}")
    public Order updateOrder(@PathVariable String id, @RequestBody Order order) {
        return orderService.updateOrder(id, order);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable String id) {
        orderService.deleteOrder(id);
    }
   
    
}
