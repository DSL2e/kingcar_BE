package com.example.kingcar_be.Repository;

import com.example.kingcar_be.Entity.BrandImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandImageRepository extends JpaRepository<BrandImage, Long> {
    List<BrandImage> findAll();
}
