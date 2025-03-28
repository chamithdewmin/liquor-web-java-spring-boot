
package com.liquor.ordermicroservice.controller;

import com.liquor.ordermicroservice.model.Cart;
import com.liquor.ordermicroservice.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/{customerId}/items")
    public ResponseEntity<Cart> addToCart(
            @PathVariable int customerId,
            @RequestParam int productId,
            @RequestParam int quantity,
            @RequestParam double productPrice
    ) {
        try {
            Cart updatedCart = cartService.addToCart(customerId, productId, quantity, productPrice);
            return new ResponseEntity<>(updatedCart, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<Cart> getCart(@PathVariable int customerId) {
        try {
            Cart cart = cartService.getCart(customerId);
            return new ResponseEntity<>(cart, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{customerId}/items/{productId}")
    public ResponseEntity<Cart> removeFromCart(
            @PathVariable int customerId,
            @PathVariable int productId
    ) {
        try {
            Cart updatedCart = cartService.removeFromCart(customerId, productId).getBody();
            return new ResponseEntity<>(updatedCart, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{customerId}/items/{productId}")
    public ResponseEntity<Cart> updateProductQuantity(
            @PathVariable int customerId,
            @PathVariable int productId,
            @RequestParam int quantity
    ) {
        try {
            Cart updatedCart = cartService.updateProductQuantity(customerId, productId, quantity);
            return new ResponseEntity<>(updatedCart, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{customerId}/set/{productId}")
    public ResponseEntity<Cart> updateProductIsSelected(
            @PathVariable int customerId,
            @PathVariable int productId,
            @RequestParam boolean isSelected
    ) {
        try {
            Cart updatedCart = cartService.updateProductIsSelected(customerId, productId, isSelected);
            return new ResponseEntity<>(updatedCart, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}