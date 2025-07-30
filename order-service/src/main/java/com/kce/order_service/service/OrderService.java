package com.kce.order_service.service;

import java.util.List;

import com.kce.order_service.dto.OrderRequest;
import com.kce.order_service.entity.Order;

public interface OrderService {
	Order createOrder(OrderRequest order);
    List<Order> getAllOrders();
    Order getOrderById(String id);
    Order updateOrder(String id, Order order);
    void deleteOrder(String id);
    
}
