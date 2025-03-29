package com.liquor.ordermicroservice.repository;


import com.liquor.ordermicroservice.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
    Cart findByUserId(int userId);
}
