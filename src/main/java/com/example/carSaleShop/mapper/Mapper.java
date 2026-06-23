package com.example.carSaleShop.mapper;

public interface Mapper<D, E> {
    E toEntity(D dto);
    D toDto(E entity);
    E updateToEntity(D dto, E entity);
}