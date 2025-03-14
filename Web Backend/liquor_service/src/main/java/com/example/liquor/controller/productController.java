package com.example.liquor.controller;

import com.example.liquor.dto.productDTO;
import com.example.liquor.model.product;
import com.example.liquor.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/food")
public class productController {

    private final ProductService service;

    public productController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<product> getProductById(@PathVariable int id) {
        product product = service.getProduct(id);
        return product != null ? ResponseEntity.ok(product) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/product")
    public ResponseEntity<List<productDTO>> getAllProducts() {
        return ResponseEntity.ok(service.getAllProductsWithoutImage());
    }

    @GetMapping("/product/{id}/image")
    public ResponseEntity<byte[]> getImageByProductId(@PathVariable int id) {
        product product = service.getProduct(id);
        if (product == null || product.getImageData() == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok()
                .contentType(MediaType.valueOf(product.getImageType()))
                .body(product.getImageData());
    }

    @PostMapping("/product")
    public ResponseEntity<String> addProduct(@RequestPart product product, @RequestPart MultipartFile imageFile) {
        try {
            String result = service.addProduct(product, imageFile);
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable int id, @RequestPart product product, @RequestPart MultipartFile imageFile) {
        try {
            product updatedProduct = service.updateProduct(id, product, imageFile);
            if (updatedProduct == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
            }
            return ResponseEntity.ok("Product updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id) {
        product product = service.getProduct(id);
        if (product == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }
        service.deleteProduct(id);
        return ResponseEntity.ok("Product deleted successfully");
    }

    @GetMapping("/products/search")
    public ResponseEntity<List<productDTO>> searchProduct(@RequestParam String keyword) {
        return ResponseEntity.ok(service.searchProducts(keyword));
    }
}
