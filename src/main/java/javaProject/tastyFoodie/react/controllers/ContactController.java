package javaProject.tastyFoodie.react.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javaProject.tastyFoodie.react.models.Contact;
import javaProject.tastyFoodie.react.repositories.ContactRepository;

@CrossOrigin
@RestController
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    ContactRepository contactRepository;

    @GetMapping
    public List<Contact> getContacts(){
        return contactRepository.findAll();
    }

    @PostMapping
    public Contact saveContact(@RequestBody Contact contact){
        return contactRepository.save(contact);
    }

}