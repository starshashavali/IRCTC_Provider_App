package com.tcs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean//to write our own implemention in this method
	public Docket restApi(){
		return new Docket(DocumentationType.SWAGGER_2)
		.select()
		.apis(RequestHandlerSelectors.basePackage("com.tcs.controller"))
		.paths(PathSelectors.any())
		.build();
		//PathSelectors.any() means in this class  all the methods will generate documentation

	}


}
/*
======================
Swagger Configuration
======================

=> Swagger is used to generate REST API documentation

=> Swagger is a third party Library (we need to add in our app)

=> Swagger UI is used to test REST API with user interface


1) Add below dependencies in pom.xml file

		<dependency>
			<groupId>io.springfox</groupId>
			<artifactId>springfox-swagger2</artifactId>
			<version>2.4.0</version>
		</dependency>

		<dependency>
			<groupId>io.springfox</groupId>
			<artifactId>springfox-swagger-ui</artifactId>
			<version>2.4.0</version>
		</dependency>


2) Create SwaggerConfig class

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket apiDoc() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("in.ashokit.rest"))
				.paths(PathSelectors.any())
				.build();
	}
}


Note: If we are getting NPE when we run the application, then add below property in application.properties file
spring.mvc.pathmatch.matching-strategy = ANT_PATH_MATCHER
3) Run the application and access SWAGGER DOC and SWAGGER UI


		Swagger DOC URL : http://localhost:8080/v2/api-docs

		Swagger UI URL : http://localhost:8080/swagger-ui.html




*/