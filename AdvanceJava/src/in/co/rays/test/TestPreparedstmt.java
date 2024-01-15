package in.co.rays.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TestPreparedstmt {

	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/marksheet", "root", "root");
		PreparedStatement pstmt = conn.prepareStatement("insert into marksheet values(119,'shyam','english',46,121021256)");
		
	pstmt.executeUpdate();
	
		System.out.println("insert successfully...!!!");
	}
}
