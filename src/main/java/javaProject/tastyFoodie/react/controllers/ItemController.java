package javaProject.tastyFoodie.react.controllers;

import javaProject.tastyFoodie.react.ReadMenuItems;
import javaProject.tastyFoodie.react.models.Item;
import javaProject.tastyFoodie.react.models.User;
import javaProject.tastyFoodie.react.repositories.ItemRepository;
import javaProject.tastyFoodie.react.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.*;


@CrossOrigin
@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    ItemRepository itemRepository;
    @Autowired
    ReadMenuItems readItems;
    @Autowired
    UserRepository userRepository;
    

    @PostMapping
    public Item saveItem(@RequestBody Item item){
        return itemRepository.save(item);
    }

    @GetMapping 
    public List<Item> getAll(){
        readItems.ReadDataFromJson();
        return itemRepository.findAll();
    }

    @GetMapping("/itemId")
    public Item getItem(@RequestParam String itemId, @RequestHeader(value="token") String userToken)throws Exception {
        if(userToken == null){
            throw new Exception("token is not pass");
        }
        User user = userRepository.findByUserToken(userToken);
        if(user == null){
            throw new Exception("User not found");
        }
        else if(!user.isAdmin()){
            throw new Exception("User not an admin");
        }
        if(itemId == null){
            throw new Exception("Item-Id not found");
        }
        Optional<Item> findItem = itemRepository.findById(itemId);
        Item item = findItem.get();
        return item;
    }


    @DeleteMapping("/itemId")
    public ResponseEntity<String> deleteItem(@RequestHeader(value="token") String userToken, 
    @RequestBody String id)
    throws Exception{
        if(userToken == null){
            throw new Exception("token is not pass");
        }
        User user = userRepository.findByUserToken(userToken);
        if(user == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User not found");
        }
        else if(!user.isAdmin()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User not an admin");
        }

        Optional<Item> findItem = itemRepository.findById(id);
        Item item = findItem.get();
        
        itemRepository.delete(item);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("");    
    }

    @PutMapping
    public void updateItem(@RequestHeader(value="token") String userToken, 
    @RequestBody Item item, @RequestParam String itemId)throws Exception{
        if(userToken == null){
            throw new Exception("token is not pass");
        }
        User user = userRepository.findByUserToken(userToken);
        if(user == null){
            throw new Exception("User not found");
        }
        else if(!user.isAdmin()){
            throw new Exception("User not an admin");
        }
        if(itemId == null){
            throw new Exception("no such item");
        }

        Optional<Item> findItem = itemRepository.findById(itemId);
        Item updateItem = findItem.get();
        
        updateItem.setName(item.getName());
        updateItem.setImageUrl(item.getImageUrl());    
        updateItem.setDescription(item.getDescription());
        updateItem.setPrice(item.getPrice());
        itemRepository.save(updateItem);
    }
}