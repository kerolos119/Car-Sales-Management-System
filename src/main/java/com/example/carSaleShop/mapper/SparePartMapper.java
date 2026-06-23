package com.example.carSaleShop.mapper;


import com.example.carSaleShop.document.SpareParts;

import com.example.carSaleShop.dto.SparePartsDto;
import org.springframework.stereotype.Component;

@Component
public class SparePartMapper extends AbstractMapper<SparePartsDto, SpareParts> {

    public SparePartMapper() {
        super(SparePartsDto.class, SpareParts.class);
    }

    @Override
    public SpareParts updateToEntity(SparePartsDto dto, SpareParts entity) {
        if (dto.getName() != null && !dto.getName().isBlank())
            entity.setName(dto.getName());
        if (dto.getPartNumber() != null && !dto.getPartNumber().isBlank())
            entity.setPartNumber(dto.getPartNumber());
        if (dto.getCategory() != null && !dto.getCategory().isBlank())
            entity.setCategory(dto.getCategory());
        if (dto.getCompatibleCarModel() != null && !dto.getCompatibleCarModel().isBlank())
            entity.setCompatibleCarModel(dto.getCompatibleCarModel());
        if (dto.getStockQuantity() != null)
            entity.setStockQuantity(dto.getStockQuantity());
        if (dto.getMinimumStockLevel() != null)
            entity.setMinimumStockLevel(dto.getMinimumStockLevel());
        if (dto.getPricePerUnit() != null)
            entity.setPricePerUnit(dto.getPricePerUnit());
        if (dto.getSupplier() != null && !dto.getSupplier().isBlank())
            entity.setSupplier(dto.getSupplier());
        return entity;
    }
}