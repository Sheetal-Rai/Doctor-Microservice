package com.Project.Doctor;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DoctorMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoctorMicroserviceApplication.class, args);
		System.out.println("hi doc");
	}
	@Bean
	public ModelMapper modelMapper() {
		
		return new ModelMapper();
		
	}


}
