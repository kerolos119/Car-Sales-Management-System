package com.example.carSaleShop.document;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document("spare_part")
public class SpareParts {

    @Id
    private String id;

    @NotBlank
    @Indexed
    private String name;

    @Indexed
    private String partNumber;

    @Indexed
    private String category;

    private String compatibleCarModel;

    @Min(0)
    private Integer stockQuantity;

    @Min(0)
    private Integer minimumStockLevel;

    private Double pricePerUnit;

    private String supplier;
}
