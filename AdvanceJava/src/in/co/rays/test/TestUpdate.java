package in.co.rays.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestUpdate {
	
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn =	DriverManager.getConnection("jdbc:mysql://localhost:3306/marksheet", "root", "root");
		Statement stmt = conn.createStatement();
	stmt.executeUpdate("update marksheet set id = 14 where id = 101");
	
	System.out.println("update successfully");
	}

}
