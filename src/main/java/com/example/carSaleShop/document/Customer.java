package com.example.carSaleShop.document;

import com.example.carSaleShop.model.Auditable;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document("customer")
public class Customer extends Auditable {

    @Id
    private String id;

    private String firstName;

    private String lastName;

    @Email
    @Indexed(unique = true)
    private String email;

    @Indexed
    private String phoneNumber;

    private String address;

    private String nationalId;
}
