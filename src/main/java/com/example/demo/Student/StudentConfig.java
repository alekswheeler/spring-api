package com.example.demo.Student;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {

	@Bean
	CommandLineRunner commandLineRunner(
		StudentRepository repository
	){
		return args -> {
			Student fulano = new Student(
				"fulano@email.com",
				"fulano de tal",
				LocalDate.of(2006, 3, 4)
			);
			Student paulo = new Student(
				"paulo@email.com",
				"paulo afonso",
				LocalDate.of(2006, 3, 4)
			);
			repository.saveAll(
				List.of(
					fulano,
					paulo
				)
			);
		};
	}
}
