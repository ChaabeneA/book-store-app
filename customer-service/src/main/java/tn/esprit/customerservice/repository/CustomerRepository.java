package tn.esprit.customerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import tn.esprit.customerservice.entity.Customer;
@RepositoryRestResource
public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
