package com.spring.api.demo3.util;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfigUtil {

	/*
	 * @Bean public Docket swaggerConfig() { return new
	 * Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().paths(
	 * postPaths()).build(); }
	 * 
	 * private Predicate<String> postPaths() { // return or(regex("/api/posts.*"),
	 * regex("/api/javainuse.*")); return null; }
	 * 
	 * private ApiInfo apiInfo() { return new
	 * ApiInfoBuilder().title("MySpringApp").build(); }
	 * 
	 */

}
