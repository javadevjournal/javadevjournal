package com.javadevjournal.jpa.repository;

import com.javadevjournal.jpa.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <p></p>Our custom repository to provide custom implimentation for the Customer entity.
 * For this have not provided any custom method and spring JPA will automatically
 * provide the basic CURD operations using the @JpaRepository.</p>
 */
@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
    CustomerEntity findByEmail(String email);
}
