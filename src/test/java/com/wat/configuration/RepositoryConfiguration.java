package com.wat.configuration;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
/**
 * Created by pedrocruz on 21/05/2018.
 */

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.wat.domain"})
@EnableJpaRepositories(basePackages = {"com.wat.repositories"})
@EnableTransactionManagement
public class RepositoryConfiguration {
}