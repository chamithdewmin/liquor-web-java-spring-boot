package com.liquor.ordermicroservice.service;

import com.liquor.ordermicroservice.model.*;
import com.liquor.ordermicroservice.repository.CartRepository;
import com.liquor.ordermicroservice.repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CartRepository cartRepository;

    @Transactional
    public Orders createOrder(Orders orders) {
        orders.setCreatedAt(new Date());
        orders.setStatus(OrderStatus.PENDING);
        Cart cart = cartRepository.findById(orders.getCartId()).orElseThrow(()-> new RuntimeException("Cart not found"));
        cart.getCartProducts().clear();
        cart.setTotalAmount(0.0);
        cartRepository.save(cart);
        return orderRepository.save(orders);
    }

    public Orders updateOrderStatus(int orderId, OrderStatus status) {
        Orders orders = orderRepository.findById(orderId).get();
        orders.setStatus(status);
        return orderRepository.save(orders);
    }

    public Orders getOrderById(int orderId) {
        return orderRepository.findById(orderId).get();
    }

    public List<Orders> getOrdersByUserId(int userId) {
        return orderRepository.findByUserIdOrderByCreatedAtDesc(userId);
    }

    public Iterable<Orders> getAllOrders() {
        return orderRepository.findAll();
    }

    public List<Orders> getPendingOrders() {
        return orderRepository.findByStatus(OrderStatus.PENDING);
    }
}