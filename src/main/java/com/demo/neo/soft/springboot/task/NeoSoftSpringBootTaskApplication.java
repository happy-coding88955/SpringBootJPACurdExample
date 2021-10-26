package com.demo.neo.soft.springboot.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.demo.neo.soft.springboot.task.service.impl.AuditorAwareImpl;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef="auditorAware")
public class NeoSoftSpringBootTaskApplication {

	@Bean
	public AuditorAware<String> auditorAware() {
		return new AuditorAwareImpl();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(NeoSoftSpringBootTaskApplication.class, args);
	}

}
