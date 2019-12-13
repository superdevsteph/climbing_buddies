package fr.ocr.climbing.entity;


import java.io.Serializable;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name = "tb_user")
public class User implements Serializable {
 
   private static final long serialVersionUID = -7893237204476214050L;
   private String id;
   private String name;
   private String email;
 
   private String login;
   private String password;
   private String cotation;
 
   @Id
   @Column(name = "user_id", length = 50, nullable = false)
   public String getId() {
       return id;
   }
 
   public void setId(String id) {
       this.id = id;
   }
 
   @Column(name = "user_nom", length = 50, nullable = false)
   public String getName() {
       return name;
   }
 
   public void setName(String name) {
       this.name = name;
   }
 
   @Column(name = "user_login", length = 50, nullable = false)
   public String getLogin() {
       return login;
   }
 
   public void setLogin(String login) {
       this.login = login;
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