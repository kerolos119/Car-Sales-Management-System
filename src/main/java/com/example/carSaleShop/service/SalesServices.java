package com.example.carSaleShop.service;

import com.example.carSaleShop.document.Sales;
import com.example.carSaleShop.dto.PageResult;
import com.example.carSaleShop.dto.SalesDto;
import com.example.carSaleShop.exception.CustomException;
import com.example.carSaleShop.mapper.SalesMapper;
import com.example.carSaleShop.model.Auditable;
import com.example.carSaleShop.model.SaleStatus;
import com.example.carSaleShop.reposatory.SalesRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class SalesServices {

    private final SalesRepository repository;
    private final MongoTemplate template;
    private final SalesMapper mapper;


    public String create (SalesDto dto) {
        Query query = new Query();
        query.addCriteria(Criteria.where("carId").is(dto.getCarId())
                .and("status").in(SaleStatus.PENDING, SaleStatus.COMPLETED));

        if (template.exists(query, Sales.class)) {
            throw new CustomException("A sale for this car is already exists", HttpStatus.CONFLICT);
        }

        Sales sales = mapper.toEntity(dto);
        sales.setStatus(SaleStatus.PENDING);
        sales = repository.save(sales);

        return mapper.toDto(sales).getId();
    }

    public SalesDto complete (String id){
        Sales sale = findOrThrow(id);

        if (sale.getStatus() == SaleStatus.COMPLETED){
            throw new CustomException("Sale is already completed", HttpStatus.BAD_REQUEST);
        }

        if (sale.getStatus() == SaleStatus.CANCELLED){
            throw new CustomException("Sale is cancelled", HttpStatus.BAD_REQUEST);
        }

        sale.setStatus(SaleStatus.COMPLETED);
        sale = repository.save(sale);

        return mapper.toDto(sale);
    }

    public SalesDto update(SalesDto dto, String id){
        Sales sales = findOrThrow(id);

        if (sales.getStatus() == SaleStatus.COMPLETED){
            throw new CustomException("Sale is already completed", HttpStatus.BAD_REQUEST);
        }

        if (sales.getStatus() == SaleStatus.CANCELLED){
            throw new CustomException("Sale is cancelled", HttpStatus.BAD_REQUEST);
        }

        sales = repository.save(mapper.updateToEntity(dto, sales));
        return mapper.toDto(sales);
    }

    public void delete(String id){
        findOrThrow(id);
        repository.deleteById(id);
    }

    public SalesDto getById(String id){
        Sales sales = findOrThrow(id);
        return mapper.toDto(sales);
    }

    public PageResult search(LocalDateTime date,
                             String carId,
                             String customerId,
                             SaleStatus status,
                             Pageable pageable) {

        Query query = new Query();

        if (date != null){
            query.addCriteria(Criteria.where("date")
                    .gte(date.toLocalDate().atStartOfDay())
                    .lte(date.toLocalDate().atTime(23, 59, 59)));
        }

        if (carId != null)
            query.addCriteria(Criteria.where("carId").is(carId));

        if (customerId != null)
            query.addCriteria(Criteria.where("customerId").in(customerId));

        if (status != null)
            query.addCriteria(Criteria.where("status").is(status));

        long count = template.count(query, Sales.class);
        List<SalesDto> items = template.find(query.with(pageable),Sales.class)
                .stream()
                .map(mapper::toDto)
                .toList();

        return PageResult.builder().item(items).count(count).build();
    }


    public Sales findOrThrow(String id){
        return repository.findById(id).orElseThrow(() -> new CustomException("Sale not found", HttpStatus.NOT_FOUND));
    }
}
