package tn.esprit.orderservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.orderservice.clients.CustomerRestClient;
import tn.esprit.orderservice.entity.Order;
import tn.esprit.orderservice.models.Customer;
import tn.esprit.orderservice.repository.OrderRepository;

import java.util.List;
@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private OrderRepository orderRepository;
    private CustomerRestClient customerRestClient;

    public OrderController(OrderRepository orderRepository,CustomerRestClient customerRestClient) {
        this.orderRepository = orderRepository;
        this.customerRestClient=customerRestClient;
    }
    @GetMapping("/all")
    public List<Order> orderList(){
        return orderRepository.findAll();
    }
    @GetMapping("/single/{id}")
    public Order orderById(@PathVariable String id)
    {
        Order order=orderRepository.findById(id).orElse(null);
        Customer customer = customerRestClient.findCustomerById(order.getCustomerId());
        order.setCustomer(customer);
        return order;
    }

}
