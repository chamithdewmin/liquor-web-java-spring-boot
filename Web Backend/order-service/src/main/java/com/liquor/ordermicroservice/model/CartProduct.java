package com.liquor.ordermicroservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CartProduct
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int productId;
    private double productPrice;
    private int quantity;
    private boolean isSelected;

    @ManyToOne
    @JsonIgnore
    private com.liquor.ordermicroservice.model.Cart cart;


    public CartProduct(int productId, int quantity, double productPrice,  com.liquor.ordermicroservice.model.Cart cart)
    {
        this.productId = productId;
        this.quantity = quantity;
        this.productPrice = productPrice;
        this.cart = cart;
        this.isSelected = true;
    }

    public int getId() {
        return id;
    }

    public int getProductId() {
        return productId;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public Cart getCart() {
        return cart;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
