package com.example.carSaleShop.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class CustomerDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String id;

    @NotBlank(message = "first name is required")
    private String firstName;

    @NotBlank(message = "last name is required")
    private String lastName;

    @Email(message = "email invalid")
    @NotBlank(message = "email is required")
    private String email;

    @NotBlank
    @Pattern(regexp = "^\\+?[0-9]\\d{7,14}$")
    private String phoneNumber;

    @NotBlank(message = "address is required")
    private String address;

    @NotBlank(message = "national id is required")
    private String nationalId;


}
