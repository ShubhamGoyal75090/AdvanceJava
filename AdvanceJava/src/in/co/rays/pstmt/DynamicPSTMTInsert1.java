package in.co.rays.pstmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class DynamicPSTMTInsert1 {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/marksheet","root","root");
			PreparedStatement ps=conn.prepareStatement("insert into marksheet values(?,?,?,?,?)");	
		ps.setInt(1, 12);
		ps.setString(2, "amit");
		ps.setString(3, "bansal");
		ps.setInt(4, 10);
		ps.setInt(5, 100);
		int i = ps.executeUpdate();
		
		System.out.println(i);
		 
		 
	}

}
