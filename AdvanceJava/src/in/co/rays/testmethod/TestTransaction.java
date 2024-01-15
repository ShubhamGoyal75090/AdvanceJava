package in.co.rays.testmethod;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestTransaction {

	public static void main(String[] args) throws Exception {

		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance11", "root", "root");
			conn.setAutoCommit(false);

			Statement stmt = conn.createStatement();
			int i = stmt.executeUpdate("insert into emp values(14 ,'saket', 23000, 1)");
			i = stmt.executeUpdate("insert into emp values(16 ,'saket', 23000, 1)");
			i = stmt.executeUpdate("insert into emp values(17 ,'saket', 23000, 1)");

			System.out.println("Data Inserted =" + i);
			conn.commit();
			conn.close();
			

		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
			
		}
		

	}

}
