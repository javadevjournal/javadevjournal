package com.mongo.springbootmongodb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/template")
public class EmployeeEndpointUsingTemplate {
	private final Logger logger = LoggerFactory.getLogger(getClass());

	private final MongoTemplate mongoTemplate;

	public EmployeeEndpointUsingTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<EmployeeModel> getAllUsers() {
		logger.info("Getting all Employees.");
		return mongoTemplate.findAll(EmployeeModel.class);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public EmployeeModel getEmployee(@PathVariable long id) {
		logger.info("Getting Employee with ID: {}.", id);
		EmployeeModel employeeModel = mongoTemplate.findById(id,EmployeeModel.class);
		return employeeModel;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public EmployeeModel add(@RequestBody EmployeeModel employeeModel) {
		logger.info("Saving Employee.");
		return mongoTemplate.save(employeeModel);
	}
}
