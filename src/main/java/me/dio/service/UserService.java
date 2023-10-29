package me.dio.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import me.dio.model.User;

public interface UserService extends CrudService<Long, User> {
    String getBase64Thumbnail(Long id);

    Page<User> findAll(Pageable pageable);

}
