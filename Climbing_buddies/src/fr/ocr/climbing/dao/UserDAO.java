package fr.ocr.climbing.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import fr.ocr.climbing.business.User;

public class UserDAO extends DAOContext {

	public static User isValidLogin( String login, String password ) {
		try ( Connection connection = DriverManager.getConnection( dbURL, dbLogin, dbPassword ) ) {
			
			String strSql = "SELECT * FROM tb_user WHERE user_login=? AND user_password=?";
			
			try ( PreparedStatement statement  = connection.prepareStatement( strSql ) ) {
				statement.setString( 1, login );
				statement.setString( 2, password );
				
				try ( ResultSet resultSet = statement.executeQuery() ) {
					
					if ( resultSet.next() ) {
						
						return new User(
								resultSet.getInt( "user_id" ),
								resultSet.getString( "user_login" ),
								resultSet.getString( "user_password" )
					);
						
					} else {
						
						return null;
					}
				}
			}
			
		} catch ( Exception exception ) {
			
			throw new RuntimeException( exception );
		}
	}
	
}
