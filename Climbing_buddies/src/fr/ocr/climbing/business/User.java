package fr.ocr.climbing.business;

public class User {

	private int idUser;
	private String login;
	private String password;

	
	
	public User() {
		this( 0, "john", "doe");
	}
	
	public User( int idUser, String login, String password ) {
		this.setIdUser( idUser );
		this.setLogin( login );
		this.setPassword( password );
	
	}
	
	
	public int getIdUser() {
		return idUser;
	}
	
	public void setIdUser(int idUser) {
		this.idUser = idUser;
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
	
	@Override
	public String toString() {
		return "User[idUser=" + idUser + ", login=" + login + ", password=" + password + " ]" ;
	}
	
}
