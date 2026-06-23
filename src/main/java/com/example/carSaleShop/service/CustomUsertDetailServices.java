package com.example.carSaleShop.service;

import com.example.carSaleShop.document.Users;
import com.example.carSaleShop.model.TokenInfo;
import com.example.carSaleShop.reposatory.UserRepository;
import com.example.carSaleShop.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUsertDetailServices implements UserDetailsService {
    @Autowired
    UserRepository repository;
    @Autowired
    MongoTemplate template;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    JwtUtils jwtUtils;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Users user= repository.findByUsername(username);
       return org.springframework.security.core.userdetails.User.withUsername(user.getUsername()).password(user.getPassword()).roles(user.getRoles()).build();
    }
    public Boolean isValid(TokenInfo tokenInfo){
        Query query= new Query();
        query.addCriteria(Criteria.where("email").is(tokenInfo.getEmail()));
        query.addCriteria(Criteria.where("_id").is(tokenInfo.getUserId()));
        query.addCriteria(Criteria.where("role").is(tokenInfo.getRoles()));

        if (template.exists(query, org.springframework.security.core.userdetails.User.class)){
            return false;
        }
        return true;
    }
}
