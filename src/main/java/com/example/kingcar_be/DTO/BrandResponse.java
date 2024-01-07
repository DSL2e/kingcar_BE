package com.example.kingcar_be.DTO;


import lombok.Getter;

@Getter
public class BrandResponse {
    private String brand;
    private String brandUrl;

    public static BrandResponse registerBrand(int i, String url){
        BrandResponse b = new BrandResponse();
        switch(i){
            case 1:
                b.brand = "koenigsegg";
                break;
            case 2:
                b.brand = "hyundai";
                break;
            case 3:
                b.brand = "lamborghini";
                break;
            case 4:
                b.brand = "mclaren";
                break;
            case 5:
                b.brand = "porsche";
                break;
            case 6:
                b.brand = "bugatti";
        }
        b.brandUrl = url;

        return b;
    }
}
