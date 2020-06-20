package com.research;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 
 * @author majid
 *
 */
@SpringBootApplication
@EntityScan(basePackages = "com.research.entity")
@EnableJpaRepositories(basePackages = "com.research.repository")
@EnableTransactionManagement
public class LoadTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoadTestApplication.class, args);
	}

}
