package com.dh.cleanodonto.cleanodonto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication

public class CleanodontoApplication {
	private static Logger logger = LoggerFactory.getLogger(CleanodontoApplication.class);

	public static void main(String[] args) {
		logger.info("Iniciando Aplicação");
		SpringApplication.run(CleanodontoApplication.class, args);
		logger.info("Aplicação Iniciada com sucesso!");
	}

}
