package org.naresh.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import static springfox.documentation.builders.PathSelectors.regex;
import springfox.documentation.service.Contact;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan("org.naresh")
@EnableAutoConfiguration

public class ProductApp {

	public static void main(String[] args){
		SpringApplication.run(ProductApp.class, args);
	}
	
	@Bean
	public Docket apiNews(){
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("Products")
				.apiInfo(apiInfo())
				.select()
				.paths(regex("/.*"))
				.build();	
		
	}

	private ApiInfo apiInfo() {
		
		return new ApiInfoBuilder()
				.title("Spring Rest API Sample with Swaggger 2.0")
				.description("Spring Rest API example with Swaggger 2.0")
				.contact(new Contact("Naresh Dasari", null, "nareshdasari@outlook.com"))
				.license("License Naresh Dasari")
				.version("1.0")	
				.build();
	}
}
