package com.javadevjournal.customer.repo;

import com.javadevjournal.customer.data.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerModel,Integer> {
}
