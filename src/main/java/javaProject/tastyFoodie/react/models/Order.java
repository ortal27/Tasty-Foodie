package javaProject.tastyFoodie.react.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Orders")
public class Order {
    @Id
    String id;
    String name;
    String phoneNum;
    String address;
    String creditCard;
    String userId;

    public Order(String name, String phoneNum, String address, String creditCard, String userId){
        this.name =  name;
        this.phoneNum = phoneNum;
        this.address = address;
        this.creditCard = creditCard;
        this.userId = userId;
    }

    public String getId(){
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getPhoneNum(){
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum){
        this.phoneNum = phoneNum;
    }
    
    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }


    public String getCreditCard(){
        return creditCard;
    }

    public void setCreditCard(String creditCard){
        this.creditCard = creditCard;
    }

    public String getUserId(){
        return userId;
    }
    
    public void setUserId(String userId){
        this.userId = userId;
    }
}

