package com.example.carSaleShop.dto;

import com.example.carSaleShop.model.Auditable;
import com.example.carSaleShop.model.Role;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class UserDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String id;

    @NotBlank(message = "username is required")
    private String username;

    @Email(message = "email invalid")
    @NotBlank(message = "email is required")
    private String email;

    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&#])[A-Za-z\\d@$!%*?&#]{8,}$",
            message = "password must be contain upperCase, lowerCase, number and special character and at least 8 characters")
    private String password;

    private Role role;

}
