package com.project.alumiar;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.project.alumiar.services.StorageService;
import com.project.alumiar.storage.StorageProperties;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class AlumiarApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(AlumiarApplication.class, args);
	}
	
    @Bean
    CommandLineRunner init(StorageService storageService) {
        return (args) -> {
            storageService.init();
            //storageService.deleteAll();
        };
    }	
}
