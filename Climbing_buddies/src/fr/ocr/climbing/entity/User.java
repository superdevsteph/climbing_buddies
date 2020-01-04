package fr.ocr.climbing.entity;


import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "tb_user")
public class User implements Serializable {
 
   private static final long serialVersionUID = -7893237204476214050L;
   private Long id;
   private String name;
   private String email;
   private String username;
   private String password;
  
   private String cotation;

  	   
			public User() {
			}

		

		
   
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY )
   @Column(name = "user_id", length = 50, nullable = false)
   public Long getId() {
       return id;
   }
 
   public void setId(Long id) {
       this.id = id;
   }
 
   @Column(name = "user_name", unique = true, length = 50, nullable = false)
   public String getName() {
       return name;
   }
 
   public void setName(String name) {
       this.name = name;
   }
 
   @Column(name = "user_username", unique = true, length = 50, nullable = false)
   public String getUsername() {
       return username;
   }
 
   public void setUsername(String username) {
       this.username = username;
   }
 
   @Column(name = "user_password", length = 50, nullable = false)
   public String getPassword() {
       return password;
   }
 
   public void setPassword(String password) {
       this.password = password;
   }
   

   
   @Column(name = "user_email", length = 50, nullable = false)
   public String getEmail() {
       return email;
   }
 
   public void setEmail(String email) {
       this.email = email;
   }
 
   @Column(name = "user_cotation", length = 255, nullable = false)
   public String getCotation() {
       return cotation;
   }
 
   public void setCotation(String cotation) {
       this.cotation = cotation;
   }


   
	}




	