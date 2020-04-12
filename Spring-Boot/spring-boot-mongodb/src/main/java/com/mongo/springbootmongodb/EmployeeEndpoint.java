package com.mongo.springbootmongodb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/")
public class EmployeeEndpoint {
	private final Logger logger = LoggerFactory.getLogger(getClass());

	private final EmployeeRepository employeeRepository;

	public EmployeeEndpoint(EmployeeRepository userRepository) {
		this.employeeRepository = userRepository;
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<EmployeeModel> getAllUsers() {
		logger.info("Getting all Employees.");
		return employeeRepository.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public EmployeeModel getEmployee(@PathVariable long id) {
		logger.info("Getting Employee with ID: {}.", id);
		Optional<EmployeeModel> employeeModel = employeeRepository.findById(id);
		return employeeModel.get();
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public EmployeeModel add(@RequestBody EmployeeModel employeeModel) {
		logger.info("Saving Employee.");
		return employeeRepository.save(employeeModel);
	}
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		EmployeeModel model = employeeRepository.findById(id).get();
		logger.info("Deleting Employee.");
		employeeRepository.delete(model);
	}
}

