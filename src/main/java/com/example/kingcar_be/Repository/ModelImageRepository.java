package com.example.kingcar_be.Repository;

import com.example.kingcar_be.Entity.CarImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModelImageRepository extends JpaRepository<CarImage,Long> {
    List<CarImage> findByBrandName(String brandName);
}
