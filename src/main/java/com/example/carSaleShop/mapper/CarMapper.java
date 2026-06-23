package com.example.carSaleShop.mapper;

import com.example.carSaleShop.document.Car;
import com.example.carSaleShop.dto.CarDto;
import org.springframework.stereotype.Component;

@Component
public class CarMapper extends AbstractMapper<CarDto, Car> {

    public CarMapper() {
        super(CarDto.class, Car.class);
    }

    @Override
    public Car updateToEntity(CarDto dto, Car entity) {
        if (dto.getName() != null && !dto.getName().isBlank())
            entity.setName(dto.getName());
        if (dto.getQuantity() != null && !dto.getQuantity().isBlank())
            entity.setQuantity(dto.getQuantity());
        if (dto.getColor() != null && !dto.getColor().isBlank())
            entity.setColor(dto.getColor());
        if (dto.getPrice() != null)
            entity.setPrice(dto.getPrice());
        if (dto.getTransition() != null)
            entity.setTransition(dto.getTransition());
        if (dto.getType() != null)
            entity.setType(dto.getType());
        return entity;
    }
}