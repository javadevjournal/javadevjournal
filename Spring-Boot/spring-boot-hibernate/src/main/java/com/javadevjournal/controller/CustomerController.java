package com.javadevjournal.controller;

import com.javadevjournal.dto.CustomerData;
import com.javadevjournal.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Resource(name = "customerService")
    private CustomerService customerService;

    /**
     * <p>Get all customer data in the system.For production system you many want to use
     * pagination.</p>
     * @return List<CustomerData>
     */
    @GetMapping
    public List<CustomerData> getCustomers(){
        return customerService.getAllCustomers();
    }

    /**
     * Method to get the customer data based on the ID.
     * @param id
     * @return CustomerData
     */
    @GetMapping("/customer/{id}")
    public CustomerData getCustomer(@PathVariable Long id){
        return customerService.getCustomerById(id);
    }

    /**
     * Post request to create customer information int the system.
     * @param customerData
     * @return
     */
    @PostMapping("/customer")
    public CustomerData saveCustomer(final @RequestBody CustomerData customerData){
        return customerService.saveCustomer(customerData);
    }

    /**
     * Delete customer from the system based on the ID. The method mapping is similar to the getCustomer with difference of
     * @DeleteMapping and @GetMapping
     * @param id
     * @return
     */
    @DeleteMapping("/customer/{id}")
    public Boolean deleteCustomer(@PathVariable Long id){
        return customerService.deleteCustomer(id);
    }

}
