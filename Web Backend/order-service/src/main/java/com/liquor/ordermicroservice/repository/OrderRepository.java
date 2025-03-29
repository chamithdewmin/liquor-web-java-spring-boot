package com.liquor.ordermicroservice.repository;


import com.liquor.ordermicroservice.model.OrderStatus;
import com.liquor.ordermicroservice.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer> {
    List<Orders> findByUserIdOrderByCreatedAtDesc(int userId);

    List<Orders> findByStatus(OrderStatus status);
}
