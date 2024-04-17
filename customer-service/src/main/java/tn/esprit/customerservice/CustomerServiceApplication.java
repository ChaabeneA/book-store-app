package tn.esprit.customerservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tn.esprit.customerservice.entity.Customer;
import tn.esprit.customerservice.repository.CustomerRepository;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
        return args -> {
            Customer customer1=Customer.builder().firstName("nidhal").lastName("mtir").email("nmtr@outlouk.com").build();
            Customer customer2=Customer.builder().firstName("amira").lastName("chaabene").email("amrachbne@outlouk.com").build();
            customerRepository.save(customer1);
            customerRepository.save(customer2);
        };
    }
}
