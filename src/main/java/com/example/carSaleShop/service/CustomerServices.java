package com.example.carSaleShop.service;

import com.example.carSaleShop.dto.CustomerDto;
import com.example.carSaleShop.mapper.CustomerMapper;
import com.example.carSaleShop.reposatory.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomerServices {

    CustomerRepository repository;
    CustomerMapper mapper;
    MongoTemplate template;

    public CustomerDto create(CustomerDto dto){

    }
}
