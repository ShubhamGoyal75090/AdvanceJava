package in.co.rays.callable;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class TestStoreFunction {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance11", "root", "root");
		CallableStatement callstmt = conn.prepareCall("{ ? = CALL square (?)}");
		callstmt.setInt(2, 12);
		callstmt.registerOutParameter(1, Types.INTEGER);
		callstmt.execute();

		System.out.println("Square = " + callstmt.getInt(1));

	}

}
