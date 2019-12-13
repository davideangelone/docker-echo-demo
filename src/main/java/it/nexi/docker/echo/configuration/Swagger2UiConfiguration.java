package it.nexi.docker.echo.configuration;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.google.common.base.Predicates;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2UiConfiguration implements WebMvcConfigurer {
    @Bean
    public Docket api() {
        // @formatter:off
        //Register the controllers to swagger
        //Also it is configuring the Swagger Docket
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))
                // .paths(PathSelectors.any())
                // .paths(PathSelectors.ant("/swagger2-demo"))
                .build()
        		.apiInfo(apiInfo());
        // @formatter:on
    }
    
    private ApiInfo apiInfo() {
        return new ApiInfo(
          "My REST API", 
          "Some custom description of API.", 
          "API TOS", 
          "Terms of service", 
          new Contact("John Doe", "www.example.com", "myeaddress@company.com"), 
          "License of API", "API license URL", Collections.emptyList());
    }
 
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) 
    {
        //enabling swagger-ui part for visual documentation
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}