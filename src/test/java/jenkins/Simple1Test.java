package jenkins;

import org.testng.annotations.Test;

public class Simple1Test {


	
	@Test(groups = "smoke")
	public void m3() {
		String BROWSER = System.getProperty("browser");
		System.out.println(" m3");
	}

	
}
