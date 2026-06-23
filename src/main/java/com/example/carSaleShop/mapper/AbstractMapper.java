package com.example.carSaleShop.mapper;

import jakarta.annotation.PostConstruct;
import lombok.Setter;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractMapper<D, E> implements Mapper<D, E> {

    @Autowired
    @Setter
    protected ModelMapper modelMapper;

    private final Class<D> dtoClass;
    private final Class<E> entityClass;

    protected AbstractMapper(Class<D> dtoClass, Class<E> entityClass) {
        this.dtoClass = dtoClass;
        this.entityClass = entityClass;
    }

    @PostConstruct
    public void init() {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT)
                .setAmbiguityIgnored(true)
                .setPropertyCondition(Conditions.isNotNull());
    }

    @Override
    public E toEntity(D dto) {
        return modelMapper.map(dto, entityClass);
    }

    @Override
    public D toDto(E entity) {
        return modelMapper.map(entity, dtoClass);
    }

    // Each mapper implements its own partial update logic
    @Override
    public abstract E updateToEntity(D dto, E entity);
}