package com.example.carSaleShop.controller;


import com.example.carSaleShop.dto.PageResult;
import com.example.carSaleShop.dto.SalesDto;
import com.example.carSaleShop.model.Auditable;
import com.example.carSaleShop.model.SaleStatus;
import com.example.carSaleShop.service.SalesServices;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/sale")
@RequiredArgsConstructor
public class SalesController extends Auditable {
    private final SalesServices services;

    public String create(SalesDto dto){
        return services.create(dto);
    }

    public SalesDto update(SalesDto dto, String id){
        return services.update(dto, id);
    }

    public SalesDto complete(String id){
        return services.complete(id);
    }

    public void delete(String id){
        services.delete(id);
    }

    public SalesDto getById(String id){
        return services.getById(id);
    }

    public PageResult search(
            @RequestParam (required = false) LocalDateTime date,
            @RequestParam (required = false) String carId,
            @RequestParam (required = false) String customerId,
            @RequestParam (required = false)SaleStatus status,
            @RequestHeader (required = false, defaultValue = "0") int page,
            @RequestHeader (required = false, defaultValue = "10") int size
            ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "createdAt"));
        return services.search(date, carId, customerId, status, pageable);
    }
}
