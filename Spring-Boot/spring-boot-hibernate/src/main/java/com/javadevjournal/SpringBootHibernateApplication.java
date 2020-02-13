package com.javadevjournal;

import com.javadevjournal.data.Customer;
import com.javadevjournal.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringBootHibernateApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringBootHibernateApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringBootHibernateApplication.class, args);
	}

	/*@Bean
	public CommandLineRunner demo(CustomerRepository repository) {
		return (args) -> {

			repository.save(new Customer("Umesh", "Awasthi","email@test.com"));
			repository.save(new Customer("David", "Dobrik", "email1@test.com"));
			repository.save(new Customer("Robert", "Hickle","r.k@email.com"));
			repository.save(new Customer("Edgar", "Smith","edgar@email.com"));

			// fetch all customers

			for (Customer customer : repository.findAll()) {
				log.info(customer.toString());
			}
		};
	}*/
}
