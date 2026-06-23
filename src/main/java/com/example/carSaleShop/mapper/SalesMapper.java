package com.example.carSaleShop.mapper;

import com.example.carSaleShop.document.Sales;
import com.example.carSaleShop.dto.SalesDto;
import org.springframework.stereotype.Component;

@Component
public class SalesMapper extends AbstractMapper<SalesDto, Sales> {

    public SalesMapper() {
        super(SalesDto.class, Sales.class);
    }

    @Override
    public Sales updateToEntity(SalesDto dto, Sales entity) {
        if (dto.getCarId() != null && !dto.getCarId().isBlank())
            entity.setCarId(dto.getCarId());
        if (dto.getCustomerId() != null && !dto.getCustomerId().isBlank())
            entity.setCustomerId(dto.getCustomerId());
        if (dto.getDate() != null)
            entity.setDate(dto.getDate());
        if (dto.getStatus() != null)
            entity.setStatus(dto.getStatus());
        if (dto.getSalePrice() != null)
            entity.setSalePrice(dto.getSalePrice());
        return entity;
    }
}