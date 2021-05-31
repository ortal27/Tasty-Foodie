package javaProject.tastyFoodie.react.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javaProject.tastyFoodie.react.models.Order;
import javaProject.tastyFoodie.react.repositories.OrderRepository;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public List<Order> getAllOrders(String userId){
        List<Order> res = new ArrayList<Order>();
        res = orderRepository.findByUserId(userId);
    
        return res;
    }

    
}
