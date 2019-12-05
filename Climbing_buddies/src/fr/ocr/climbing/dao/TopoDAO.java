package fr.ocr.climbing.dao;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import fr.ocr.climbing.business.Topo;

public class TopoDAO extends DAOContext {

	public static int getTopoCount() {
		try ( Connection connection = DriverManager.getConnection( dbURL, dbLogin, dbPassword ) ){

			String strSql = "SELECT count(topo_id) FROM tb_topo";
			try ( Statement statement  = connection.createStatement() ) {
				try ( ResultSet resultSet = statement.executeQuery( strSql ) ) {
					resultSet.next();
					return resultSet.getInt( 1 );
				}
			}
			
		} catch ( Exception exception ) {
			
			throw new RuntimeException( exception );
			
		}
	}
	
	public static Topo getTopoById( int topo_id ) {
		try ( Connection connection = DriverManager.getConnection( dbURL, dbLogin, dbPassword ) ){
			System.out.println( "connection to the database" );
			String strSql = "SELECT * FROM tb_topo WHERE topo_id=?";
			try ( PreparedStatement statement  = connection.prepareStatement( strSql ) ) {
				statement.setInt( 1, topo_id );
				try ( ResultSet resultSet = statement.executeQuery() ) {
					resultSet.next();
					return new Topo(
							resultSet.getInt( "topo_id" ),
							resultSet.getString( "topo_nom" ),
							resultSet.getString( "topo_region" ),
							resultSet.getInt( "topo_nbSites" ),
							resultSet.getInt( "topo_nbSecteurs" ),
							resultSet.getInt( "topo_nbVoies" ),
							resultSet.getBoolean( "topo_disponible" ),
							resultSet.getString( "topo_description" ),
							resultSet.getInt( "topo_user_fk_id" )
						
					);
				}
			}
			
		} catch ( Exception exception ) {
			
			throw new RuntimeException( exception );
			
		}
	}
	
	
	public static void updateTopo( Topo topo ) {
		try ( Connection connection = DriverManager.getConnection( dbURL, dbLogin, dbPassword ) ){

			String strSql = "UPDATE tb_topo SET nom=?, region=?, nbSites=?, nbSecteurs=?, nbVoies=?, disponible=?, description=?, userFkId=? WHERE id=?";
			try ( PreparedStatement statement  = connection.prepareStatement( strSql ) ) {
				statement.setString( 1, topo.getTopo_nom() );
				statement.setString( 2, topo.getTopo_region() );
				statement.setInt( 3, topo.getTopo_nbSites() );
				statement.setInt( 4, topo.getTopo_nbSecteurs() );
				statement.setInt( 5, topo.getTopo_nbVoies() );
				statement.setBoolean( 6, topo.isTopo_disponible() );
				statement.setString( 7, topo.getTopo_description() );
				statement.setInt( 8, topo.getTopo_user_fk_id() );
				statement.setInt( 9, topo.getTopo_id() );
		
				statement.executeUpdate();
			}
			
		} catch ( Exception exception ) {
			
			throw new RuntimeException( exception );
			
		}
	}
	
}
