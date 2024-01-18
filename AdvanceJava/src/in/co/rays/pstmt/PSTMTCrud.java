package in.co.rays.pstmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PSTMTCrud {

	public static void main(String[] args) throws Exception {
		// testAdd(113, "pqr", "maths", 98, 121021296);
		// testUpdate(113, "spr", "physics", 46, 121021297);
		// testRead();
		testDelete(113);
	}

	private static void testAdd(int id, String name, String subject, int marks, int enrollmentNo) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/marksheet", "root", "root");
		PreparedStatement pstmt = conn.prepareStatement("insert into marksheet values(?,?,?,?,?)");

		pstmt.setInt(1, id);
		pstmt.setString(2, name);
		pstmt.setString(3, subject);
		pstmt.setInt(4, marks);
		pstmt.setInt(5, enrollmentNo);
		int i = pstmt.executeUpdate();

		System.out.println("Data inserted =" + i);

	}

	private static void testUpdate(int id, String name, String subject, int marks, int enrollmentNo) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/marksheet", "root", "root");
		PreparedStatement pstmt = conn.prepareStatement(
				"update marksheet set name = ?, subject = ?, marks = ?, enrollment_no = ? where id = ? ");
		pstmt.setString(1, name);
		pstmt.setString(2, subject);
		pstmt.setInt(3, marks);
		pstmt.setInt(4, enrollmentNo);
		pstmt.setInt(5, id);
		int i = pstmt.executeUpdate();

		System.out.println("Data Updated =" + i);
	}

	private static void testRead() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/marksheet", "root", "root");
		PreparedStatement pstmt = conn.prepareStatement("select * from marksheet");
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {

			System.out.print("\t" + rs.getInt(1));
			System.out.print("\t" + rs.getString(2));
			System.out.print("\t" + rs.getString(3));
			System.out.print("\t" + rs.getInt(4));
			System.out.println("\t" + rs.getInt(5));

		}
	}

	private static void testDelete(int id) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/marksheet", "root", "root");
		PreparedStatement pstmt = conn.prepareStatement("delete from marksheet where id = ?");
		pstmt.setInt(1, id);
		int i = pstmt.executeUpdate();
		System.out.println("Data Deleted =" + i);

	}
}