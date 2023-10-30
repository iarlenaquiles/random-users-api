package me.dio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import lombok.extern.slf4j.Slf4j;

/**
 * Initializes our RESTful API.
 * 
 * <p>
 * The {@link OpenAPIDefinition} annotation was used to enable HTTPS in the
 * Swagger UI.
 */
@EnableCaching
@OpenAPIDefinition(servers = { @Server(url = "/", description = "Default Server URL") })
@SpringBootApplication
@EnableJpaRepositories
@Slf4j
public class Application {
	public static void main(String[] args) {
		log.info("Application init");
		SpringApplication.run(Application.class, args);
	}
}
