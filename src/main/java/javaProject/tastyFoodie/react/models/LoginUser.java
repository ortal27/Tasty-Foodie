package javaProject.tastyFoodie.react.models;

public class LoginUser {
    String email;
    String password;

    public LoginUser(){}

    public LoginUser(String email, String password){
        this.email = email;
        this.password = password;
    }

    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return password;
    }


}
