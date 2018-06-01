package com.spring.mongo.example.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spring.mongo.example.model.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, Integer>{

}
