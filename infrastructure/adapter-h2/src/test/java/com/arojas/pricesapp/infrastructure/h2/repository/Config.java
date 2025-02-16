package com.arojas.pricesapp.infrastructure.h2.repository;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootConfiguration
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages={"com.arojas.pricesapp.infrastructure.h2.repository"})
@EntityScan(basePackages={"com.arojas.pricesapp.infrastructure.h2.entity"})
public class Config {
}
