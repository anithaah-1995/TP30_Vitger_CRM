package jenkins;

import org.testng.annotations.Test;

public class sample1Test {

	
@Test(groups = "smoke")
	public void m1() {
	String BROWSER = System.getProperty("browser");
		System.out.println(" m1");
	}

}

