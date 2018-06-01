package com.spring.mongo.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.mongo.example.dao.EmployeeRepository;
import com.spring.mongo.example.model.Employee;

@SpringBootApplication
@RestController("/EMS")
public class SpringMongoApplication {

	@Autowired
	private EmployeeRepository repository;

	@PostMapping("/save/{id}/{name}/{dept}/{salary}")
	public String save(@PathVariable int id, @PathVariable String name, @PathVariable String dept,
			@PathVariable double salary) {
		Employee employee = new Employee(id, name, dept, salary);
		repository.save(employee);
		return "Employee saved successfully...";
	}

	@GetMapping("/getAll")
	public List<Employee> getAll() {
		return repository.findAll();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringMongoApplication.class, args);
	}
}
