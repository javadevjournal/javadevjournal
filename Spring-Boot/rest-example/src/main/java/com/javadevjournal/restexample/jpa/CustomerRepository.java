package com.javadevjournal.restexample.jpa;

import com.javadevjournal.restexample.data.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer,Long> {
}
