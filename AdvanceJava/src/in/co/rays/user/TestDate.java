package in.co.rays.user;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate {

	public static void main(String[] args) throws Exception {
		Date d = new Date();
		Date today = new Date();
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		

		System.out.println(new java.sql.Date(d.getTime()));
	}

}
