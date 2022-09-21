package com.javadevjournal;

import com.javadevjournal.data.Customer;

import java.util.*;

public class CustomerService {

    public static void main(String[] args) {

        sortByAge();
        sortByFirstAndSecondName();
        sortInReverseOrder();
    }

    private static void sortInReverseOrder(){
        List<Customer> customerList = getCustomers();
        Comparator<Customer> customerComparator = Comparator.comparing(e-> e.getAge());
        customerList.sort(customerComparator.reversed());
        customerList.forEach(System.out::println);
    }

    private static void sortByFirstAndSecondName(){
        List<Customer> customers = getCustomers();

        //Let's get the comparator for sorting
        Comparator<Customer> comparator = Comparator.comparing(Customer::getFirstName)
                .thenComparing(Customer::getLastName);

        customers.sort(comparator);

        //output
        customers.forEach(System.out::println);
    }

    private static void sortByAge(){
        List<Customer> customers = getCustomers();
        customers.sort(Comparator.comparing(Customer::getAge));
        //customers.forEach(System.out::println);

        //option 2
        List<Customer> customers1 = getCustomers();
        customers1.sort(Comparator.comparing(e->e.getAge()));
        customers1.forEach(System.out::println);

        //option 3 if we know the type
        customers.sort(Comparator.comparingInt(Customer::getAge));

        //pure lambda expression
        Collections.sort(customers, (c1, c2) -> c1.getAge() - c2.getAge()); //we careful when using this as it can cause overflow
    }

    private static List<Customer> getCustomers(){

        List<Customer> customers = new ArrayList();

        customers.add(Customer.builder()
                .firstName("Robert").lastName("Hickle")
                .age(62).email("abc@demo1.com")
                .build());

        customers.add(Customer.builder()
                .firstName("Sandra").lastName("Hadleigh")
                .age(21).email("Sandra@demo.com")
                .build());

        customers.add(Customer.builder()
                .firstName("Miller").lastName("Gerty")
                .age(41).email("miller@demo.com")
                .build());

        customers.add(Customer.builder()
                .firstName("Milton").lastName("Arnison")
                .age(30).email("arnison@demo.com")
                .build());

        customers.add(Customer.builder()
                .firstName("Crissy").lastName("Finch")
                .age(35).email("crissy@demo.com")
                .build());

        return customers;
    }
}
