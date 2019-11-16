package com.zzmath.employee1.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.zzmath.employee1.entities.Employee;
import com.zzmath.employee1.repositories.EmployeeRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Employee e1 = new Employee(1L, "Leia Organa", 2000.00, 25, "");
		Employee e2 = new Employee(2L, "Anakin Skywalker", 1000.00, 50, "");
		Employee e3 = new Employee(3L, "Obi-Wan Kenobi", 1500.00, 75, "");
	
		employeeRepository.saveAll(Arrays.asList(e1, e2, e3));
		
	}
}
