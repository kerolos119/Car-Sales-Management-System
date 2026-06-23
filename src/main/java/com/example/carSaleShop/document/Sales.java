package com.example.carSaleShop.document;

import com.example.carSaleShop.model.Auditable;
import com.example.carSaleShop.model.Auitable;
import com.example.carSaleShop.model.SaleStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document("sales")
public class Sales extends Auditable {

    @Id
    private String id;

    @Indexed
    private String carId;

    @Indexed
    private String customerId;

    private LocalDateTime date;

    private Double salePrice;

    @Builder.Default
    private SaleStatus status = SaleStatus.PENDING;

    private String notes;
}