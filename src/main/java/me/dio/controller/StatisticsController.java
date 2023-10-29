package me.dio.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import me.dio.service.StatisticsService;

@RestController
@RequestMapping("/users/statistics")
public record StatisticsController(StatisticsService statisticsService) {

    @GetMapping
    @Operation(summary = "Get user statistics", description = "Get user statistics")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation")
    })
    public ResponseEntity<Map<String, Object>> statistics() {        
        return ResponseEntity.ok(statisticsService.getStatistics());
    }

}
