package javaProject.tastyFoodie.react.repositories;

import javaProject.tastyFoodie.react.models.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemRepository extends MongoRepository<Item, String>{
}