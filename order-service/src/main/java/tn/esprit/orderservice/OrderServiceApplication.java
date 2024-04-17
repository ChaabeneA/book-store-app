package tn.esprit.orderservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import tn.esprit.orderservice.entity.Order;
import tn.esprit.orderservice.repository.OrderRepository;

@SpringBootApplication
@EnableFeignClients
public class OrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(OrderRepository orderRepository){
        return args -> {
            Order order1=Order.builder().customerId(1L).price(93.00).adress("93 rue ibn sina").quantity(5).build();
            orderRepository.save(order1);
            Order order2=Order.builder().customerId(2L).price(100.00).adress("tunis").quantity(10).build();
            orderRepository.save(order2);
        };
    }

}
