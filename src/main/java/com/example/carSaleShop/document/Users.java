package com.example.carSaleShop.document;

import com.example.carSaleShop.model.Auditable;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document("user")
public class Users extends Auditable {
    @Id
    private String id;

    private String username;

    @Email
    private String email;

    private String password;

    private String roles;
}
