package me.dio.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import me.dio.model.User;

public interface UserService extends CrudService<Long, User> {
    String getBase64Thumbnail(Long id);

    Page<User> findAll(Pageable pageable);  
    
    List<User> search(String query);
}
