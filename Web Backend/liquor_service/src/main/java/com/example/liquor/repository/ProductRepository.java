package com.example.liquor.repository;

import com.example.liquor.dto.productDTO;
import com.example.liquor.model.product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<product, Integer> {

    @Query("SELECT new com.example.liquor.dto.productDTO(p.id, p.name, p.description, p.category, p.price, p.volume, p.alcoholPercentage, p.brand, p.imageName, p.imageType) FROM product p")
    List<productDTO> findAllWithoutImageData();

    @Query("SELECT new com.example.liquor.dto.productDTO(p.id, p.name, p.description, p.category, p.price, p.volume, p.alcoholPercentage, p.brand, p.imageName, p.imageType) " +
            "FROM product p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<productDTO> searchProducts(String keyword);
}
