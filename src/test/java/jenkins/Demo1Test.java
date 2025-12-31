package jenkins;

import org.testng.annotations.Test;

public class Demo1Test {

	
	@Test(groups = "smoke")
	public void m1() {
		String BROWSER = System.getProperty("browser");
		System.out.println(" m1");
	}
	@Test(groups = "regression")
	public void m2() {
		String BROWSER = System.getProperty("browser");
		System.out.println(" m2");
	}
	
}
