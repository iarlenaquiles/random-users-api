package me.dio.repository;

import org.springframework.data.domain.Page;

// import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.dio.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // List<User> findByNameContainingIgnoreCase(String name);
    // List<User> findByLast_nameContainingIgnoreCase(String last_name);
    // List<User> findByCityContainingIgnoreCase(String city);
    // List<User> findByStateContainingIgnoreCase(String state);
    // List<User> findByCountryContainingIgnoreCase(String country);
    // List<User> findByEmailContainingIgnoreCase(String email);
    // Page<User> findAllByPage(int pageNumber, int pageSize);
}
