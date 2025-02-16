package com.arojas.pricesapp.springboot.config;

import com.arojas.pricesapp.application.ports.api.PricesAPIService;
import com.arojas.pricesapp.application.ports.spi.PricesPersistence;
import com.arojas.pricesapp.application.service.PricesService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = {"com.arojas.pricesapp"})
@EnableJpaRepositories(basePackages={"com.arojas.pricesapp.infrastructure.h2.repository"})
@EntityScan(basePackages={"com.arojas.pricesapp.infrastructure.h2.entity"})
@EnableTransactionManagement
public class SpringbootRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRestApplication.class, args);
	}	

	@Bean
	PricesAPIService pricesAPIService(PricesPersistence pricePersistance) {
		return new PricesService(pricePersistance);
	}

}
