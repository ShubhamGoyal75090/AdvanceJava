package in.co.rays.test;

import java.util.Locale;
import java.util.ResourceBundle;

public class TestResourceBundleApp {
	
	public static void main(String[] args) {
		
		ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.bundle.app", new Locale("sp"));
	
		System.out.println(rb.getString("greeting"));
	//System.out.println(rb.getString());
	}

}
