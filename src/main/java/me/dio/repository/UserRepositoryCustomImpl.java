package me.dio.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import me.dio.model.User;

@Repository
public class UserRepositoryCustomImpl implements UserRepositoryCustom {
   
    @Override
    public List<User> customSearch(String query) {
        
        return null;
    }
}
