package javaProject.tastyFoodie.react.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Items")
public class Item {
    @Id
    private String id;
    private String name;
    private String type;
    private String imageUrl;
    private String description;
    private String price;
    
    public Item() {

    }

    public Item(String name, String type, String imageUrl, String description, String price){
        this.name = name;
        this.type =type;
        this.imageUrl = imageUrl;
        this.description = description;
        this.price = price;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String ImageUrl) {
        this.imageUrl = ImageUrl;
    }

    public String getDescription(){
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getPrice(){
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }

}