package com.dh.cleanodonto.cleanodonto.config;

//essa class é a configuração da API / SpringDoc(configuração da documentacao)

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {


    //METODO PADRÃO NECESSÁRIO PARA INICIALIZAR
    @Bean
    public OpenAPI openApi() {

        return new OpenAPI()
                .info(new Info()
                        .title("CLEAN ODONTO")
                        .description("Spring Boot REST API para escritório odontologico")
                        .version("1.0.0"));
    }

}
