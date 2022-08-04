package br.com.api.desafio.api_desafio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = "br.com.api.desafio.api_desafio.models")
@EnableJpaRepositories(basePackages = "br.com.api.desafio.api_desafio.repository")
@EnableAutoConfiguration
@SpringBootApplication
public class ApiDesafioApplication {

	public static void main(String[] args) {
		//System.setProperty("server.port", "8008");
		SpringApplication.run(ApiDesafioApplication.class, args);
	}

}
