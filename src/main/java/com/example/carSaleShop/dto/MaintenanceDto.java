package com.example.carSaleShop.dto;

import com.example.carSaleShop.model.MaintenanceStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class MaintenanceDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String id;

    @NotBlank(message = "car id is required")
    private String carId;

    @NotBlank(message = "customer id is required")
    private String customerId;

    @NotBlank(message = "description is required")
    private String description;

    private MaintenanceStatus maintenanceStatus;

    private LocalDateTime scheduledDate;

    private LocalDateTime completedDate;

    private Double laborCost;

    private Double totalCost;

    private List<String> usedPartsId;

    private String technicianNotes;

}
