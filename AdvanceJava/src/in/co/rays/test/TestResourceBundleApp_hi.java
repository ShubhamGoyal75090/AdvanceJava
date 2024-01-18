package in.co.rays.test;

import java.util.ResourceBundle;

public class TestResourceBundleApp_hi {
	
	public static void main(String[] args) {
		
		ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.bundle.app_hi");
		
		System.out.println(rb.getString("greeting"));
	}

}
