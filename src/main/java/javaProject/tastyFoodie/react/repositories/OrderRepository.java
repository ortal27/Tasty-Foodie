package javaProject.tastyFoodie.react.repositories;

import javaProject.tastyFoodie.react.models.Order;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String>{
    List<Order> findByUserId(String user);
}
