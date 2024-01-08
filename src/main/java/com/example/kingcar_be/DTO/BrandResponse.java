package com.example.kingcar_be.DTO;


import com.example.kingcar_be.Entity.BrandImage;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class BrandResponse {
    private Long BrandId;
    private String brandName;
    private String brand;
}
