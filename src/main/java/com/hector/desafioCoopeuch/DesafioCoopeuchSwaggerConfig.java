package com.hector.desafioCoopeuch;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;

import com.google.common.base.Predicates;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class DesafioCoopeuchSwaggerConfig {

	
//	@Bean
//	public Docket api() {
//		return new Docket(DocumentationType.SWAGGER_2)
//				.select()
//				.apis(RequestHandlerSelectors.basePackage("com.hector.desafioCoopeuch.controllers"))
//				.paths(PathSelectors.any())
//				.build();
//	}
	
	@Bean
	public Docket cursoApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("api-tarea")				
				.forCodeGeneration(true)
				.select()		
				.apis(RequestHandlerSelectors.basePackage("com.hector.desafioCoopeuch.rest"))
				.paths(Predicates.not(PathSelectors.regex("/error.*"))).build().enableUrlTemplating(true)
				.pathMapping("/")
				.genericModelSubstitutes(ResponseEntity.class)
				.useDefaultResponseMessages(false)
				.enableUrlTemplating(false);		
	}
}
