package me.dio.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import me.dio.model.User;

@Repository
public interface StatisticsRepository extends JpaRepository<User, Long>{
    
}
