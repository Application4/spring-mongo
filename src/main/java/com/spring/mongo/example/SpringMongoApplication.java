package com.spring.mongo.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.spring.mongo.example.dao.EmployeeRepository;
import com.spring.mongo.example.model.Employee;

@SpringBootApplication
public class SpringMongoApplication {

	@Autowired
	private EmployeeRepository repository;

	@GetMapping("/save")
	public String save(@RequestBody Employee employee) {
		repository.save(employee);
		return "Employee saved successfully with id "+employee.getId();
	}

	@GetMapping("/getAll")
	public List<Employee> getAll() {
		return repository.findAll();
	}

	
	@GetMapping("/test")
	public String test() {
		return "Deployed...";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringMongoApplication.class, args);
	}
}
