package com.dhcleanodonto.cleanodonto.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;



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



