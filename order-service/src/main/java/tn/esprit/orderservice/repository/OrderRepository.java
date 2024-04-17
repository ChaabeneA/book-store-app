package tn.esprit.orderservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import tn.esprit.orderservice.entity.Order;

@RepositoryRestResource
public interface OrderRepository extends MongoRepository<Order,String> {

}
