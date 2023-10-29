package me.dio.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.dio.model.User;
import me.dio.repository.StatisticsRepository;
import me.dio.service.StatisticsService;

@Service
public class StatisticsServiceImpl implements StatisticsService {

    @Autowired
    private StatisticsRepository statisticsRepository;

    public Map<String, Object> getStatistics() {
        List<User> user = statisticsRepository.findAll();

        Map<String, Object> statistics = new HashMap<>();

        Map<String, Integer> genders = new HashMap<>();
        Map<String, Integer> countries = new HashMap<>();
        Map<String, Integer> ageRange = new HashMap<>();

        for (User person : user) {
            String gender = person.getGender();
            genders.put(gender, genders.getOrDefault(gender, 0) + 1);

            String country = person.getCountry();
            countries.put(country, countries.getOrDefault(country, 0) + 1);

            int age = person.getAge();
            if (age >= 21 && age <= 30) {
                ageRange.put("21_30", ageRange.getOrDefault("21_30", 0) + 1);
            } else if (age >= 31 && age <= 40) {
                ageRange.put("31_40", ageRange.getOrDefault("31_40", 0) + 1);
            } else if (age >= 41 && age <= 60) {
                ageRange.put("41_60", ageRange.getOrDefault("41_60", 0) + 1);
            } else if (age >= 61 && age <= 80) {
                ageRange.put("61_80", ageRange.getOrDefault("61_80", 0) + 1);
            } else {
                ageRange.put("other", ageRange.getOrDefault("other", 0) + 1);
            }
        }

        statistics.put("genders", genders);
        statistics.put("countries", countries);
        statistics.put("age_range", ageRange);

        return statistics;
    }
}
