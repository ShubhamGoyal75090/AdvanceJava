package in.co.rays.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import in.co.rays.util.JDBCDataSource;

public class TestJDBC {

	public static void main(String[] args) throws Exception {

		for (int i = 1; i <= 50; i++) {

			System.out.println("connection = " + i);

			testGet();

		}

	}

	private static void testGet() throws Exception {
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("select * from marksheet");
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {

			System.out.print(rs.getInt(1));
			System.out.print("\t "+rs.getString(2));
			System.out.print("\t "+rs.getString(3));
			System.out.print("\t "+rs.getInt(4));
			System.out.println("\t "+rs.getInt(5));

		}

	}

}
