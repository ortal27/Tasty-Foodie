package javaProject.tastyFoodie.react.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javaProject.tastyFoodie.react.models.Order;
import javaProject.tastyFoodie.react.models.User;
import javaProject.tastyFoodie.react.repositories.OrderRepository;
import javaProject.tastyFoodie.react.repositories.UserRepository;
import javaProject.tastyFoodie.react.services.OrderService;

@CrossOrigin
@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderService orderService;
    @Autowired 
    UserRepository userRepository;

    // api:  putOrder

    @PostMapping
    public void saveOrder(@RequestHeader(value="token") String token ,@RequestBody Order order) {
        User user = userRepository.findByUserToken(token);
        String userId = user.getId();
        order.setUserId(userId);
        
        orderRepository.save(order);
    }


    @GetMapping("/userOrders")
    public List<Order> getOrders(@RequestHeader(value="token") String token)throws Exception {
        if(token == null){
            throw new Exception("token is not pass");
        }
        User user = userRepository.findByUserToken(token);
        if(user == null){
             throw new Exception("No such user."); 
        }
        return orderService.getAllOrders(user.getId());
    }
}
