package net.cirou.calculator.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SQLiteJDBCDriverConnection {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SQLiteJDBCDriverConnection.class);
	
	/**
	 * Connect to a sample database
	 */
	public void connect() {
		
		Connection conn = null;
		
		try {
			// db parameters
			String url = "jdbc:sqlite:calculator.db";
			
			conn = DriverManager.getConnection(url);
			LOGGER.info("Connection to SQLite has been established.");

		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
		} finally {
			
			try {
				if (conn != null) {
					conn.close();
				}
				
			} catch (SQLException ex) {
				LOGGER.error(ex.getMessage());
			}
		}
	}

}