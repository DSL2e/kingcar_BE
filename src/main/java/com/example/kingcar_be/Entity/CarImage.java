package com.example.kingcar_be.Entity;

import jakarta.persistence.*;

@Entity
public class CarImage {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long carImageId;

    @Column(name = "brand_name")
    private String brandName;

    @Column(name = "brand_model")
    private String brandModel;

    @Column(name = "model_image")
    private String modelImage;
}
