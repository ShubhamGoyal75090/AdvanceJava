package in.co.rays.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserModel {

	public void add(UserBean bean) throws Exception {
		int pk = nextPk(bean);
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/marksheet", "root", "root");
		PreparedStatement pstmt = conn.prepareStatement("insert into user values(?,?,?,?,?,?,?)");

		pstmt.setInt(1, pk);
		pstmt.setString(2, bean.getFirst_name());
		pstmt.setString(3, bean.getLast_name());
		pstmt.setString(4, bean.getLogin_id());
		pstmt.setString(5, bean.getPassword());
		pstmt.setDate(6, new java.sql.Date(bean.getDob().getTime()));
		pstmt.setString(7, bean.getAddress());

		int i = pstmt.executeUpdate();

		System.out.println("Data inserted = " + pk);

	}

	public Integer nextPk(UserBean bean) throws Exception {

		int pk = 0;
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/marksheet", "root", "root");
		PreparedStatement pstmt = conn.prepareStatement("select max(id) from user");

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {

			pk = rs.getInt(1);

		}
		return pk + 1;

	}

	public void Update(UserBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/marksheet", "root", "root");
		PreparedStatement pstmt = conn.prepareStatement(
				"update user set first_name = ?, last_name = ?, login_id = ?, password = ?, dob = ?, address = ? where id = ?");

		pstmt.setString(1, bean.getFirst_name());
		pstmt.setString(2, bean.getLast_name());
		pstmt.setString(3, bean.getLogin_id());
		pstmt.setString(4, bean.getPassword());
		pstmt.setDate(5, new java.sql.Date(bean.getDob().getTime()));
		pstmt.setString(6, bean.getAddress());
		pstmt.setInt(7, bean.getId());
		pstmt.executeUpdate();

	}

	public void Delete(UserBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/marksheet", "root", "root");
		PreparedStatement pstmt = conn.prepareStatement("delete from user where id = ?");

		pstmt.setInt(1, bean.getId());
		pstmt.executeUpdate();

	}

	public List Search(UserBean bean, int PageNo, int PageSize) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/marksheet", "root", "root");
		StringBuffer sql = new StringBuffer("select * from user where 1=1");

		if (bean != null) {
			if (bean.getFirst_name() != null && bean.getFirst_name().length() > 0) {

				// if (bean.getFirst_name() != null) {
				sql.append(" and name like '" + bean.getFirst_name() + "%'");

			}
			if (bean.getDob() != null) {
				sql.append(" and dob like '" + new java.sql.Date(bean.getDob().getTime()) + "%'");
			}
		}
		if (PageSize > 0) {

			PageNo = (PageNo - 1) * PageSize;
			sql.append(" limit " + PageNo + ", " + PageSize);

		}
		System.out.println("sql======>>> " + sql);

		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		ResultSet rs = pstmt.executeQuery();
		List list = new ArrayList();
		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirst_name(rs.getString(2));
			bean.setLast_name(rs.getString(3));
			bean.setLogin_id(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(rs.getDate(6));
			bean.setAddress(rs.getString(7));

			list.add(bean);
		}

		return list;
	}

	public UserBean Authenticate(String loginid, String password) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/marksheet", "root", "root");
		PreparedStatement pstmt = conn.prepareStatement("select * from user where login_id = ? and password = ?");
		pstmt.setString(1, loginid);
		pstmt.setString(2, password);

		ResultSet rs = pstmt.executeQuery();
		UserBean bean = null;
		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirst_name(rs.getString(2));
			bean.setLast_name(rs.getString(3));
			bean.setLogin_id(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(rs.getDate(6));
			bean.setAddress(rs.getString(7));
			
			
			
		}
		return bean;

	}
}
