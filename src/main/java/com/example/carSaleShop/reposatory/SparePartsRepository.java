package com.example.carSaleShop.reposatory;

import com.example.carSaleShop.document.SpareParts;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SparePartsRepository extends MongoRepository<SpareParts, String> {
}
