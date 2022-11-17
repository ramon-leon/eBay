package com.example.eBayLatest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableSwagger2
@EnableCaching
public class EBayLatestApplication {

	public static void main(String[] args) {
		SpringApplication.run(EBayLatestApplication.class, args);
	}

	@Bean
	public Docket swaggerConfig() {

		Contact contact = new Contact(
				"Ramon Leon",
				"https://www.acmedemo.com",
				"ramon@www.acmedemo.com"
		);

		ApiInfo apiInfo = new ApiInfo(
				"Spring Demo (eBay) RESTful Web Service documentation",
				"This pages documents Demo eBay RESTful Web Service endpoints", "1.0",
				"https://www.acmedemo.com/service.html", contact,
				"", "", new ArrayList<>());

		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/ItemsAPI/**"))
				.apis(RequestHandlerSelectors.basePackage("com.example.eBayLatest"))
				.build()
				.apiInfo(apiInfo);
	}


}
