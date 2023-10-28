package me.dio.service;

import me.dio.model.User;

public interface UserService extends CrudService<Long, User> {
    String getBase64Thumbnail(Long id);

    // Page<User> getUsersByPage(int pageNumber, int pageSize);

}
