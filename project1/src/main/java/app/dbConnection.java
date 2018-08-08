package app;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class dbConnection {

	public static void test() throws FileNotFoundException {
		Connection conn = dbConnection.getConnection();
		
		System.out.println(conn);
	}
	
	public static Connection getConnection(){
		
		//InputStream in = null;
		
		try {
			Properties props = new Properties();
			//in = new FileInputStream("../connection.properties");
			//props.load();
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = null;
			
			String endpoint = "jdbc:oracle:thin:@panyarddb.cckjyi9ww0qu.us-east-1.rds.amazonaws.com:1521:ORCL";//props.getProperty("jdbc.url");
			String username = "tim";//props.getProperty("jdbc.username");
			String password = "database";//props.getProperty("jdbc.password");
			
			conn = DriverManager.getConnection(endpoint, username, password);
			return conn;
		}catch(Exception e) {
			System.out.println(e.getClass());
			e.getMessage();
		}finally {
//			try {
//				in.close();
//				System.out.println("unexpected exception");
//			}catch(IOException e) {
//				e.printStackTrace();
//			}
		}
		
		return null;
	}
}
