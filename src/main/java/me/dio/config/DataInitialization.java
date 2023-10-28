package me.dio.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;
import me.dio.model.RandomUser;
import me.dio.model.RandomUserResponse;
import me.dio.model.User;
import me.dio.repository.UserRepository;

@Component
@Slf4j
public class DataInitialization implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("onApplicationEvent is running...");
       
        if (userRepository.count() == 0) {
            log.info("userRepository.count(): " + userRepository.count());
            ObjectMapper objectMapper = new ObjectMapper();

            String apiUrl = "https://randomuser.me/api/?results=200";
            String response = restTemplate.getForObject(apiUrl, String.class);
            RandomUserResponse userResponse;
            try {
                userResponse = objectMapper.readValue(response, RandomUserResponse.class);
                log.info("RandomUserResponse");
                if (userResponse != null && userResponse.getResults() != null) {
                    List<User> users = new ArrayList<>();

                    for (RandomUser randomUser : userResponse.getResults()) {
                        User user = new User();

                        user.setGender(randomUser.getGender());
                        user.setName(randomUser.getName().getFirst());
                        user.setLast_name(randomUser.getName().getLast());
                        user.setCity(randomUser.getLocation().getCity());
                        user.setState(randomUser.getLocation().getState());
                        user.setCountry(randomUser.getLocation().getCountry());
                        user.setEmail(randomUser.getEmail());
                        user.setBirthday(randomUser.getDob().getDate());
                        user.setCell(randomUser.getCell());
                        user.setThumbnail(randomUser.getPicture().getThumbnail());

                        users.add(user);
                        // userRepository.save(user);
                    }
                    log.info("Users ready to save");
                    userRepository.saveAll(users);
                }
            } catch (JsonMappingException e) {
                e.printStackTrace();
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
    }
}
