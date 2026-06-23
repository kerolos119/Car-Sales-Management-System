package com.example.carSaleShop.document;

import com.example.carSaleShop.model.Auditable;
import com.example.carSaleShop.model.MaintenanceStatus;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.parameters.P;

import java.time.LocalDateTime;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document("maintenance")
public class Maintenance  extends Auditable {

    @Id
    private String id;

    @Indexed
    @NotBlank
    private String carId;

    @Indexed
    private String customerId;

    private String description;

    private MaintenanceStatus maintenanceStatus;

    private LocalDateTime scheduledDate;

    private LocalDateTime completedDate;

    private Double laborCost;

    private Double totalCost;

    private List<String> usedPartsId;

    private String technicianNotes;



}
