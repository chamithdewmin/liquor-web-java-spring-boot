package com.liquor.ordermicroservice.repository;


import com.liquor.ordermicroservice.model.CartProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartProductRepository extends JpaRepository<CartProduct, Integer> {

    CartProduct findByCartIdAndProductId(int cartId, int productId);
}

