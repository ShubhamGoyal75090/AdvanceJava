package in.co.rays.pstmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TestPreparestmt1 {
	
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/marksheet", "root", "root");
		
		PreparedStatement pstmt = conn.prepareStatement("insert into marksheet values(?,?,?,?,?)");
		
		pstmt.setInt(1, 156);
		pstmt.setString(2, "radha");
		pstmt.setString(3, "english");
		pstmt.setInt(4, 35);
		pstmt.setInt(5, 121021289);
		
		pstmt.executeUpdate();
		System.out.println("data successfully....!!!");
		
	}

}
