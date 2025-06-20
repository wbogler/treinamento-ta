package br.com.cadpessoas.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "br.com.cadpessoas.core.repository")
@EntityScan(basePackages = "br.com.cadpessoas.core.entity")
@ComponentScan(basePackages = {
		"br.com.cadpessoas.api",
		"br.com.cadpessoas.core",
		"br.com.cadpessoas.domain"
})
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

}
