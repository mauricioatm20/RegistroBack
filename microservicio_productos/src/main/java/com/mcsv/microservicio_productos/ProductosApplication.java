package com.mcsv.microservicio_productos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = "com.mcsv.microservicio_productos.model")
@EnableJpaRepositories(basePackages = "com.mcsv.microservicio_productos.repository")
@SpringBootApplication(scanBasePackages = {"com.mcsv.microservicio_productos.service", "com.mcsv.microservicio_productos.controller"})
public class ProductosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductosApplication.class, args);
	}

}
