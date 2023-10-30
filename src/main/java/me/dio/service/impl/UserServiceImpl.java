package me.dio.service.impl;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import me.dio.exception.InvalidQueryException;
import me.dio.model.User;
import me.dio.repository.UserRepository;
import me.dio.service.UserService;
import me.dio.utils.ImageDownloader;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Cacheable("getBase64Thumbnail")
    public String getBase64Thumbnail(Long id) {
        try {
            log.info("Get user by id: " + id);
            User user = userRepository.findById(id).orElseThrow(() -> {
                log.error("User not found with id in getBase64Thumbnail {}", id);
                return new RuntimeException("User not found with id in getBase64Thumbnail " + id);
            });

            log.info("Download image: " + user.getThumbnail());
            byte[] imageBytes = ImageDownloader.downloadImage(user.getThumbnail());

            log.info("Base64 encode");
            String base64Image = Base64.getEncoder().encodeToString(imageBytes);
            return base64Image;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    @Cacheable("findById")
    public User findById(Long id) {
        log.info("Get user by id: " + id);

        return userRepository.findById(id).orElseThrow(() -> {
            log.error("User not found with id {}", id);
            return new RuntimeException("User not found with id " + id);
        });
    }

    @Override
    public User create(User entity) {
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public User update(Long id, User entity) {
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public List<User> findAll() {
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    @Cacheable("findAll")
    public Page<User> findAll(Pageable pageable) {
        log.info("Get all users by pageable: " + pageable);

        return this.userRepository.findAll(pageable);
    }

    @Override
    @Cacheable("search")
    public List<User> search(String query) {
        log.info("Get user by query: " + query);

        int queryLength = query.length();
        if (queryLength < 3 || queryLength > 64) {
            log.error("Query length must be between 3 and 64 characters");
            throw new InvalidQueryException("Query length must be between 3 and 64 characters.");
        }

        log.info("Return users by query: " + query);
        return this.userRepository.customSearch(query);
    }
}
