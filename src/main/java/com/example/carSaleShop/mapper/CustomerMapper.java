package com.example.carSaleShop.mapper;

import com.example.carSaleShop.document.Customer;
import com.example.carSaleShop.dto.CustomerDto;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper extends AbstractMapper<CustomerDto, Customer> {

    public CustomerMapper() {
        super(CustomerDto.class, Customer.class);
    }

    @Override
    public Customer updateToEntity(CustomerDto dto, Customer entity) {
        if (dto.getFirstName() != null && !dto.getFirstName().isBlank())
            entity.setFirstName(dto.getFirstName());
        if (dto.getLastName() != null && !dto.getLastName().isBlank())
            entity.setLastName(dto.getLastName());
        if (dto.getEmail() != null && !dto.getEmail().isBlank())
            entity.setEmail(dto.getEmail());
        if (dto.getPhoneNumber() != null && !dto.getPhoneNumber().isBlank())
            entity.setPhoneNumber(dto.getPhoneNumber());
        if (dto.getAddress() != null && !dto.getAddress().isBlank())
            entity.setAddress(dto.getAddress());
        if (dto.getNationalId() != null && !dto.getNationalId().isBlank())
            entity.setNationalId(dto.getNationalId());
        return entity;
    }
}