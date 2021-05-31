package javaProject.tastyFoodie.react.models;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Contacts")
public class Contact {
    @Id
    private String id;
    private String name;
    private String email;
    private String country;
    private String city;
    private String gender;
    private String description;
    

    public Contact(String name, String email, String country, String city, String gender, String description){
        this.name = name;
        this.email = email;
        this.country = country;
        this.city = city;
        this.gender = gender;
        this.description = description;
    }

    public String getId(){
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }
    
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
