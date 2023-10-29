package me.dio.service.impl;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import me.dio.model.User;
import me.dio.repository.UserRepositoryCustomImpl;
import me.dio.repository.UserRepository;
import me.dio.service.UserService;
import me.dio.utils.ImageDownloader;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public String getBase64Thumbnail(Long id) {
        try {
            User user = userRepository.findById(id).orElseThrow(() -> {
                log.error("User not found with id in getBase64Thumbnail {}", id);
                return new RuntimeException("User not found with id in getBase64Thumbnail " + id);
            });
            byte[] imageBytes = ImageDownloader.downloadImage(user.getThumbnail());
            String base64Image = Base64.getEncoder().encodeToString(imageBytes);
            return base64Image;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User findById(Long id) {
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
    public Page<User> findAll(Pageable pageable) {
        return this.userRepository.findAll(pageable);
    }

    @Override
    public List<User> search(String query) {
        return this.userRepository.customSearch(query);
    }   
}
