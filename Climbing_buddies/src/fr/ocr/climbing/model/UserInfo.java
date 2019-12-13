package fr.ocr.climbing.model;

public class UserInfo {
 
    private String id;
    private String name;
    private String email;
 
    private String login;
    private String password;
    private String cotation;
    
 
    public UserInfo() {
 
    }
 
    // Do not change this constructor,
    // it is used in the Hibernate Query
    public UserInfo(String id, String name, String email, String login, String password, String cotation) {
        this.id = id;
        this.name = name;
        this.email = email;
 
        this.login = login;
        this.password = password;
        this.cotation = cotation;
      
    }
 
   
 
    public String getId() {
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
 
    public String getLogin() {
        return login;
    }
 
    public void setLogin(String login) {
        this.login = login;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
 
    public String getCotation() {
        return cotation;
    }
 
    public void setCotation(String cotation) {
        this.cotation = cotation;
    }

 
}