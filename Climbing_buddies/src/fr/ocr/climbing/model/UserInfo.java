package fr.ocr.climbing.model;

public class UserInfo {
 
    private Long id;
    private String name;
    private String email;
 
    private String username;
    private String password;
    private String passwordConfirm;
    private String cotation;
    
 
    public UserInfo() {
 
    }
 



	// Do not change this constructor,
    // it is used in the Hibernate Query
    public UserInfo(Long id, String name, String email, String username, String password, String cotation) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.cotation = cotation;
        
    }
 


	public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
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
 
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
	public String getPasswordConfirm() {
		
		return passwordConfirm;
	}
     
	  public void setPasswordConfirm(String passwordConfirm) {
	        this.passwordConfirm = passwordConfirm;
	    }
	  
    public String getCotation() {
        return cotation;
    }
 
    public void setCotation(String cotation) {
        this.cotation = cotation;
    }

   

}