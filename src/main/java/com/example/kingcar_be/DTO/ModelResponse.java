package com.example.kingcar_be.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ModelResponse {
    private Long CarId;
    private String brandName;
    private String brandModel;
    private String modelImage;
}
