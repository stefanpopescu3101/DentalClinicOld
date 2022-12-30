package com.example.dentalclinic;

import com.example.dentalclinic.Models.Role;
import com.example.dentalclinic.converters.ClientConverter;
import com.example.dentalclinic.converters.DoctorConverter;
import com.example.dentalclinic.dto.ClientDTO;
import com.example.dentalclinic.dto.DoctorDTO;
import com.example.dentalclinic.dto.TreatmentDTO;
import com.example.dentalclinic.service.ClientService;
import com.example.dentalclinic.service.DoctorService;
import com.example.dentalclinic.service.TreatmentService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class DentalClinicApplication {
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	public static void main(String[] args) {
		SpringApplication.run(DentalClinicApplication.class, args);
	}

	@Bean
	CommandLineRunner run(ClientService clientService, DoctorService doctorService, TreatmentService treatmentService) {
		return args -> {

			Role role1 = new Role(1, "ROLE_USER");
			Role role2 = new Role(2, "ROLE_ADMIN");

			clientService.saveRole(role1);
			clientService.saveRole(role2);

			ClientDTO client1 = new ClientDTO(1, "mari", "123", "Maria", "Zavaranu", "female", "12/03/1990", 123, "m.zavaroanu@gmail.com", true);

			clientService.addClient(client1);

			clientService.addRole(client1.getUsername(), role1.getName());

			DoctorDTO doctor = new DoctorDTO(1, "DR", "Maria", "Zavaranu", "female", "12/03/1990",123 , "m.zavaroanu@gmail.com", new ArrayList<>() );
			doctorService.addDoctor(doctor);
		};
	}
}