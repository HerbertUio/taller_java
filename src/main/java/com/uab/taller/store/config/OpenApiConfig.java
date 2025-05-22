package com.uab.taller.store.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI openAPI (){
        return new OpenAPI().info(apiInfo());

    }

    private Info apiInfo() {
        return new Info()
                .title("Mamitas Club")
                .description("es una aplicacion para probar lobas")
                .version("0.0.1")
                .license( new License()
                        .name("Apache 2.0")
                        .url("https://xvideos.com"))
                .contact(new Contact().name("Ing. Alex Marin").email("AlexMarinMex@gmail.com"));
    }


}
