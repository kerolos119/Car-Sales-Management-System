package com.example.carSaleShop.reposatory;

import com.example.carSaleShop.document.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<Users,String> {
    Users findByUsername(String username);
}
