package javaProject.tastyFoodie.react.repositories;

import javaProject.tastyFoodie.react.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String>{
    User findByEmail(String email);
    User findByUserToken(String userToken);
}