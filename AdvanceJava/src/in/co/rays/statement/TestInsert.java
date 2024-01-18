package in.co.rays.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestInsert {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/marksheet", "root", "root");

		Statement stmt = conn.createStatement();
		stmt.executeUpdate("insert into marksheet values(112,'dhruv','english',96,121021216)");

		System.out.println("inserted 1");

	}
}
