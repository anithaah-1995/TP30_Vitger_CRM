package generic_libraries;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class IRetryImpClass implements IRetryAnalyzer {
	 int count = 0;
	    int retrylimit = 3;

	    @Override
	    public boolean retry(ITestResult iTestResult) {
	        if (count < retrylimit) {
	            count++;
	            return true;
	        }
	        return false;
	    }
}
