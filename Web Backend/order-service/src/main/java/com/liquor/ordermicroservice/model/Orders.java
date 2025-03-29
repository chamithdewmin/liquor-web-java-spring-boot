package com.liquor.ordermicroservice.model;
import jakarta.persistence.*;
import lombok.*;


import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Orders
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int userId;
    private int cartId;
    private double totalAmount;
    private String orderDetails;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    private String address;
    private Date createdAt;

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public int getCartId() {
        return cartId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public String getOrderDetails() {
        return orderDetails;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public String getAddress() {
        return address;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setOrderDetails(String orderDetails) {
        this.orderDetails = orderDetails;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
