package com.javadevjournal.service;

import com.javadevjournal.data.Customer;
import com.javadevjournal.dto.CustomerData;
import com.javadevjournal.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service("customerService")
public class DefaultCustomerService implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    /**
     * Create a customer based on the data sent to the service class.
     * @param customer
     * @return DTO representation of the customer
     */
    @Override
    public CustomerData saveCustomer(CustomerData customer) {
        Customer customerModel = populateCustomerEntity(customer);
        return populateCustomerData(customerRepository.save(customerModel));
    }

    /**
     * Delete customer based on the customer ID.We can also use other option to delete customer
     * based on the entoty (passing JPA entity class as method parameter)
     * @param customerId
     * @return boolean flag indicating the request status
     */
    @Override
    public boolean deleteCustomer(Long customerId) {
        customerRepository.deleteById(customerId);
        return true;
    }

    /**
     * Method to return list of all the available customers in the system.This is a simple
     * implementation but you might want to use pagination in the real world example.
     * @return list of customer
     */
    @Override
    public List<CustomerData> getAllCustomers() {
        List<CustomerData> customers = new ArrayList<>();
        List<Customer> customerList = customerRepository.findAll();
        customerList.forEach(customer -> {
            customers.add(populateCustomerData(customer));
        });
        return customers;
    }

    /**
     * Get customer by ID.The service will send the customer data else will throw the exception.
     * @param customerId
     * @return CustomerData
     */
    @Override
    public CustomerData getCustomerById(Long customerId) {
        return populateCustomerData( customerRepository.findById(customerId).orElseThrow(() -> new EntityNotFoundException("Customer not found")));
    }

    /**
     * Internal method to convert Customer JPA entity to the DTO object
     * for frontend data
     * @param customer
     * @return CustomerData
     */
    private CustomerData populateCustomerData(final Customer customer){
        CustomerData customerData = new CustomerData();
        customerData.setId(customer.getId());
        customerData.setFirstName(customer.getFirstName());
        customerData.setLastName(customer.getLastName());
        customerData.setEmail(customer.getEmail());
        return  customerData;
    }

    /**
     * Method to map the frontend customer object to the JPA customer entity.
     * @param customerData
     * @return Customer
     */
    private Customer populateCustomerEntity(CustomerData customerData){
        Customer customer = new Customer();
        customer.setFirstName(customerData.getFirstName());
        customer.setLastName(customerData.getLastName());
        customer.setEmail(customerData.getEmail());
        return  customer;
    }
}
