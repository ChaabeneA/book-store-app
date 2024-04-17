package tn.esprit.orderservice.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import tn.esprit.orderservice.models.Customer;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "orders")
public class Order {

    @Id
    private String id;
    private Double price;
    private String adress;
    private Long customerId;
    @Transient
    private Customer customer;
    private Integer quantity;
}
