package com.liquor.ordermicroservice.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int userId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cart", orphanRemoval = true)
    private List<CartProduct> cartProducts;
    private double totalAmount;

    public Cart(int userId) {
        this.userId = userId;
        this.totalAmount = 0.0;
        this.cartProducts = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public List<CartProduct> getCartProducts() {
        return cartProducts;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setCartProducts(List<CartProduct> cartProducts) {
        this.cartProducts = cartProducts;
    }
}
