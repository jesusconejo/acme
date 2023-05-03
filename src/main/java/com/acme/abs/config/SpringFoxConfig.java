package com.acme.abs.config;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SpringFoxConfig {

    @Value("${info.build-timestamp}")
    private String buildTime;

    private ApiInfo apiInfo() {
        return new ApiInfo("Api Rest Cache para Sesión BAW.", "Servicios Cache para Sesión BAW.", buildTime,
                "Terms of service", new Contact("CACHE", "SSOC", "mail@ssoc.com"), "License of API", "API license URL",
                Collections.emptyList());

    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }
}
