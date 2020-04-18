package net.interviewDOT.springboot2.springboot2jpacrudexample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

import static com.google.common.collect.Lists.newArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("net.interviewDOT.springboot2.springboot2jpacrudexample"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false)
                .globalResponseMessage(RequestMethod.GET, newArrayList(new ResponseMessageBuilder().code(500)
                                .message("500 message")
                                .build(),
                        new ResponseMessageBuilder().code(403)
                                .message("Forbidden!!!!!")
                                .build()));
    }

    private ApiInfo apiInfo() {
        return new ApiInfo("Subscriber Information Provider", "APIs to provide subscriber details", "1.0", "Terms of service", new Contact("InterviewDOT", "www.interviewdot.in", "info@interviewdot.in"), "License of API", "API license URL", Collections.emptyList());
    }
}

/**
 * @EnableSwagger2 enables SpringFox support for Swagger 2.
 * DocumentationType.SWAGGER_2 tells the Docket bean that we are using version 2 of Swagger specification.
 * select() creates a builder, which is used to define which controllers and which of their methods should be included in the generated documentation.
 * apis() defines the classes (controller and model classes) to be included. Here we are including all of them, but you can limit them by a base package, class annotations and more.
 * paths() allow you to define which controller's methods should be included based on their path mappings. We are now including all of them but you can limit it using regex and more.
 *
 * http://localhost:8080/v2/api-docs - API Document Generated in JSON format.
 * http://localhost:8080/swagger-ui.html#/
 */
