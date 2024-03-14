package com.automated;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@SpringBootApplication
@ComponentScan({"com.automated.controller", "com.automated.service"})
@EntityScan("com.automated.entities")
@EnableNeo4jRepositories
@EnableAutoConfiguration
public class SpringWithNeo4jApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWithNeo4jApplication.class, args);
	}

}
