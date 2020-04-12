package com.mongo.springbootmongodb;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository  extends MongoRepository<EmployeeModel, Long> {
}
