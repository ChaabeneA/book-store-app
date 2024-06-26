package tn.esprit.orderservice.clients;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tn.esprit.orderservice.models.Customer;

import java.util.List;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {
    @GetMapping("/api/customers/customer/{id}")
    @CircuitBreaker(name = "customerservice",fallbackMethod = "getDefaultCustomer")
    Customer findCustomerById(@PathVariable Long id);

    @GetMapping("/api/customers/all")
    List<Customer> allCustomers();
    default Customer getDefaultCustomer(Long id,Exception exception)
    {
        Customer customer=new Customer();
        customer.setId(id);
        customer.setFirstName("not available");
        customer.setLastName("not available");
        customer.setEmail("not available");
        return customer;
    }
}
