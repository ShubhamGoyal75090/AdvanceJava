package in.co.rays.Marksheet;

import java.util.Iterator;
import java.util.List;

public class TestMarksheet {

	public static void main(String[] args) throws Exception {

		// testAdd();
		// testUpdate();
		// testDelete();
		// testReadAll();
		// testFindByPk();
		testSearch();

	}

	private static void testAdd() throws Exception {

		MarksheetBean bean = new MarksheetBean();

		bean.setId(120);
		bean.setName("ayan");
		bean.setSubject("english");
		bean.setMarks(99);
		bean.setEnrollmentNo(121021255);

		MarksheetModel model = new MarksheetModel();

		model.add(bean);

	}

	private static void testUpdate() throws Exception {

		MarksheetBean bean = new MarksheetBean();

		bean.setEnrollmentNo(121021257);
		bean.setId(120);

		MarksheetModel model = new MarksheetModel();
		model.update(bean);

	}

	private static void testDelete() throws Exception {

		MarksheetModel model = new MarksheetModel();
		model.delete(120);
	}

	private static void testReadAll() throws Exception {

		MarksheetModel model = new MarksheetModel();
		model.readAll();
	}

	private static void testFindByPk() throws Exception {
		MarksheetModel model = new MarksheetModel();
		MarksheetBean bean = model.findByPk(107);

		if (bean != null) {
			System.out.println(bean.getId());
			System.out.println(bean.getName());
			System.out.println(bean.getSubject());
			System.out.println(bean.getMarks());
			System.out.println(bean.getEnrollmentNo());

		} else {
			System.out.println("Id not exits....!!");
		}

	}

	private static void testSearch() throws Exception {
		MarksheetModel model = new MarksheetModel();
		MarksheetBean bean = new MarksheetBean();
		// bean.setEnrollmentNo(121021214);
		bean.setName("s");
		List list = model.search(bean, 1, 5);
		Iterator it = list.iterator();
		while (it.hasNext()) {

			bean = (MarksheetBean) it.next();

			System.out.print("\t" + bean.getId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getSubject());
			System.out.print("\t" + bean.getMarks());
			System.out.println("\t" + bean.getEnrollmentNo());

		}

	}
}