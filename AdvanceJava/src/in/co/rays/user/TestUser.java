package in.co.rays.user;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TestUser {

	public static void main(String[] args) throws Exception {

		// testAdd();
		// testUpdate();
		// testDelete();
		 testSearch();
		//testAuth();

	}

	private static void testAuth() throws Exception {
		UserModel model = new UserModel();
		UserBean bean = model.Authenticate("shubham@gmail.com", "123");
		if (bean != null) {

			System.out.println(bean.getId());
			System.out.println(bean.getFirst_name());
			System.out.println(bean.getLast_name());
			System.out.println(bean.getLogin_id());
			System.out.println(bean.getPassword());
			System.out.println(bean.getDob());
			System.out.println(bean.getAddress());

		}
		else {
			System.out.println("loginid & password is invalid");
		}

	}

	private static void testSearch() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		UserModel model = new UserModel();
		UserBean bean = new UserBean();
		bean.setDob(sdf.parse("12/12/2023"));
		List list = model.Search(bean, 1, 5);
		Iterator it = list.iterator();
		while (it.hasNext()) {
			bean = (UserBean) it.next();

			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirst_name());
			System.out.print("\t" + bean.getLast_name());
			System.out.print("\t" + bean.getLogin_id());
			System.out.print("\t" + bean.getPassword());
			System.out.print("\t" + bean.getDob());
			System.out.println("\t" + bean.getAddress());

		}

	}

	private static void testDelete() throws Exception {
		UserBean bean = new UserBean();
		bean.setId(3);
		UserModel model = new UserModel();
		model.Delete(bean);

	}

	private static void testUpdate() throws Exception {
		UserBean bean = new UserBean();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		bean.setId(2);
		bean.setFirst_name("sat");
		bean.setLast_name("bisen");
		bean.setLogin_id("satyam@gmail.com");
		bean.setPassword("123");
		bean.setDob(sdf.parse("2023-12-12"));
		bean.setAddress("indore");

		UserModel model = new UserModel();
		model.Update(bean);
	}

	private static void testAdd() throws Exception {
		UserBean bean = new UserBean();

		// String s = "15-12-2003";
		// SimpleDateFormat sdf = new SimpleDateFormat();

		// Date d = sdf.parse(s);

		bean.setId(1);
		bean.setFirst_name("shubham");
		bean.setLast_name("goyal");
		bean.setLogin_id("shubham@gmail.com");
		bean.setPassword("123");
		bean.setDob(new SimpleDateFormat("dd-MM-yyyy").parse("16-03-2005"));
		bean.setAddress("indore");

		UserModel model = new UserModel();

		model.add(bean);

	}

}
