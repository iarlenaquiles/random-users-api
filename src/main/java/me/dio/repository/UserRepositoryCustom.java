package me.dio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import me.dio.model.User;

@Repository
public interface UserRepositoryCustom {
    @Query(value = "SELECT u.* FROM users AS u WHERE " +
            "u.name LIKE %:query% OR " +
            "u.last_name LIKE %:query% OR " +
            "u.city LIKE %:query% OR " +
            "u.state LIKE %:query% OR " +
            "u.country LIKE %:query% OR " +
            "u.email LIKE %:query%", nativeQuery = true)
    List<User> customSearch(String query);
}