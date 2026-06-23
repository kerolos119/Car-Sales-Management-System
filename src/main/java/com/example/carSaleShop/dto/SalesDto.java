package com.example.carSaleShop.dto;

import com.example.carSaleShop.model.SaleStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SalesDto {

    private String id;

    @NotBlank(message = "Car ID is required")
    private String carId;

    @NotBlank(message = "Customer ID is required")
    private String customerId;

    @NotNull(message = "Sale date is required")
    private LocalDateTime date;

    @NotNull(message = "Sale price is required")
    @Positive(message = "Sale price must be positive")
    private Double salePrice;

    private SaleStatus status;

    private String notes;
}