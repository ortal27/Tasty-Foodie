package javaProject.tastyFoodie.react.repositories;

import javaProject.tastyFoodie.react.models.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContactRepository extends MongoRepository<Contact, String> {
    
}
