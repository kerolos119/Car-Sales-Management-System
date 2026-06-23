package com.example.carSaleShop.service;

import com.example.carSaleShop.document.Users;
import com.example.carSaleShop.dto.PageResult;
import com.example.carSaleShop.dto.UserDto;
import com.example.carSaleShop.exception.CustomException;
import com.example.carSaleShop.mapper.UserMapper;
import com.example.carSaleShop.reposatory.UserReposatory;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Builder
public class UserServices {
    @Autowired
    UserReposatory reposatory;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UserMapper mapper;
    @Autowired
    MongoTemplate template;
    public  String create (UserDto dto){
        dto.setPassword(passwordEncoder.encode(dto.getPassword()));
        return reposatory.save(mapper.toEntity(dto)).getId();//مش عارف اغمل  الcreatedat
    }

    public void delete(String id) {
        readUser(id);
        reposatory.deleteById(id);
    }

    public void update(String id, UserDto dto) {
        Users user = readUser(id);
        reposatory.save(mapper.updateToEntity(dto,user));
    }

    public UserDto getById(String id) {
        Users user = readUser(id);
        return mapper.toDto(user);
    }
    private Users readUser(String id){
        Optional<Users> user = reposatory.findById(id);
        if (!user.isPresent())
            throw new CustomException("use Not Found", HttpStatus.NOT_FOUND);
        return  user.get();
    }


    public PageResult search(Pageable pageable, String roles, String username) {
        Query query =new Query();
        if (username != null && !username.isEmpty()){
            query.addCriteria(Criteria.where("username").regex(username,"i"));
        }
        if (roles !=null && !roles.isEmpty()){
            query.addCriteria(Criteria.where("roles").is(roles));
        }
        Long count =template.count(query, Users.class);
        List< UserDto> user = template.find(query.with(pageable), Users.class).stream().map(mapper::toDto).toList();
        return PageResult.builder().item(user).count(count).build();
    }
}
