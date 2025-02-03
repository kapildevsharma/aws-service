package com.kapil.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(new Info().title("Spring Boot Application with integaration with AWS SQS, S3, RDS Service")
						.description("API for integrate with AWS SQS, S3, RDS, SM Service").version("1.0.0"));
	}
}
