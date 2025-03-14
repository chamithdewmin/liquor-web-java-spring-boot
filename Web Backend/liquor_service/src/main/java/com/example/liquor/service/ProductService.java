package com.example.liquor.service;

import com.example.liquor.model.product;
import com.example.liquor.dto.productDTO;
import com.example.liquor.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public String addProduct(product product, MultipartFile imageFile) throws IOException {
        product.setImageType(imageFile.getContentType());
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageData(imageFile.getBytes());
        productRepository.save(product);
        return "Product added successfully!";
    }

    public product getProduct(int id) {
        return productRepository.findById(id).orElse(null);
    }

    public List<productDTO> getAllProductsWithoutImage() {
        return productRepository.findAllWithoutImageData();
    }

    public product updateProduct(int id, product updatedProduct, MultipartFile imageFile) throws IOException {
        Optional<product> existingProductOpt = productRepository.findById(id);
        if (existingProductOpt.isEmpty()) {
            return null;
        }

        product existingProduct = existingProductOpt.get();
        existingProduct.setName(updatedProduct.getName());
        existingProduct.setPrice(updatedProduct.getPrice());
        existingProduct.setDescription(updatedProduct.getDescription());

        if (imageFile != null && !imageFile.isEmpty()) {
            existingProduct.setImageType(imageFile.getContentType());
            existingProduct.setImageName(imageFile.getOriginalFilename());
            existingProduct.setImageData(imageFile.getBytes());
        }

        return productRepository.save(existingProduct);
    }

    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }

    public List<productDTO> searchProducts(String keyword) {
        return productRepository.searchProducts(keyword);
    }
}
