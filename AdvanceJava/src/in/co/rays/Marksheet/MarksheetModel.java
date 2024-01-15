package in.co.rays.Marksheet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.user.UserBean;

public class MarksheetModel {

	public void add(MarksheetBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/marksheet", "root", "root");
		PreparedStatement pstmt = conn.prepareStatement("insert into marksheet values(?,?,?,?,?)");

		pstmt.setInt(1, bean.getId());
		pstmt.setString(2, bean.getName());
		pstmt.setString(3, bean.getSubject());
		pstmt.setInt(4, bean.getMarks());
		pstmt.setInt(5, bean.getEnrollmentNo());

		int i = pstmt.executeUpdate();
		System.out.println("Data inserted =" + i);
	}

	public void update(MarksheetBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/marksheet", "root", "root");
		PreparedStatement pstmt = conn.prepareStatement("update marksheet set enrollment_no = ? where id = ?");
		pstmt.setInt(1, bean.getEnrollmentNo());
		pstmt.setInt(2, bean.getId());

		int i = pstmt.executeUpdate();
		System.out.println("Updated data =" + i);

	}

	public void delete(int id) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/marksheet", "root", "root");
		PreparedStatement pstmt = conn.prepareStatement("delete from marksheet where id = ?");
		pstmt.setInt(1, id);
		;

		int i = pstmt.executeUpdate();
		System.out.println("Deleted data = " + i);

	}

	public void readAll() throws Exception {
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

	public MarksheetBean findByPk(int id) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/marksheet", "root", "root");
		PreparedStatement pstmt = conn.prepareStatement("select * from marksheet where id = ?");
		pstmt.setInt(1, id);
		ResultSet rs = pstmt.executeQuery();
		MarksheetBean bean = null;
		while (rs.next()) {

			bean = new MarksheetBean();
			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setSubject(rs.getString(3));
			bean.setMarks(rs.getInt(4));
			bean.setEnrollmentNo(rs.getInt(5));
		}
		return bean;

	}

	public List search(MarksheetBean bean, int PageNo, int PageSize) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/marksheet", "root", "root");
		StringBuffer sql = new StringBuffer("select * from marksheet where 1=1 ");
		System.out.println("sql======>>>>>>" + sql);
		if (bean != null) {

			 //if (bean.getName() != null && bean.getName().length() > 0) {
			if (bean.getName() != null) {

				sql.append(" and name like '" + bean.getName() + "%'");
			}

			if (bean.getEnrollmentNo() > 0) {
				sql.append(" and enrollment_no = " + bean.getEnrollmentNo());

			}

		}
		if (PageSize > 0) {

			PageNo = (PageNo - 1) * PageSize;
			sql.append(" limit " + PageNo + ", " + PageSize);

		}

		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		ResultSet rs = pstmt.executeQuery();

		List list = new ArrayList();

		while (rs.next()) {
			bean = new MarksheetBean();

			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setSubject(rs.getString(3));
			bean.setMarks(rs.getInt(4));
			bean.setEnrollmentNo(rs.getInt(5));

			list.add(bean);
		}
		return list;

	}
}