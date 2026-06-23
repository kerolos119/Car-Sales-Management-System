package com.example.carSaleShop.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SparePartsDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String id;

    @NotBlank(message = "part name is required")
    private String name;

    private String partNumber;

    private String category;

    private String compatibleCarModel;

    @Min(value = 0, message = "stock quantity must be non-negative")
    private Integer stockQuantity;

    @Min(value = 0, message = "minimum stock level must be non-negative")
    private Integer minimumStockLevel;

    private Double pricePerUnit;

    private String supplier;

}
