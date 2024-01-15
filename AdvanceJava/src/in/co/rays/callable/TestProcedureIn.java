package in.co.rays.callable;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class TestProcedureIn {
	
	public static void main(String[] args)throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance11", "root", "root");
		CallableStatement callstmt = conn.prepareCall("{CALL empIN(?)}");
		
		callstmt.setInt(1, 10);
		callstmt.execute();
		
		ResultSet rs = callstmt.getResultSet();
		
		while (rs.next()) {
			
			System.out.print("\t "+rs.getInt(1));
			System.out.print("\t "+rs.getString(2));
			System.out.print("\t "+rs.getInt(3));
			System.out.println("\t "+rs.getInt(4));
		}
	}

}
