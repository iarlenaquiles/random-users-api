package me.dio.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import me.dio.model.User;
import me.dio.service.UserService;

@RestController
@RequestMapping("/users")
@Tag(name = "User Controller", description = "RESTful API for managing users.")
public record UserController(UserService userService) {

    @GetMapping
    @Operation(summary = "Get all users", description = "Get a list of all registered users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation")
    })
    public ResponseEntity<Page<User>> findAll(Pageable pageable) {
        return ResponseEntity.ok(userService.findAll(pageable));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get one user", description = "Get one registered user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation")
    })
    public ResponseEntity<User> findOne(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @GetMapping("/{id}/thumbnail")
    @Operation(summary = "Get thumbnail by user", description = "Get thumbnail by user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation")
    })
    public ResponseEntity<String> getThumbnail(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getBase64Thumbnail(id));
    }

    @GetMapping("/search")
     @Operation(summary = "Get user by query", description = "Get user by query")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation")
    })
    public ResponseEntity<List<User>> searchUsers(@RequestParam String query) {        
        return ResponseEntity.ok(userService.search(query));
    }
}
