package com.kce.order_service.service.impl;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kce.order_service.dto.OrderRequest;
import com.kce.order_service.entity.Order;
import com.kce.order_service.feignClient.IceCreamFeign;
import com.kce.order_service.repository.OrderRepository;
import com.kce.order_service.response.CommonResponse;
import com.kce.order_service.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	    @Autowired
	    private OrderRepository orderRepository;

	    @Override
	    public Order createOrder(OrderRequest orderRequest) {
	        CommonResponse response = iceCreamFeign.getFlavourWithCoupon(
	            orderRequest.getFlavorId(),
	            orderRequest.getCouponCode()
	        );

	        
	        @SuppressWarnings("unchecked")
	        LinkedHashMap<String, Object> flavourData = (LinkedHashMap<String, Object>) response.getData();
           System.out.println(flavourData);
	        double price = Double.parseDouble(flavourData.get("price").toString());
	        double totalPrice = price * orderRequest.getQuantity();

	        Order order = new Order();
	        order.setFlavorId(orderRequest.getFlavorId());
	        order.setCouponCode(orderRequest.getCouponCode());
	        order.setUserName(orderRequest.getUserName());
	        order.setQuantity(orderRequest.getQuantity());
	        order.setPrice(totalPrice);
	        order.setOrderDate(LocalDateTime.now());

	        return orderRepository.save(order);
	    }


	    @Override
	    public List<Order> getAllOrders() {
	        return orderRepository.findAll();
	    }

	    @Override
	    public Order getOrderById(String id) {
	        return orderRepository.findById(id).orElse(null);
	    }

	    @Override
	    public Order updateOrder(String id, Order updatedOrder) {
	        Order order = getOrderById(id);
	        if (order != null) {
	            order.setQuantity(updatedOrder.getQuantity());
	            order.setPrice(updatedOrder.getPrice());
	            return orderRepository.save(order);
	        }
	        return null;
	    }

	    @Override
	    public void deleteOrder(String id) {
	        orderRepository.deleteById(id);
	    }
	    
	    @Autowired
	    private IceCreamFeign iceCreamFeign;

}
