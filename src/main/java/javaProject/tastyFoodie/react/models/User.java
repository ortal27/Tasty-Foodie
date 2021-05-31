package javaProject.tastyFoodie.react.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Users")
public class User {
    @Id
    private String id;
    private String username;
    private String lastName;
    private String email;
    private String password;
    private Boolean admin;
    private String userToken ;
    
    public User() {

    }

    public User(String name, String lastName, String email, String password, Boolean admin, String userToken){
        this.username = name;
        this.lastName =lastName;
        this.email = email;
        this.password = password;
        this.admin = admin;
        this.userToken = userToken;
    }

    public String getId(){
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.username;
    }

    public void setName(String name) {
        this.username = name;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword(){
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean isAdmin(){
        return this.admin;
    }

    public void setAdmin(Boolean admin){
        this.admin = admin;
    }

    public String getUserToken(){
        return this.userToken;
    }

    public void setUserToken(String token){
        this.userToken = token;
    }
}